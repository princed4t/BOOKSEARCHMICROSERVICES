package com.jlcindiabookstore;

import javax.persistence.*;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


	@Entity
	@Table(name="mybookratings",schema = "jlcbooksdb")
	@ApiModel(value="itcontainbookrating")
	public class BookRating {
	@Id
	@Column(name="book_id")
	@ApiModelProperty(value="itcontainbookid")
	private Integer bookId;
	@Column(name="avg_rating")
	@ApiModelProperty(value="iitcontainavgrating")
	private double avgRating;
	@Column(name="number_of_searches")
	@ApiModelProperty(value="itcontainnumberofsearches")
	private int numberOfSearches;
	public BookRating() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BookRating(Integer bookId, double avgRating, int numberOfSearches) {
		super();
		this.bookId = bookId;
		this.avgRating = avgRating;
		this.numberOfSearches = numberOfSearches;
	}
	public BookRating(double avgRating, int numberOfSearches) {
		super();
		this.avgRating = avgRating;
		this.numberOfSearches = numberOfSearches;
	}
	public Integer getBookId() {
		return bookId;
	}
	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}
	public double getAvgRating() {
		return avgRating;
	}
	public void setAvgRating(double avgRating) {
		this.avgRating = avgRating;
	}
	public int getNumberOfSearches() {
		return numberOfSearches;
	}
	public void setNumberOfSearches(int numberOfSearches) {
		this.numberOfSearches = numberOfSearches;
	}
	@Override
	public String toString() {
		return "BookRating [bookId=" + bookId + ", avgRating=" + avgRating + ", numberOfSearches=" + numberOfSearches
				+ "]";
	}
	

}
