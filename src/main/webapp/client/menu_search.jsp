<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!-- 新 Bootstrap 核心 CSS 文件 -->
<link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script type="text/javascript">
/**
 * my_click和my_blur均是用于前台页面搜索框的函数
 */
//鼠标点击搜索框时执行
function my_click(obj, myid){
	//点击时，如果取得的值和搜索框默认value值相同，则将搜索框清空
	if (document.getElementById(myid).value == document.getElementById(myid).defaultValue){
	  document.getElementById(myid).value = '';
	  obj.style.color='#000';
	}
}
//鼠标不聚焦在搜索框时执行
function my_blur(obj, myid){
	//鼠标失焦时，如果搜索框没有输入值，则用搜索框的默认value值填充
	if (document.getElementById(myid).value == ''){
	 document.getElementById(myid).value = document.getElementById(myid).defaultValue;
	 obj.style.color='#999';
 }
}

/**
 * 点击搜索按钮执行的函数
 */
function search(){
	document.getElementById("searchform").submit();
}
</script>



	<div style="background-color: #419641;height: 3px;margin-top: 20px;"></div>
	<div class="row" style="background-color: black;height: 50px;">
		<div class="menu">
			<ul class="nav navbar-nav" style="margin-left: 300px">
				<li><a href="${pageContext.request.contextPath}/ShowProductByPage?category=文学">文学</a></li>
				<li><a href="${pageContext.request.contextPath}/ShowProductByPage?category=生活">生活</a></li>
				<li><a href="${pageContext.request.contextPath}/ShowProductByPage?category=计算机">计算机</a></li>
				<li><a href="${pageContext.request.contextPath}/ShowProductByPage?category=外语">外语</a></li>
				<li><a href="${pageContext.request.contextPath}/ShowProductByPage?category=经营">经管</a></li>
				<li><a href="${pageContext.request.contextPath}/ShowProductByPage?category=励志">励志</a></li>
				<li><a href="${pageContext.request.contextPath}/ShowProductByPage?category=社科">社科</a></li>
				<li><a href="${pageContext.request.contextPath}/ShowProductByPage?category=学术">学术</a></li>
				<li><a href="${pageContext.request.contextPath}/ShowProductByPage?category=少儿">少儿</a></li>
				<li><a href="${pageContext.request.contextPath}/ShowProductByPage?category=艺术">艺术</a></li>
				<li><a href="${pageContext.request.contextPath}/ShowProductByPage?category=原版">原版</a></li>
				<li><a href="${pageContext.request.contextPath}/ShowProductByPage?category=科技">科技</a></li>
				<li><a href="${pageContext.request.contextPath}/ShowProductByPage?category=考试">考试</a></li>
				<li><a href="${pageContext.request.contextPath}/ShowProductByPage?category=生活百科">生活百科</a><li>
				<li><a href="${pageContext.request.contextPath}/ShowProductByPage" style="color: yellow">全部商品目录</a><li>
			</ul>
		</div>
	</div>

<div id="divsearch">
<form action="${pageContext.request.contextPath }/MenuSearchServlet" id="searchform">
	<table width="100%" border="0" cellspacing="0">
		<tr>
			<td style="text-align:right; padding-right:220px">
				Search 
				<input type="text" name="textfield" class="inputtable" id="textfield" value="请输入书名"
				onmouseover="this.focus();"
				onclick="my_click(this, 'textfield');"
				onBlur="my_blur(this, 'textfield');"/> 
				<a href="#">
					<img src="${pageContext.request.contextPath}/client/images/serchbutton.gif" border="0" style="margin-bottom:-4px" onclick="search()"/> 
				</a>
			</td>
		</tr>
	</table>
</form>
</div>