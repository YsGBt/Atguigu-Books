package com.atguigu.book.controller;

import com.atguigu.book.bean.OrderBean;
import com.atguigu.book.bean.User;
import com.atguigu.book.service.OrderBeanService;
import java.util.Date;
import java.util.UUID;
import javax.servlet.http.HttpSession;

public class OrderController {

  private OrderBeanService orderBeanService;

  // 结账
  public String checkout(HttpSession session) {
    User user = (User) session.getAttribute("currentUser");

    OrderBean orderBean = new OrderBean();
    Date now = new Date();
    int year = now.getYear();
    int month = now.getMonth();
    int day = now.getDate();
    int hour = now.getHours();
    int min = now.getMinutes();
    int sec = now.getSeconds();
    orderBean.setOrderNo(
        UUID.randomUUID().toString() + "_" + year + month + day + hour + min + sec);
    orderBean.setOrderDate(now);
    orderBean.setOrderUser(user);
    orderBean.setOrderUserId(user.getId());
    orderBean.setOrderMoney(user.getCart().getTotalMoney());
    orderBean.setOrderStatus(0);

    orderBeanService.addOrderBean(orderBean);

    return "index";
  }
}
