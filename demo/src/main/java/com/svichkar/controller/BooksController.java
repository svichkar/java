package com.svichkar.controller;

import com.svichkar.model.Book;
import com.svichkar.repository.BookRepository;
import com.svichkar.util.ReadExcelUtil;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.util.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
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
            consumes = MediaType.APPLICATION_JSON_VALUE,
            method = RequestMethod.POST)
    public void add(@RequestBody Book book) {
        System.out.println(book.toString());
        repository.save(book);
    }

    @RequestMapping(value = "/book/{id}",
            method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id) {
        repository.delete(id);
    }

    @RequestMapping(value = "/book/{id}",
            method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public void update(@PathVariable Long id, @RequestBody Book book) {
        repository.save(book);
    }

    @RequestMapping(value = "/book/uploadSimple",
            method = RequestMethod.POST,
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public String upload(@RequestParam(value = "file") MultipartFile file) throws IOException {

        HashMap<String, List<String>> data = ReadExcelUtil.readData(file);
        StringBuilder response = new StringBuilder();
        data.forEach((String key, List<String> value) -> {
            response.append("Data for ").append(key).append(" column:\n");
            value.forEach((String val) -> response.append(val).append("\n"));
        });
        return response.toString();
    }

    @RequestMapping(value = "/book/upload",
            method = RequestMethod.POST,
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public void uploadToDB(@RequestParam(value = "file") MultipartFile file) throws IOException {

        HashMap<String, List<String>> data = ReadExcelUtil.readData(file);
        List<String> titles = data.get("TITLE");
        List<String> authors = data.get("AUTHOR");

        titles.forEach((title) ->  repository.saveAndFlush(new Book(title, authors.get(titles.indexOf(title)))));
    }

    @RequestMapping(value = "/book/download",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    public void download (HttpServletResponse response) throws IOException {

        List books = repository.findAll();
        Workbook workBook = ReadExcelUtil.prepareWorkBook(books);
        InputStream inputStream = new FileInputStream("books.xlsx");
        OutputStream outputStream = response.getOutputStream();
        workBook.write(outputStream);
        IOUtils.copy(inputStream, outputStream);
        response.flushBuffer();
    }
}

