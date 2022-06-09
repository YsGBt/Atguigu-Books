package com.atguigu.book.controller;

import com.atguigu.book.bean.Book;
import com.atguigu.book.service.BookService;
import java.util.List;
import javax.servlet.http.HttpSession;

public class BookController {

  private BookService bookService;

  public String index(HttpSession session) {
    List<Book> bookList = bookService.getBookList();
    session.setAttribute("bookList", bookList);
    return "index";
  }
}
