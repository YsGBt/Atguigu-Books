package com.atguigu.book.bean;

import java.io.Serializable;

public class OrderItem implements Serializable {

  //实现serializable接口。
  private static final long serialVersionUID = 73L;

  private Integer id;
  private Integer bookId;
  private Book book; // N:1
  private Integer buyCount;
  private Integer orderBeanId;
  private OrderBean orderBean; // N:1

  public OrderItem() {
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Integer getBookId() {
    return bookId;
  }

  public void setBookId(Integer bookId) {
    this.bookId = bookId;
  }

  public Book getBook() {
    return book;
  }

  public void setBook(Book book) {
    this.book = book;
  }

  public Integer getBuyCount() {
    return buyCount;
  }

  public void setBuyCount(Integer buyCount) {
    this.buyCount = buyCount;
  }

  public Integer getOrderBeanId() {
    return orderBeanId;
  }

  public void setOrderBeanId(Integer orderBeanId) {
    this.orderBeanId = orderBeanId;
  }

  public OrderBean getOrderBean() {
    return orderBean;
  }

  public void setOrderBean(OrderBean orderBean) {
    this.orderBean = orderBean;
  }

  @Override
  public String toString() {
    return "OrderItem{" +
        "id=" + id +
        ", bookId=" + bookId +
        ", buyCount=" + buyCount +
        ", orderBeanId=" + orderBeanId +
        '}';
  }
}
