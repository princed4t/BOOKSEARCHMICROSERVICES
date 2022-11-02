package com.jlcindiabookstore;
import javax.persistence.*;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name="mybookinventory",schema = "jlcbooksdb")
@ApiModel(value="it contain book id and book avaliable")
public class BookInventory {
@Id
@Column(name="book_id")
@ApiModelProperty(value="it contain book id")
private Integer bookId;
@Column(name="books_available")
@ApiModelProperty(value="it contains book avaliable")
private int booksAvailable;
public BookInventory(Integer bookId, int booksAvailable) {
	super();
	this.bookId = bookId;
	this.booksAvailable = booksAvailable;
}
public BookInventory() {
	super();
	// TODO Auto-generated constructor stub
}
public BookInventory(int booksAvailable) {
	super();
	this.booksAvailable = booksAvailable;
}
public Integer getBookId() {
	return bookId;
}
public void setBookId(Integer bookId) {
	this.bookId = bookId;
}
public int getBooksAvailable() {
	return booksAvailable;
}
public void setBooksAvailable(int booksAvailable) {
	this.booksAvailable = booksAvailable;
}
@Override
public String toString() {
	return "BookInventory [bookId=" + bookId + ", booksAvailable=" + booksAvailable + "]";
}

}
