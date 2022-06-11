package com.atguigu.book.dao;

import com.atguigu.book.bean.OrderBean;
import com.atguigu.book.bean.User;
import java.sql.Connection;
import java.util.List;

public interface OrderBeanDAO {

  // 添加订单
  boolean addOrderBean(Connection conn, OrderBean orderBean);

  // 获取指定用户的订单列表
  List<OrderBean> getOrderBeanList(Connection conn, User user);
}
