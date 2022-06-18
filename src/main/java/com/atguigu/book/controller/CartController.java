package com.atguigu.book.controller;

import com.atguigu.book.bean.Cart;
import com.atguigu.book.bean.CartItem;
import com.atguigu.book.bean.User;
import com.atguigu.book.service.CartItemService;
import com.google.gson.Gson;
import javax.servlet.http.HttpSession;

public class CartController {

  private CartItemService cartItemService;

  // 加载当前用户的购物车信息
  public String index(HttpSession session) {
    User user = (User) session.getAttribute("currentUser");
    Cart cart = cartItemService.getCart(user);
    user.setCart(cart);
//    session.setAttribute("currentUser", user);
    return "cart/cart";
  }

  public String addCart(Integer bookId, HttpSession session) {
    User user = (User) session.getAttribute("currentUser");
    CartItem cartItem = new CartItem();
    cartItem.setBookId(bookId);
    cartItem.setBuyCount(1);
    cartItem.setUserBeanId(user.getId());
    // 将指定的图书添加到当前用户的购物车中
    cartItemService.addOrUpdateCartItem(user.getCart(), cartItem);
    return "redirect:cart.do";
  }

  public String editCart(Integer cartItemId, Integer buyCount) {
    CartItem cartItem = new CartItem();
    cartItem.setId(cartItemId);
    cartItem.setBuyCount(buyCount);
    cartItemService.updateCartItem(cartItem);
    // 重新查询一次
    return "redirect:cart.do";
  }

  public String cartInfo(HttpSession session) {
    User user = (User) session.getAttribute("currentUser");
    Cart cart = cartItemService.getCart(user);
    user.setCart(cart);
    Gson gson = new Gson();
    String cartJsonStr = gson.toJson(cart);
    return "json:" + cartJsonStr;
  }
}
