package com.atguigu.book.service.impl;

import com.atguigu.book.bean.Book;
import com.atguigu.book.dao.BookDAO;
import com.atguigu.book.service.BookService;
import com.atguigu.myssm.util.ConnUtil;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class BookServiceImpl implements BookService {

  private BookDAO bookDAO;

  @Override
  public List<Book> getBookList() {
    try {
      Connection conn = ConnUtil.getConnection();
      return bookDAO.getBookList(conn, 0);
    } catch (SQLException e) {
      throw new RuntimeException("BookService Failure: getBookList");
    }
  }
}
