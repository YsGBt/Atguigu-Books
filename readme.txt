//////////
1. 需求分析

//////////
2. 数据库设计
   1) 实体分析
      - 图书        Book
      - 用户        User
      - 订单        OrderBean
      - 订单详情     OrderItem
      - 购物车项     CartItem

   2) 实体属性分析
      - 图书: 书名、作者、价格、销量、库存、封面、状态
      - 用户: 用户名、密码、邮箱、角色
      - 订单: 订单编号、订单日期、订单金额、订单数量、订单状态、所属用户
      - 订单详情: 图书、数量、所属订单
      - 购物车项: 图书、数量、所属用户

//////////
3. 显示主页面 (index页面)
   - 新建 BookDAO, BookDAOImpl: getBookList()
   - 新建 BookService, BookServiceImpl: getBookList()
   - 新建 BookController: index()
   - 编辑 index.html

//////////
4. 首页上登陆成功之后显示欢迎语和购物车数量

//////////
5. 点击具体图书的添加到购物车按钮

//////////
6. 购物车详情

//////////
7. 结账
   1) 订单表添加一条记录
   2) 订单详情表添加n条记录
   3) 购物车项表中需要删除对应的n条记录

//////////
8. 关于订单信息中的订单数量问题

//////////
9. 编辑购物车

//////////
10. 关于金额的精度问题

//////////
11. 过滤器判断是否是合法用户:
    - 解决方法: 新建SessionFilter，用来判断session中是否保存了currentUser
    - 如果没有currentUser，表明当前不是一个登陆合法的用户，应该跳转到登陆页面让其登陆
    - 现在添加了过滤器之后，出现了如下错误:
    localhost 将您重定向的次数过多。
    尝试清除 Cookie
    ERR_TOO_MANY_REDIRECTS

//////////
12. 在注册页面显示验证码:
    1) 添加jar
    2) 在web.xml文件中配置KaptchaServlet，以及配置相关的属性
    3) 在页面上访问这个Servlet，然后这个Servlet做两件事情:
       - 在页面上显示验证码图片
       - 在session作用域中保存验证码信息，对应的key存储在Constants这个常量接口中
    4) 用户在注册页面中输入验证码发送给服务器，那么需要和session中保存的进行比较

//////////
13. 注册功能实现

//////////
14. js中的正则表达式
    1) 三步骤: 定义正则表达式对象(两种方式)；定义待校验的字符串；校验
    2) 正则表达式的规则：
       g, i, m
       ., \w, \W, \d, \D, \b, \s, \S, ^, $
       [abc], [^abc], [a-c]
       *, +, ?, {n}, {n,}, {n,m}
       |

//////////
15. 注册页面表单验证
    1) <form> 有一个事件 onsubmit,
       onsubmit="return false;"，那么表单点击提交按钮时不会提交
       onsubmit="return true;"，那么表单点击提交按钮时会提交

    2) 获取文档中某一个节点的方式:
       - 文档对象模型 DOM: Document
         let unameTxt = document.getElementById("uname");

       - 浏览器对象模型 BOM: Browser
         let form = document.forms[0];
         let unameTxt = form.uname;

//////////
16. Ajax: 异步的JavaScript and XML
    目的: 用来发送异步的请求，然后当服务器给我响应的时候再进行回调操作
    好处: 提高用户体验；局部刷新: 降低服务器负担、减轻浏览器压力、减轻网络带宽压力
    开发步骤:
      1) 创建XMLHTTPRequest
      2) 调用open进行设置: .open("GET", URI, true);
      3) 绑定状态改变时执行的回调函数 - onreadystatechange
      4) 发送请求 - send()
      5) 编写回调函数，在回调函数中，我们只对XMLHTTPRequest的readystate为4时感兴趣，我们只对XMLHTTPRequest的status为200时感兴趣

         0: (Uninitialized) the send() method has not yet been invoked
         1: (Loading) the send() method has been invoked, request in progress
         2: (Loaded) the send() method has completed, entire response received
         3: (Interactive) the response is being parsed
         4: (Completed) the response has been parsed, is ready for harvesting

         0 - (未初始化) 还没有调用send()方法
         1 - (载入) 已调用send()方法，正在发送请求
         2 - (载入完成) send()方法执行完成，已经接收到全部响应内容
         3 - (交互) 正在解析响应内容
         4 - (完成) 响应内容解析完成，可以在客户端调用了
