<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2022/5/10
  Time: 13:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>注册页</title>

    <!-- 新 Bootstrap 核心 CSS 文件 -->
    <link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>

    <script>
        function checkmail(){
            var emailText=$("#email").val();
            var emailPatt=/^[\w-]+@([\w-]+\.)+[a-zA-Z]{2,4}$/;

            var flag=emailPatt.test(emailText)
            if (flag){
                $("#usermail_err").text("");
                $("#mail").addClass("has-success").removeClass("has-error");
            }else {
                $("#usermail_err").text("邮箱不合法！");
                $("#mail").addClass("has-error").removeClass("has-success");
            }

            return flag;
        }
        function checkusername() {
            var usernameText=$("#username").val();
            var usernamePatt=/^[a-zA-Z_]\w{5,12}$/;
            var flag;
            if (usernamePatt.test(usernameText)){
                $("#username_err").text("");
                $("#username").css("border","");
                $("#username").keyup(function () {
                    var username=$(this).val();
                    $.get("../VerifyUserServlet",{username:username},function (data) {
                        if(data.user){
                            $("#test").addClass("has-error").removeClass("has-success");
                            $("#sp2").show();
                            $("#sp1").hide();
                            flag=false;
                        }else {
                            $("#test").addClass("has-success").removeClass("has-error");
                            $("#sp1").show();
                            $("#sp2").hide();
                            flag=true;
                        }
                    });
                });
            }else {
                $("#username_err").text("用户名不合法！");
                $("#username").css("border","1px solid red");
                flag=false;
            }
            return flag;
        }
        function checkpassword() {
            var passwordText=$("#password").val();
            var passwordPatt= /^\w{6,16}$/;
           var flag= passwordPatt.test(passwordText)
            if (flag){
                $("#password_err").text("");
                $("#pwd").addClass("has-success").removeClass("has-error");
            }else {
                $("#password_err").text("密码不合法！");
                $("#pwd").addClass("has-error").removeClass("has-success");
            }

            return flag;
        }
        function checkrepassword() {
            var repwdText=$("#repassword").val();
            var passwordText=$("#password").val();
          var flag;
            if (repwdText==passwordText){
                $("#password2_err").text("");
                $("#repwd").addClass("has-success").removeClass("has-error");
                flag=true;
            }else {
                $("#password2_err").text("密码不一致");
                $("#repwd").addClass("has-error").removeClass("has-success");
                flag=false
            }
            return flag;
        }
        $(function () {
            $("#sp1").hide();
            $("#sp2").hide();

            $("#sub_btn").click(function () {
                $('form').submit();
               // if ( checkmail()&&checkusername()&&checkpassword()&&checkrepassword()){
               //
               // }else {
               //     return false;
               // }
            });

            $("#username").keyup(checkusername);
            $("#password").keyup(checkpassword);
            $("#email").keyup(checkmail);
            $("#repassword").keyup(checkrepassword);
        });

    </script>
    <style>

        #carousel-example-generic {
            height: 400px;
        }

        #carousel-example-generic .carousel-inner > .item > img {
            display: block;
            width: 100%;
            height: 400px;
        }


    </style>
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

<div class="row">
    <div class="col-md-8 col-md-offset-2" style="background-color: #fcf8e3;margin-bottom: 20px;">
        <p style="font-size: 20px;margin-top: 20px;"><b>新会员注册</b></p>
        <div class="col-md-10 col-md-offset-1">
            <form class="form-horizontal" action="${pageContext.request.contextPath}/register" method="post" >
                <div class="form-group">
                    <label for="email" class="col-sm-2 control-label">会员邮箱：</label>
                    <div class="col-sm-3" id="mail">
                        <input type="text"  class="form-control" id="email" name="email" >
                        <span id="usermail_err" style="color: red"></span>
                    </div>
<%--                    <p>请输入有效的邮箱地址</p>--%>
                </div>
                <div class="form-group">
                    <label for="username" class="col-sm-2 control-label">会员名：</label>
                    <div class="col-sm-3 has-feedback" id="test">
                        <input type="text" class="form-control" id="username" name="username" >
                        <span class="glyphicon glyphicon-ok form-control-feedback"  id="sp1"></span>
                        <span class="glyphicon glyphicon-remove form-control-feedback"  id="sp2"></span>
                        <span id="username_err" style="color: red"></span>
                    </div>
<%--                    <p>字母数字下划线5到12位, 不能是数字开头</p>--%>
                </div>
                <div class="form-group">
                    <label for="password" class="col-sm-2 control-label">密码：</label>
                    <div class="col-sm-3" id="pwd">
                        <input type="text" class="form-control" id="password" name="password" >
                        <span id="password_err" style="color: red"></span>
                    </div>
<%--                    <p>密码请设置6-16位字符</p>--%>
                </div>
                <div class="form-group" >
                    <label for="repassword" class="col-sm-2 control-label">重复密码：</label>
                    <div class="col-sm-3" id="repwd">
                        <input type="text" class="form-control" id="repassword" name="repassword" >
                        <span id="password2_err" style="color: red" ></span>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">性别：</label>
                    <label class="radio-inline">
                        <input type="radio" name="gender" id="inlineRadio1" value="男"> 男
                    </label>
                    <label class="radio-inline">
                        <input type="radio" name="gender" id="inlineRadio2" value="女"> 女
                    </label>
                </div>
                <div class="form-group">
                    <label for="phone" class="col-sm-2 control-label">联系电话：</label>
                    <div class="col-sm-6">
                        <input type="text" class="form-control" id="phone" name="telephone">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">个人介绍：</label>
                    <lable class="col-sm-6">
                        <textarea class="form-control" rows="3" name="introduce"></textarea>
                    </lable>

                </div>
                <div class="col-sm-10">
                    <hr style="border:1px dotted gray"/>
                </div>

                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-10">
                        <input  type="image" value="注册" src="images/signup.gif" id="sub_btn">
                    </div>
                </div>
            </form>
        </div>

    </div>
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
