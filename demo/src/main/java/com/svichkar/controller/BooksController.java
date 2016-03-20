package com.svichkar.controller;

import com.svichkar.model.Book;
import com.svichkar.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by konstantin on 3/19/2016.
 */
@RestController
public class BooksController {

    @Autowired
    private BookRepository repository;

    @RequestMapping(value = "/books", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Book> bookList() {
        return repository.findAll();
    }

    @RequestMapping(value = "/book",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            method = RequestMethod.POST)
    public void add(Book book) {
        repository.save(book);
    }

    @RequestMapping(value = "/book/{id}",
            method = RequestMethod.DELETE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public void delete(@PathVariable Long id) {
        repository.delete(id);
    }

    @RequestMapping(value = "/book/{id}",
            method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public void update(@PathVariable Long id, Book book) {
        repository.save(book);
    }


}
