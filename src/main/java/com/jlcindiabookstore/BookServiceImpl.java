package com.jlcindiabookstore;

import java.util.ArrayList;
import java.util.List;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import com.jlcindiarabbitmq.BookInventoryInfo;
import com.jlcindiarabbitmq.BookRatingInfo;

@Service
@Transactional
public class BookServiceImpl implements BookService {
	@Autowired
	BookDao bd;
	@Autowired
	BookInventoryDao bid;
	@Autowired
	BookRatingDao brd;

	@Override
	public List<Book> getBooks(String author, String category) {
		List<Book> mybooks = new ArrayList<>();
		if (author.equals("All Authors") && category.equals("All Categories")) {
			mybooks = bd.findAll();
		} else if (author.equals("All Authors") && !category.equals("All Categories")) {
			mybooks = bd.getBooksByCategory(category);
		} else if (!author.equals("All Authors") && category.equals("All Categories")) {
			mybooks = bd.getBooksByAuthor(author);
		} else {
			mybooks = bd.getBooksByAuthorAndCategory(author, category);
		}
		return mybooks;
	}

	public BookInfo getBookInfo(Integer bookId) {
		BookInfo bookInfo = new BookInfo();
		// 1. Book Details
		Book book = bd.findById(bookId).get();
		bookInfo.setBookId(book.getBookId()); // 1
		bookInfo.setBookName(book.getBookName());// 2
		bookInfo.setAuthor(book.getAuthor()); // 3
		bookInfo.setPublications(book.getPublications());// 4
		bookInfo.setCategory(book.getCategory());// 5
		// 2. Book Rating Details
		BookRating bookRating = brd.findById(bookId).get();
		bookInfo.setAvgRating(bookRating.getAvgRating());// 6
		bookInfo.setNumberOfSearches(bookRating.getNumberOfSearches());// 7

		// 3. Book Inventory Details
		BookInventory bookInventory = bid.findById(bookId).get();
		bookInfo.setBooksAvailable(bookInventory.getBooksAvailable());// 8
		// 4.Book Price Details – Invoking BookPriceMS
		RestTemplate bookPriceRest = new RestTemplate();
		String endpoint = "http://localhost:9000/bookPrice/" + bookId;
		BookPriceInfo bpInfo = bookPriceRest.getForObject(endpoint, BookPriceInfo.class);
  		bookInfo.setPrice(bpInfo.getPrice());// 9
		bookInfo.setOffer(bpInfo.getOffer());// 10
		return bookInfo;
	}

	@RabbitListener(queues ="mybook.ratings.queue")
	public void updateBookRating(BookRatingInfo bookRating){
		 BookRating bi=new BookRating();
		 bi.setBookId(bookRating.getBookId());
		 bi.setAvgRating(bookRating.getAvgRating());
		 bi.setNumberOfSearches(bookRating.getNumberOfSearches());
		 brd.save(bi);
		 
		

	}
	@RabbitListener(queues = "myinventory.queue")
	public void updateBookInventory(BookInventoryInfo bookInventory){
		BookInventory bi=new BookInventory();
		bi.setBookId(bookInventory.getBookId());
		bi.setBooksAvailable(bookInventory.getBooksAvailable());
		bid.save(bi);
		

	}

}
