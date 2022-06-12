package com.atguigu.book.bean;

import java.io.Serializable;
import java.math.BigDecimal;

// 我们应该还需要设计一个Cart类，代表购物车这个实体
public class CartItem implements Serializable {

  //实现serializable接口。
  private static final long serialVersionUID = 73L;

  private Integer id;
  private Integer bookId;
  private Book book;
  private Integer buyCount;
  private Integer userBeanId;
  private User userBean;

  private Double totalMoney; // book.price * buyCount

  public CartItem() {
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

  public Integer getUserBeanId() {
    return userBeanId;
  }

  public void setUserBeanId(Integer userBeanId) {
    this.userBeanId = userBeanId;
  }

  public User getUserBean() {
    return userBean;
  }

  public void setUserBean(User userBean) {
    this.userBean = userBean;
  }

  public Double getTotalMoney() {
    return getBigDecimalTotalMoney().doubleValue();
  }

  public BigDecimal getBigDecimalTotalMoney() {
    BigDecimal bigDecimalPrice = new BigDecimal(this.book.getPrice() + "");
    BigDecimal bigDecimalBuyCount = new BigDecimal(this.buyCount + "");
    BigDecimal bigDecimalTotalMoney = bigDecimalPrice.multiply(bigDecimalBuyCount);
    return bigDecimalTotalMoney;
  }

  @Override
  public String toString() {
    return "CartItem{" +
        "id=" + id +
        ", bookId=" + bookId +
        ", buyCount=" + buyCount +
        ", userBeanId=" + userBeanId +
        '}';
  }
}
