package com.atguigu.book.dao;

import com.atguigu.book.bean.OrderBean;
import com.atguigu.book.bean.OrderItem;
import java.sql.Connection;

public interface OrderItemDAO {

  // 添加订单项
  boolean addOrderItem(Connection conn, OrderItem orderItem);

  Integer getTotalBookCountByOrderBean(Connection conn, OrderBean orderBean);

}
