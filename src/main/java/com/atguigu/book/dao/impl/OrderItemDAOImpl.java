package com.atguigu.book.dao.impl;

import com.atguigu.book.bean.OrderItem;
import com.atguigu.book.dao.OrderItemDAO;
import com.atguigu.myssm.basedao.BaseDAO;
import java.sql.Connection;

public class OrderItemDAOImpl extends BaseDAO<OrderItem> implements OrderItemDAO {

  @Override
  public boolean addOrderItem(Connection conn, OrderItem orderItem) {
    String sql = "insert into t_order_item(book, buyCount, orderBean) values(?,?,?)";
    int count = update(conn, sql, orderItem.getBookId(), orderItem.getBuyCount(), orderItem.getOrderBeanId());
    return count == 1;
  }
}
