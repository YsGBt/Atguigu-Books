package com.atguigu.book.controller;

import com.atguigu.book.bean.Cart;
import com.atguigu.book.bean.User;
import com.atguigu.book.service.CartItemService;
import com.atguigu.book.service.UserService;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServletResponse;
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

  public String register(String uname, String pwd, String email, String verifyCode,
      HttpSession session, HttpServletResponse resp) {
    Object kaptchaCodeObj = session.getAttribute("KAPTCHA_SESSION_KEY");
    if (kaptchaCodeObj == null || !verifyCode.equals(kaptchaCodeObj)) {
      resp.setCharacterEncoding("UTF-8");
      resp.setContentType("text/html;charset=UTF-8");
      try (PrintWriter out = resp.getWriter();) {
        out.println("<script>alert('验证码不正确!');window.location.href='page.do?operate=page&page=user/regist';</script>");
//        out.println("<script>alert('验证码不正确!');</script>");
      } catch (IOException e) {
        throw new RuntimeException(e);
      }
//      return "user/regist";
      return null;
    }
    User user = new User();
    user.setUname(uname);
    user.setPwd(pwd);
    user.setEmail(email);
    userService.register(user);
    return "user/login";
  }
}
