package com.svichkar;

import com.svichkar.controller.BooksController;
import com.svichkar.repository.BookRepository;
import com.svichkar.util.ReadExcelUtil;
import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = DemoApplication.class)
@WebAppConfiguration
public class DemoApplicationTests {

	@Autowired
	private BookRepository repository;
	@Autowired
	private BooksController booksController;

	@Test
	public void contextLoads() throws IOException {

		File file = FileUtils.getFile("D:\\OF - Summary_api_calls.xls");
		InputStream inputStream = new FileInputStream(file);
		HSSFWorkbook workbook = new HSSFWorkbook(inputStream);


		workbook.getSheetAt(0);


		List<HSSFRow> titleList = new ArrayList<>();
		//sheetList.forEach((HSSFSheet sheet) -> titleList.add(sheet.getRow(0)));

		titleList.forEach((HSSFRow row) -> row.forEach((Cell cell) -> System.out.println(cell.getStringCellValue())));


		StringBuilder response = new StringBuilder();


		ReadExcelUtil.readData(file);
	}



}
