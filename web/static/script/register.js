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

// 如果想要发送异步请求，我们需要一个关键的对象 XMLHttpRequest
// 定义 XMLHttpRequest对象
let xmlHttpRequest;

// 完成 XMLHttpRequest对象的初始化
function createXMLHttpRequest() {
  if (window.XMLHttpRequest) {
    // 符合DOM2标准的浏览器，xmlHttpRequest的创建方式
    xmlHttpRequest = new XMLHttpRequest();
  } else if (window.ActiveXObject) {
    // IE 浏览器
    try {
      xmlHttpRequest = new ActiveXObject("Msxml2.XMLHTTP");
    } catch (e) {
      try {
        xmlHttpRequest = new ActiveXObject("Microsoft.XMLHTTP");
      } catch (e) {
      }
    }
  }
}

function checkUname(uname) {
  createXMLHttpRequest();
  let uri = "user.do?operate=checkUname&uname=" + uname;
  // 发送方式(Get 方式) 给谁发请求(user.do) 是否异步(true -> 异步)
  xmlHttpRequest.open("GET", uri, true);
  // 设置回调函数
  xmlHttpRequest.onreadystatechange = checkUnameCB;
  // 发送请求
  xmlHttpRequest.send();
}

function checkUnameCB() {
  if (xmlHttpRequest.readyState == 4 && xmlHttpRequest.status == 200) {
    // xmlHttpRequest.responseText 表示 服务器端响应给我的文本内容
    let responseText = xmlHttpRequest.responseText;
    // {'uname':'1'} -> 用户名已存在
    // {'uname':'0'} -> 用户名可用
    if (responseText == "{'uname':'1'}") {
      window.alert("用户名已经被注册!");
    }
  }
}