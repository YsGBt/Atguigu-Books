package com.atguigu.book.controller;

import com.atguigu.book.bean.Cart;
import com.atguigu.book.bean.User;
import com.atguigu.book.service.CartItemService;
import com.atguigu.book.service.UserService;
import javax.servlet.http.HttpSession;

public class UserController {

  private UserService userService;
  private CartItemService cartItemService;

  public String login(String uname, String pwd, HttpSession session) {
    User user = userService.login(uname, pwd);
    if (user != null) {
      Cart cart = cartItemService.getCart(user);
      user.setCart(cart);
      session.setAttribute("currentUser", user);
      return "redirect:book.do";
    }
    return "user/login";
  }
}
