package com.atguigu.book.dao.impl;

import com.atguigu.book.bean.OrderBean;
import com.atguigu.book.dao.OrderBeanDAO;
import com.atguigu.myssm.util.JDBCUtil;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import java.util.UUID;
import org.junit.jupiter.api.Test;

class OrderBeanDAOImplTest {

  private OrderBeanDAO orderBeanDAO = new OrderBeanDAOImpl();

  @Test
  void addOrderBean() throws SQLException {
    Connection conn = JDBCUtil.getConnection();
    OrderBean orderBean = new OrderBean();
    orderBean.setOrderNo(UUID.randomUUID().toString());
    orderBean.setOrderDate(new Date());
    orderBean.setOrderUserId(1);
    orderBean.setOrderMoney(10.0);
    orderBean.setOrderStatus(0);
    orderBeanDAO.addOrderBean(conn, orderBean);
    System.out.println(orderBean.getId());
    conn.close();
  }
}