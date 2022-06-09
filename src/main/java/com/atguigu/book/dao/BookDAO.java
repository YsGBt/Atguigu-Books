package com.atguigu.book.dao;

import com.atguigu.book.bean.Book;
import java.sql.Connection;
import java.util.List;

public interface BookDAO {

  List<Book> getBookList(Connection conn);

  List<Book> getBookList(Connection conn, Integer bookStatus);

  List<Book> getBookList(Connection conn, Integer bookStatus, Integer bookPerPage, Integer pageNo);

  List<Book> getBookList(Connection conn, Integer bookStatus, Integer minPrice, Integer maxPrice, Integer bookPerPage, Integer pageNo);
}
