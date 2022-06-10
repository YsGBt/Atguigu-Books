package com.atguigu.book.dao.impl;

import com.atguigu.book.bean.Book;
import com.atguigu.book.dao.BookDAO;
import com.atguigu.myssm.basedao.BaseDAO;
import java.sql.Connection;
import java.util.List;

public class BookDAOImpl extends BaseDAO<Book> implements BookDAO {

  @Override
  public Book getBookById(Connection conn, Integer id) {
    String sql = "select id, bookImg, bookName, price, author, saleCount, bookCount, bookStatus from t_book where id = ?";
    Book book = getBean(conn, sql, id);
    return book;
  }

  @Override
  public List<Book> getBookList(Connection conn) {
    String sql = "select id, bookImg, bookName, price, author, saleCount, bookCount, bookStatus from t_book";
    List<Book> bookList = getBeanList(conn, sql);
    return bookList;
  }

  @Override
  public List<Book> getBookList(Connection conn, Integer bookStatus) {
    String sql = "select id, bookImg, bookName, price, author, saleCount, bookCount, bookStatus from t_book where bookStatus = ?";
    List<Book> bookList = getBeanList(conn, sql, bookStatus);
    return bookList;
  }

  @Override
  public List<Book> getBookList(Connection conn, Integer bookStatus, Integer bookPerPage,
      Integer pageNo) {
    return getBookList(conn, bookStatus, 0, Integer.MAX_VALUE, bookPerPage, pageNo);
  }

  @Override
  public List<Book> getBookList(Connection conn, Integer bookStatus, Integer minPrice,
      Integer maxPrice, Integer bookPerPage,
      Integer pageNo) {
    if (pageNo <= 0) {
      throw new IllegalArgumentException("Invalid Page Number");
    }
    if (bookPerPage <= 0) {
      throw new IllegalArgumentException("Invalid Number Of Book Per Page");
    }
    String sql = "select id, bookImg, bookName, price, author, saleCount, bookCount, bookStatus from t_book where price >= ? and price <= ? and bookStatus = ? limit ?,?";
    Integer start = bookPerPage * (pageNo - 1);
    List<Book> bookList = getBeanList(conn, sql, minPrice, maxPrice, bookStatus, start, bookPerPage);
    return bookList;
  }
}
