package com.atguigu.book.bean;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class OrderBean implements Serializable {
  //实现serializable接口。
  private static final long serialVersionUID = 73L;

  private Integer id;
  private String orderNo;
  private Date orderDate;
  private Integer orderUserId;
  private User orderUser;
  private Double orderMoney;
  private Integer orderStatus;

  private List<OrderItem> orderItemList; // 1:N

  private Integer totalBookCount;

  public OrderBean() {
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getOrderNo() {
    return orderNo;
  }

  public void setOrderNo(String orderNo) {
    this.orderNo = orderNo;
  }

  public Date getOrderDate() {
    return orderDate;
  }

  public void setOrderDate(Date orderDate) {
    this.orderDate = orderDate;
  }

  public Integer getOrderUserId() {
    return orderUserId;
  }

  public void setOrderUserId(Integer orderUserId) {
    this.orderUserId = orderUserId;
  }

  public User getOrderUser() {
    return orderUser;
  }

  public void setOrderUser(User orderUser) {
    this.orderUser = orderUser;
  }

  public Double getOrderMoney() {
    return orderMoney;
  }

  public void setOrderMoney(Double orderMoney) {
    this.orderMoney = orderMoney;
  }

  public Integer getOrderStatus() {
    return orderStatus;
  }

  public void setOrderStatus(Integer orderStatus) {
    this.orderStatus = orderStatus;
  }

  public List<OrderItem> getOrderItemList() {
    return orderItemList;
  }

  public void setOrderItemList(List<OrderItem> orderItemList) {
    this.orderItemList = orderItemList;
  }

  public void setTotalBookCount(Integer totalBookCount) {
    this.totalBookCount = totalBookCount;
  }

  public Integer getTotalBookCount() {
    return totalBookCount;
  }

  @Override
  public String toString() {
    return "OrderBean{" +
        "id=" + id +
        ", orderNo='" + orderNo + '\'' +
        ", orderDate=" + orderDate +
        ", orderUserId=" + orderUserId +
        ", orderMoney=" + orderMoney +
        ", orderStatus=" + orderStatus +
        '}';
  }
}
