package com.atguigu.book.dao.impl;

import com.atguigu.book.bean.OrderBean;
import com.atguigu.book.bean.User;
import com.atguigu.book.dao.OrderBeanDAO;
import com.atguigu.myssm.basedao.BaseDAO;
import java.sql.Connection;
import java.util.List;

public class OrderBeanDAOImpl extends BaseDAO<OrderBean> implements OrderBeanDAO {

  @Override
  public boolean addOrderBean(Connection conn, OrderBean orderBean) {
    String sql = "insert into t_order(orderNo, orderDate, orderUser, orderMoney, orderStatus) values(?,?,?,?,?)";
    int count = update(conn, sql, orderBean.getOrderNo(), orderBean.getOrderDate(),
        orderBean.getOrderUserId(), orderBean.getOrderMoney(), orderBean.getOrderStatus());
    // 这里需要给orderBean赋id值，但是BaseDAO没有考虑到这个情况，所以又在数据库查询了一遍
    // 正确做法是在BaseDAO里面加一个insert方法，调用queryRunner的insert方法并且使用new ScalarHandler<Long>()获取id
    // 然后再直接赋值给orderBean
    String sql2 = "select id from t_order where orderNo = ?";
    Integer id = (Integer) getValue(conn, sql2, orderBean.getOrderNo());
    orderBean.setId(id);
    return count == 1;
  }

  @Override
  public List<OrderBean> getOrderBeanList(Connection conn, User user) {
    String sql = "select id, orderNo, orderDate, orderUser orderUserId, orderMoney, orderStatus from t_order where orderUser = ?";
    List<OrderBean> orderBeanList = getBeanList(conn, sql, user.getId());
    return orderBeanList;
  }
}
