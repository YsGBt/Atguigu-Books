package com.atguigu.book.dao;

import com.atguigu.book.bean.OrderBean;
import java.sql.Connection;

public interface OrderBeanDAO {

  // 添加订单
  boolean addOrderBean(Connection conn, OrderBean orderBean);
}
