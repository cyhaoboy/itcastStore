<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<title>bookStore列表</title>
	<!-- 新 Bootstrap 核心 CSS 文件 -->
	<link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
	<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
	<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
	<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
	<script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body class="main">
	<jsp:include page="head.jsp" />
	<jsp:include page="menu_search.jsp" />

	<div class="row " >
		<div class="col-md-2"></div>
		<div class="col-md-8">
			<table class="table" >
				<tr>
<c:forEach items="${bean.ps}" var="p" varStatus="vs">
					<th style="width:150px ">
			<div class="thumbnail detail">
				<img src="${pageContext.request.contextPath}${p.imgurl}" alt="...">
				<div class="caption">
					<h3><a href="${pageContext.request.contextPath}/findProductById?id=${p.id}">书名： ${p.name} </a></h3>
					<p><a href="${pageContext.request.contextPath}/findProductById?id=${p.id}">售价：￥${p.price} </a></p>
				</div>
			</div>
					</th>
</c:forEach>
				</tr>
			</table>
	</div>
		<div class="col-md-2"></div>
	</div>
	<div class="row">
	<div class="col-md-3"></div>
	<div class="col-md-6" style="text-align: center">
	<nav aria-label="Page navigation" >
		<ul class="pagination">
		<c:if test="${requestScope.bean.currentPage!=1}">
			<li>
				<a href="${pageContext.request.contextPath}/ShowProductByPage?currentPage=${bean.currentPage-1}&category=${bean.category}" aria-label="Previous">
					<span aria-hidden="true">&laquo;</span>
				</a>
			</li>
		</c:if>
			<c:if test="${requestScope.bean.currentPage==1}">
			<li>
				<a href="${pageContext.request.contextPath}/ShowProductByPage?currentPage=${bean.currentPage-1}&category=${bean.category}" aria-label="Previous">
					<span aria-hidden="true">&laquo;</span>
				</a>
			</li>
			</c:if>
			<c:forEach begin="1" end="${requestScope.bean.totalPage}" var="i" step="1">
				<c:if test="${requestScope.bean.currentPage==i}">
					<li class="active">
						<a href="${pageContext.request.contextPath}/ShowProductByPage?currentPage=${i}&pageSize=${bean.category}">${i}</a>
					</li>
				</c:if>
				<c:if test="${requestScope.bean.currentPage!=i}">
					<li>
						<a href="${pageContext.request.contextPath}/ShowProductByPage?currentPage=${i}&pageSize=${bean.category}">${i}</a>
					</li>
				</c:if>
			</c:forEach>
			<c:if test="${requestScope.bean.currentPage==bean.totalPage}">
			<li>
				<span aria-hidden="true">&raquo;</span>
				</a>
			</li>
		</c:if>
		<c:if test="${requestScope.bean.currentPage!=bean.totalPage}">
			<li>
				<a href="${pageContext.request.contextPath}/ShowProductByPage?currentPage=${bean.currentPage+1}&category=${bean.category}" aria-label="Next">
					<span aria-hidden="true">&raquo;</span>
				</a>
			</li>
		</c:if>

		</ul>
	</nav></div>
	<div class="col-md-3"></div>
	</div>
	<jsp:include page="foot.jsp" />
</body>
</html>
