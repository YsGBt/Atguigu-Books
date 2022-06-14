function preRegister() {
  // 浏览器对象模型 BOM: Browser
  // let form = document.forms[0];
  // let unameTxt = form.uname;

  let res = true;

  // 文档对象模型 DOM: Document
  // 用户名不能为空，而且用户名应为6~16位数字和字母组成
  let unameTxt = $("unameTxt");
  let unameReg = /^[0-9a-zA-z]{6,16}$/;
  let uname = unameTxt.value;
  let unameSpan = $("unameSpan");
  if (!unameReg.test(uname)) {
    unameSpan.style.visibility = "visible";
    res = false;
  } else {
    unameSpan.style.visibility = "hidden";
  }

  // 密码
  // 密码两次输入一致
  let pwdTxt = $("pwdTxt");
  let pwd = pwdTxt.value;
  let confirmPwdTxt = $("confirmPwdTxt");
  let confrimPwd = confirmPwdTxt.value;
  let confirmPwdSpan = $("confirmPwdSpan");
  if (pwd != confrimPwd) {
    confirmPwdSpan.style.visibility = "visible";
    res = false;
  } else {
    confirmPwdSpan.style.visibility = "hidden";
  }

  // 密码的长度至少为8位
  let pwdReg = /^.{8,}$/;
  let pwdSpan = $("pwdSpan");
  if (!pwdReg.test(pwd)) {
    pwdSpan.style.visibility = "visible";
    res = false;
  } else {
    pwdSpan.style.visibility = "hidden";
  }

  // 邮箱
  // 请输入正确的邮箱格式
  let emailTxt = $("emailTxt");
  let emailReg = /^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/;
  let email = emailTxt.value;
  let emailSpan = $("emailSpan");
  if (!emailReg.test(email)) {
    emailSpan.style.visibility = "visible";
    res = false;
  } else {
    emailSpan.style.visibility = "hidden";
  }

  return res;
}

function $(id) {
  return document.getElementById(id);
}