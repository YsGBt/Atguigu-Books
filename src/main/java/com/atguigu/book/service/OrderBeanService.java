package com.atguigu.book.service;

import com.atguigu.book.bean.OrderBean;
import com.atguigu.book.bean.User;
import java.util.List;

public interface OrderBeanService {

  void addOrderBean(OrderBean orderBean);

  List<OrderBean> getOrderBeanList(User user);
}
