package com.atguigu.book.dao;

import com.atguigu.book.bean.CartItem;
import com.atguigu.book.bean.User;
import java.sql.Connection;
import java.util.List;

public interface CartItemDAO {

  // 新增购物车项
  boolean addCartItem(Connection conn, CartItem cartItem);

  // 新增购物车项
  boolean addCartItem(Connection conn, Integer bookId, Integer userBean);

  // 修改特定的购物车项
  boolean updateCartItem(Connection conn, CartItem cartItem);

  // 获取特定用户的所有购物车项
  List<CartItem> getCartItemList(Connection conn, User user);

  // 删除指定的购物车项
  boolean delCartItem(Connection conn, CartItem cartItem);
}
