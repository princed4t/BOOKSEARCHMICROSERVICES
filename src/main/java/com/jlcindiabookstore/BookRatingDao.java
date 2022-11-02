package com.jlcindiabookstore;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRatingDao extends JpaRepository<BookRating,Integer>{

}
