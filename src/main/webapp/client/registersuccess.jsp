<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2022/5/28
  Time: 14:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>

    <!-- 新 Bootstrap 核心 CSS 文件 -->
    <link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="js/my.js"></script>


</head>


<body>

<header>
    <div class="container" style="height:80px ">
        <div class="row">
            <div class="col-sm-4 col-xs-4"><img src="images/logo.png" alt=""></div>
            <div class="col-sm-4 col-lg-offset-4 col-xs-4 col-md-offset-4 col-sm-offset-4 col-xs-offset-4">
                <img src="images/cart.gif" alt="">
                <a href="" style="border-right: 2px solid white">购物车</a>|
                <a href="" style="border-right: 2px solid white">帮助中心</a>|
                <a href="" style="border-right: 2px solid white">我的账户</a>|
                <a href="">新用户注册 </a>
            </div>
        </div>
    </div>
    <!--   -->
    <div style="background-color: #419641;height: 3px;margin-top: 20px;"></div>
    <div class="row" style="background-color: black;height: 50px;">
        <div class="menu">
            <ul class="nav navbar-nav" style="margin-left: 300px">
                <li><a href="#" style="color: white">文学</a></li>
                <li><a href="#" style="color: white">生活</a></li>
                <li><a href="#" style="color: white">计算机</a></li>
                <li><a href="#" style="color: white">外语</a></li>
                <li><a href="#" style="color: white">经管</a></li>
                <li><a href="#" style="color: white">励志</a></li>
                <li><a href="#" style="color: white">社科</a></li>
                <li><a href="#" style="color: white">学术</a></li>
                <li><a href="#" style="color: white">少儿</a></li>
                <li><a href="#" style="color: white">艺术</a></li>
                <li><a href="#" style="color: white">原版</a></li>
                <li><a href="#" style="color: white">科技</a></li>
                <li><a href="#" style="color: white">考试</a></li>
                <li><a href="#" style="color: white">生活百科</a></li>
                <li><a href="#" style="color: yellow">全部商品目录</a></li>
            </ul>
        </div>
    </div>



    <div class="row" style="background-color: orange;margin-bottom: 20px;">
        <div class="col-md-6 col-md-offset-5">
            <form class="navbar-form navbar-right">
                <div class="form-group">
                    <label for="exampleInputEmail2" style="color: white">Search</label>
                    <input style="height: 24px;width: 150px;" type="email" class="form-control" id="exampleInputEmail2"
                           placeholder="请输入书名">
                </div>
                <!--                <button type="submit" class="btn btn-default" style="background-color: #419641;color: white">搜索</button>-->
                <img src="images/serchbutton.gif" alt="">
            </form>
        </div>
    </div>


</header>


<div id="divcontent">
    <table width="850px" border="0" cellspacing="0">
        <tr>
            <td style="padding:30px; text-align:center">
                <table width="60%" border="0" cellspacing="0" style="margin-top:70px">
                    <tr>
                        <td style="width:98px">
                            <img src="images/IconTexto_WebDev_009.jpg" width="128" height="128" />
                        </td>
                        <td style="padding-top:30px">
                            <font style="font-weight:bold; color:#FF0000">注册成功,别忘记激活帐户啊！</font><br />
                            <br />
                            <a href="${pageContext.request.contextPath }/client/index.jsp">
                                <span id="second">5</span>秒后自动为您转跳回首页
                            </a>
                        </td>
                    </tr>
                </table>
                <h1>&nbsp;</h1></td>
        </tr>
    </table>
</div>



<footer style="margin-top: 15px">
    <div style="background-color: #c0c0c0;height: 65px;">
        <div class="row">
            <div class="col-md-3 col-lg-offset-1 col-xs-3 col-sm-3 col-md-offset-1 col-xs-offset-1 col-sm-offset-1 "><img src="images/logo.png" style="height: 55px"></div>
            <div class="col-md-6 col-xs-6 col-sm-6">
                <p style="font-weight: bold">CONTACTUS</p>
                <strong style="color: #9d9d9d">COPYRIGHT 2015◎BookStore All Rights RESERVED.</strong>
            </div>
        </div>

    </div>
</footer>
</body>
</html>
