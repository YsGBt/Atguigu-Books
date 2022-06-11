package com.atguigu.book.dao.impl;

import com.atguigu.book.bean.OrderBean;
import com.atguigu.book.bean.OrderItem;
import com.atguigu.book.dao.OrderItemDAO;
import com.atguigu.myssm.basedao.BaseDAO;
import java.math.BigDecimal;
import java.sql.Connection;

public class OrderItemDAOImpl extends BaseDAO<OrderItem> implements OrderItemDAO {

  @Override
  public boolean addOrderItem(Connection conn, OrderItem orderItem) {
    String sql = "insert into t_order_item(book, buyCount, orderBean) values(?,?,?)";
    int count = update(conn, sql, orderItem.getBookId(), orderItem.getBuyCount(), orderItem.getOrderBeanId());
    return count == 1;
  }

  @Override
  public Integer getTotalBookCountByOrderBean(Connection conn, OrderBean orderBean) {
    String sql = "select sum(buyCount) from t_order_item where orderBean = ?";
    Object count = getValue(conn, sql, orderBean.getId());
    if (count != null) {
      return ((BigDecimal) count).intValue();
    }
    return 0;
  }
}
