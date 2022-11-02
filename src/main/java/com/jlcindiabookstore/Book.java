package com.jlcindiabookstore;

import javax.persistence.*;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
/*
* @Author : prince dubey
* @company :  prince  project
* */
@Entity
@Table(name="mybooks",schema = "jlcbooksdb")
@ApiModel(value="it contain bookid,bookname,bookauthor,bookpublications,bookcategory")
public class Book {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
@Column(name="book_id")
@ApiModelProperty(value="itcontainid")
private Integer bookId;
@Column(name="book_name")
@ApiModelProperty(value="itcontainbookname")
private String bookName;
@Column(name="author")
@ApiModelProperty(value="itcontainauthor")
private String author;
@Column(name="publications")
@ApiModelProperty(value="itcontainpublication")
private String publications;
@Column(name="category")
@ApiModelProperty(value="itcontaincategory")
private String category;
public Book() {
	super();
	// TODO Auto-generated constructor stub
}
public Book(String bookName, String author, String publications, String category) {
	super();
	this.bookName = bookName;
	this.author = author;
	this.publications = publications;
	this.category = category;
}
public Book(Integer bookId, String bookName, String author, String publications, String category) {
	super();
	this.bookId = bookId;
	this.bookName = bookName;
	this.author = author;
	this.publications = publications;
	this.category = category;
}
public Integer getBookId() {
	return bookId;
}
public void setBookId(Integer bookId) {
	this.bookId = bookId;
}
public String getBookName() {
	return bookName;
}
public void setBookName(String bookName) {
	this.bookName = bookName;
}
public String getAuthor() {
	return author;
}
public void setAuthor(String author) {
	this.author = author;
}
public String getPublications() {
	return publications;
}
public void setPublications(String publications) {
	this.publications = publications;
}
public String getCategory() {
	return category;
}
public void setCategory(String category) {
	this.category = category;
}
@Override
public String toString() {
	return "Book [bookId=" + bookId + ", bookName=" + bookName + ", author=" + author + ", publications=" + publications
			+ ", category=" + category + "]";
}


}
