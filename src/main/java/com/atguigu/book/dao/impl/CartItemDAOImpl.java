package com.atguigu.book.dao.impl;

import com.atguigu.book.bean.CartItem;
import com.atguigu.book.bean.User;
import com.atguigu.book.dao.CartItemDAO;
import com.atguigu.myssm.basedao.BaseDAO;
import java.sql.Connection;
import java.util.List;

public class CartItemDAOImpl extends BaseDAO<CartItem> implements CartItemDAO {

  @Override
  public boolean addCartItem(Connection conn, CartItem cartItem) {
    String sql = "insert into t_cart_item(book, buyCount, userBean) values(?,?,?)";
    int count = update(conn, sql, cartItem.getBookId(), cartItem.getBuyCount(),
        cartItem.getUserBeanId());
    return count == 1;
  }

  @Override
  public boolean addCartItem(Connection conn, Integer bookId, Integer userBean) {
    CartItem cartItem = new CartItem();
    cartItem.setBookId(bookId);
    cartItem.setUserBeanId(userBean);
    return addCartItem(conn, cartItem);
  }

  @Override
  public boolean updateCartItem(Connection conn, CartItem cartItem) {
    String sql = "update t_cart_item set book=?, buyCount=?, userBean=? where id=?";
    int count = update(conn, sql, cartItem.getBookId(), cartItem.getBuyCount(),
        cartItem.getUserBeanId(), cartItem.getId());
    return count == 1;
  }

  @Override
  public List<CartItem> getCartItemList(Connection conn, User user) {
    String sql = "select id, book bookId, buyCount, userBean userBeanId from t_cart_item where userBean = ?";
    List<CartItem> cartItemList = getBeanList(conn, sql, user.getId());
    return cartItemList;
  }

  @Override
  public boolean delCartItem(Connection conn, CartItem cartItem) {
    String sql = "delete from t_cart_item where id = ?";
    int count = update(conn, sql, cartItem.getId());
    return count == 1;
  }
}
