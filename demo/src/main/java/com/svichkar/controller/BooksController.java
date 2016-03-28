package com.svichkar.controller;

import com.svichkar.model.Book;
import com.svichkar.repository.BookRepository;
import com.svichkar.util.ReadExcelUtil;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
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

    @RequestMapping(value = "/book/upload",
            method = RequestMethod.POST,
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public String upload(@RequestParam(value = "file", required = true) MultipartFile file) throws IOException {

        HSSFWorkbook workbook = new HSSFWorkbook(file.getInputStream());
        int index = workbook.getActiveSheetIndex();
        StringBuilder response = new StringBuilder();

        HSSFSheet sheet = workbook.getSheetAt(index);
        int max = sheet.getLastRowNum();
        for (int i = 0; i < max; i++) {
            HSSFRow row = sheet.getRow(i);
            for (int j = 0; j < row.getLastCellNum(); j++) {
                response.append(ReadExcelUtil.getCellValue(row.getCell(j)));
            }
        }
        return response.toString();
    }

}

