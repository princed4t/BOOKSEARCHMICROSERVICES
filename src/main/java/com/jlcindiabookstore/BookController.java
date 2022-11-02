package com.jlcindiabookstore;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.ApiOperation;


@CrossOrigin
@RestController
public class BookController {
	static Logger log = LoggerFactory.getLogger(BookController.class);
	@Autowired
	BookService bookService;

	@GetMapping("/mybooks/{author}/{category}")
	@ApiOperation(value = " getBooks", response = List.class, notes = "Returns List ofBooks for given Author and Category")
	public List<Book> getBooks(@PathVariable String author, @PathVariable String category) {
		log.info("---BookController---getBooks()-----");
		System.out.println(author + "\t" + category);
		return bookService.getBooks(author, category);
	}

	@GetMapping("/mybook/{bookId}")
	@ApiOperation(value = " getBookById", response = BookInfo.class, notes = "ReturnsBookInfo for given BID")
	public BookInfo getBookById(@PathVariable Integer bookId) {
		log.info("---BookController---getBookById()-----");
		return bookService.getBookInfo(bookId);
	}


}
