package com.atguigu.book.controller;

import com.atguigu.book.bean.CartItem;
import com.atguigu.book.bean.User;
import com.atguigu.book.service.CartItemService;
import javax.servlet.http.HttpSession;

public class CartController {

  private CartItemService cartItemService;

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
}
