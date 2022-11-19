<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>首页</title>

    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>

</head>

<body>
<jsp:include page="head.jsp" />
<jsp:include page="menu_search.jsp" />
<%--<header>--%>

<%--    <input type="hidden" name="" value="${pageContext.request.contextPath}" id="webPath">--%>
<%--    <div class="container" style="height:80px ">--%>
<%--        <div class="row">--%>
<%--            <div class="col-sm-4 col-xs-4"><img src="images/logo.png" alt=""></div>--%>
<%--            <div class="col-sm-4 col-lg-offset-4 col-xs-4 col-md-offset-4 col-sm-offset-4 col-xs-offset-4">--%>
<%--                <img src="images/cart.gif" alt="">--%>
<%--                <a href="#">欢迎你：${sessionScope.username}</a>--%>
<%--                <a href="" style="border-right: 2px solid white">购物车</a>|--%>
<%--                <a href="" style="border-right: 2px solid white">帮助中心</a>|--%>
<%--                <a href="" style="border-right: 2px solid white">我的账户</a>|--%>
<%--                <a href="">新用户注册 </a>--%>
<%--                <a href="DeleteCurrentUserServlet">退出</a>--%>
<%--            </div>--%>
<%--        </div>--%>
<%--    </div>--%>
<%--    <!--   -->--%>
<%--    <div style="background-color: #419641;height: 3px;margin-top: 20px;"></div>--%>
<%--    <div class="row" style="background-color: black;height: 50px;">--%>
<%--        <div class="menu">--%>
<%--            <ul class="nav navbar-nav" style="margin-left: 300px">--%>
<%--                <li><a href="#" style="color: white">文学</a></li>--%>
<%--                <li><a href="#" style="color: white">生活</a></li>--%>
<%--                <li><a href="#" style="color: white">计算机</a></li>--%>
<%--                <li><a href="#" style="color: white">外语</a></li>--%>
<%--                <li><a href="#" style="color: white">经管</a></li>--%>
<%--                <li><a href="#" style="color: white">励志</a></li>--%>
<%--                <li><a href="#" style="color: white">社科</a></li>--%>
<%--                <li><a href="#" style="color: white">学术</a></li>--%>
<%--                <li><a href="#" style="color: white">少儿</a></li>--%>
<%--                <li><a href="#" style="color: white">艺术</a></li>--%>
<%--                <li><a href="#" style="color: white">原版</a></li>--%>
<%--                <li><a href="#" style="color: white">科技</a></li>--%>
<%--                <li><a href="#" style="color: white">考试</a></li>--%>
<%--                <li><a href="#" style="color: white">生活百科</a></li>--%>
<%--                <li id="allp"><a href="#" style="color: yellow">全部商品目录</a></li>--%>
<%--            </ul>--%>
<%--        </div>--%>
<%--    </div>--%>

<%--    <div class="row" style="background-color: orange;margin-bottom: 20px;">--%>
<%--        <div class="col-md-6 col-md-offset-5">--%>
<%--            <form class="navbar-form navbar-right">--%>
<%--                <div class="form-group">--%>
<%--                    <label for="exampleInputEmail2" style="color: white">Search</label>--%>
<%--                    <input style="height: 24px;width: 150px;" type="email" class="form-control" id="exampleInputEmail2"--%>
<%--                           placeholder="请输入书名">--%>
<%--                </div>--%>
<%--                <!--                <button type="submit" class="btn btn-default" style="background-color: #419641;color: white">搜索</button>-->--%>
<%--                <img src="images/serchbutton.gif" alt="">--%>
<%--            </form>--%>
<%--        </div>--%>
<%--    </div>--%>


<%--</header>--%>

<div class="row">
    <div class="col-md-8 col-md-offset-2">
        <div class="row"  id="mycontent">
            <div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
                <!-- Indicators -->
                <ol class="carousel-indicators">
                    <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
                    <li data-target="#carousel-example-generic" data-slide-to="1"></li>
                    <li data-target="#carousel-example-generic" data-slide-to="2"></li>
                    <li data-target="#carousel-example-generic" data-slide-to="3"></li>
                    <li data-target="#carousel-example-generic" data-slide-to="4"></li>
                </ol>

                <!-- Wrapper for slides -->
                <div class="carousel-inner" role="listbox">
                    <div class="item active">

                        <img src="${pageContext.request.contextPath}/client/ad/index_ad1.jpg" alt="..." width="900" height="335">
                        <div class="carousel-caption">

                        </div>
                    </div>
                    <div class="item">
                        <img src="${pageContext.request.contextPath}/client/ad/index_ad0.jpg" alt="..." width="900" height="335">
                        <div class="carousel-caption">

                        </div>
                    </div>
                    <div class="item">
                        <img src="${pageContext.request.contextPath}/client/ad/index_ad3.jpg" alt="..." width="900" height="335">
                        <div class="carousel-caption">

                        </div>
                    </div>
                    <div class="item">
                        <img src="${pageContext.request.contextPath}/client/ad/index_ad4.jpg" alt="..." width="900" height="335">
                        <div class="carousel-caption">
                        </div>
                    </div>
                    <div class="item">
                        <img src="${pageContext.request.contextPath}/client/ad/index_ad5.jpg" alt="..." width="900" height="335">
                        <div class="carousel-caption">
                        </div>
                    </div>
                </div>

            </div>

            <div class="row" style="background-color: #fcf8e3;margin-top: 20px;margin-bottom: 20px;">
                <div class="col-sm-6">
                    <img src="${pageContext.request.contextPath}/client/images/billboard.gif" alt="">
                    <p style="font-size: small">${n.details}</p>
                </div>
                <div class="col-sm-4 col-sm-offset-2">
                    <div class="row"><img src="${pageContext.request.contextPath}/client/images/hottitle.gif" alt=""></div>
                    <div class="row">
                        <table>
                            <tr>
                    <c:forEach items="${requestScope.pList }" var="pArray">

                        <th>
                        <a href="${pageContext.request.contextPath}/findProductById?id=${pArray.product.id}">
                            <img src="${pageContext.request.contextPath }${pArray.product.imgurl}" alt="" style="height: 130px;margin-right: 30px;"></a></th>
                    </c:forEach>
                            </tr>
                            <tr>
                    <c:forEach items="${requestScope.pList }" var="pArray">
                        <td> <a href="${pageContext.request.contextPath}/findProductById?id=${pArray.product.id}" style="">${pArray.product.name}</a></td>
                       </c:forEach>
                            </tr>

                        </table>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>


<footer style="margin-top: 14px">
    <div style="background-color: #c0c0c0;height: 65px;">
        <div class="row">
            <div class="col-md-3 col-lg-offset-1 col-xs-3 col-sm-3 col-md-offset-1 col-xs-offset-1 col-sm-offset-1 "><img src="${pageContext.request.contextPath }/client/images/logo.png" style="height: 55px"></div>
            <div class="col-md-6 col-xs-6 col-sm-6">
                <p style="font-weight: bold">CONTACTUS</p>
                <strong style="color: #9d9d9d">COPYRIGHT 2015◎BookStore All Rights RESERVED.</strong>
            </div>

            <div class="col-md-3" >
                <a href="${pageContext.request.contextPath }/admin/login/login.jsp" style="margin-bottom: 20px">
                    后台入口
                </a>
            </div>
        </div>

    </div>
</footer>



</body>
</html>

