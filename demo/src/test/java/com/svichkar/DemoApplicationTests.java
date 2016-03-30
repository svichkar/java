package com.svichkar;

import com.svichkar.controller.BooksController;
import com.svichkar.repository.BookRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.servlet.DispatcherServlet;

import java.io.IOException;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = DemoApplication.class)
@WebAppConfiguration
public class DemoApplicationTests {

	@Autowired
	private BookRepository repository;
	@Autowired
	private BooksController booksController;
	@Autowired
	DispatcherServlet servletContext;

	@Test
	public void contextLoads() throws IOException {

		servletContext.getWebApplicationContext().getServletContext().getRealPath("/");
	}



}
