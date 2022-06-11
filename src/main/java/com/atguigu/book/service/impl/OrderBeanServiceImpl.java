package com.atguigu.book.service.impl;

import com.atguigu.book.bean.CartItem;
import com.atguigu.book.bean.OrderBean;
import com.atguigu.book.bean.OrderItem;
import com.atguigu.book.bean.User;
import com.atguigu.book.dao.CartItemDAO;
import com.atguigu.book.dao.OrderBeanDAO;
import com.atguigu.book.dao.OrderItemDAO;
import com.atguigu.book.service.OrderBeanService;
import com.atguigu.myssm.util.ConnUtil;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class OrderBeanServiceImpl implements OrderBeanService {

  private OrderBeanDAO orderBeanDAO;
  private OrderItemDAO orderItemDAO;
  private CartItemDAO cartItemDAO;

  @Override
  public void addOrderBean(OrderBean orderBean) {
    try {
      Connection conn = ConnUtil.getConnection();
      //    1) 订单表添加一条记录
      orderBeanDAO.addOrderBean(conn, orderBean); // 执行完这一步，orderBean中的id是有值的
      // orderBean中的orderItemList是空的，此处我们应该根据用户的购物车中的购物车项去转换成一个一个的订单项
      User user = orderBean.getOrderUser();
      Map<Integer, CartItem> cartItemMap = user.getCart().getCartItemMap();

      for (CartItem cartItem : cartItemMap.values()) {
        //    2) 订单详情表添加n条记录
        OrderItem orderItem = new OrderItem();
        orderItem.setBookId(cartItem.getBookId());
        orderItem.setBuyCount(cartItem.getBuyCount());
        orderItem.setOrderBeanId(orderBean.getId());
        orderItemDAO.addOrderItem(conn, orderItem);
        //    3) 购物车项表中需要删除对应的n条记录
        cartItemDAO.delCartItem(conn, cartItem);
      }

      // 清空购物车
      cartItemMap.clear();
//      List<OrderItem> orderItemList = orderBean.getOrderItemList();
//      for (OrderItem orderItem : orderItemList) {
//        orderItem.setOrderBeanId(orderBean.getId());
//        orderItemDAO.addOrderItem(conn, orderItem);
//      }
    } catch (SQLException e) {
      throw new RuntimeException("OrderBeanServiceImpl Failure: addOrderBean");
    }
  }

  @Override
  public List<OrderBean> getOrderBeanList(User user) {
    try {
      Connection conn = ConnUtil.getConnection();
      List<OrderBean> orderBeanList = orderBeanDAO.getOrderBeanList(conn, user);
      for (OrderBean orderBean : orderBeanList) {
        orderBean.setTotalBookCount(orderItemDAO.getTotalBookCountByOrderBean(conn, orderBean));
      }
      return orderBeanList;
    } catch (SQLException e) {
      throw new RuntimeException("OrderBeanServiceImpl Failure: getOrderBeanList");
    }
  }
}
