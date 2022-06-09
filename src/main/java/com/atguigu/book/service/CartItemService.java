package com.atguigu.book.service;

import com.atguigu.book.bean.Cart;
import com.atguigu.book.bean.CartItem;
import com.atguigu.book.bean.User;

public interface CartItemService {

  void addCartItem(CartItem cartItem);

  void updateCartItem(CartItem cartItem);

  void addOrUpdateCartItem(Cart cart, CartItem cartItem);

  // 加载特定用户的购物车信息
  Cart getCart(User user);
}
