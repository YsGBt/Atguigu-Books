package com.atguigu.book.service;

import com.atguigu.book.bean.Cart;
import com.atguigu.book.bean.CartItem;
import com.atguigu.book.bean.User;
import java.util.List;

public interface CartItemService {

  void addCartItem(CartItem cartItem);

  void updateCartItem(CartItem cartItem);

  void addOrUpdateCartItem(Cart cart, CartItem cartItem);

  // 获取指定用户的所有购物车项列表 (需要注意的是，这个方法内部查询的时候，会将book的详细信息设置进去)
  List<CartItem> getCartItemList(User user);

  // 加载特定用户的购物车信息
  Cart getCart(User user);
}
