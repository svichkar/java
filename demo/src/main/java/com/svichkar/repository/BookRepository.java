package com.svichkar.repository;

import com.svichkar.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by konstantin on 3/19/2016.
 */
public interface BookRepository extends JpaRepository<Book, Long> {
}
