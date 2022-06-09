package com.atguigu.book.service.impl;

import com.atguigu.book.bean.Cart;
import com.atguigu.book.bean.CartItem;
import com.atguigu.book.bean.User;
import com.atguigu.book.dao.CartItemDAO;
import com.atguigu.book.service.CartItemService;
import com.atguigu.myssm.util.ConnUtil;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CartItemServiceImpl implements CartItemService {

  private CartItemDAO cartItemDAO;

  @Override
  public void addCartItem(CartItem cartItem) {
    try {
      Connection conn = ConnUtil.getConnection();
      cartItemDAO.addCartItem(conn, cartItem);
    } catch (SQLException e) {
      throw new RuntimeException("CartItemServiceImpl Failure: addCartItem");
    }
  }

  @Override
  public void updateCartItem(CartItem cartItem) {
    try {
      Connection conn = ConnUtil.getConnection();
      cartItemDAO.updateCartItem(conn, cartItem);
    } catch (SQLException e) {
      throw new RuntimeException("CartItemServiceImpl Failure: updateCartItem");
    }
  }

  @Override
  public void addOrUpdateCartItem(Cart cart, CartItem cartItem) {
    // 判断当前用户的购物车中是否有这本书的CartItem，有->update, 无->add
    // 1. 如果当前用户的购物车中已经存在这个图书了，那么将购物车中这本图书的数量+1
    // 2. 否则，在我的购物车中新增一个这本图书的CartItem，数量是1
    if (cart != null) {
      Map<Integer, CartItem> cartItemMap= cart.getCartItemMap();
      if (cartItemMap == null) {
        cartItemMap = new HashMap<>();
      }

      if (cartItemMap.containsKey(cartItem.getBookId())) {
        CartItem cartItemTemp= cartItemMap.get(cartItem.getBookId());
        cartItemTemp.setBuyCount(cartItemTemp.getBuyCount() + 1);
        updateCartItem(cartItemTemp);
      } else {
        addCartItem(cartItem);
      }
    } else { // 连购物车都没有
      addCartItem(cartItem);
    }
  }

  @Override
  public Cart getCart(User user) {
    try {
      Connection conn = ConnUtil.getConnection();
      List<CartItem> cartItemList = cartItemDAO.getCartItemList(conn, user);
      Map<Integer, CartItem> cartItemMap = new HashMap<>();
      for (CartItem cartItem : cartItemList) {
        cartItemMap.put(cartItem.getBookId(), cartItem);
      }
      Cart cart = new Cart();
      cart.setCartItemMap(cartItemMap);
      return cart;
    } catch (SQLException e) {
      throw new RuntimeException("CartItemServiceImpl Failure: updateCartItem");
    }
  }
}
