package com.jlcindiabookstore;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BookDao extends JpaRepository<Book,Integer>{
	
	
	
	public List<Book> getBooksByCategory(String category);
	public List<Book> getBooksByAuthor(String author);
	public List<Book> getBooksByAuthorAndCategory(String author,String category);
	

}
