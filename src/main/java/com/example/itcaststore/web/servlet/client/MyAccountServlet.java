package com.example.itcaststore.web.servlet.client;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.example.itcaststore.domain.User;

@WebServlet("/myAccount")
public class MyAccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//在session中查找名为“user”的会话
		User user = (User) request.getSession().getAttribute("user");
		//如果找到没有名为“user”的会话，说明用户没有登录，此时跳转到登录页面
		if (user == null) {
			response.sendRedirect(request.getContextPath() + "/client/login.jsp");
			return;
		}
		//如果是超级用户，进入到网上书城后台管理系统；否则进入到普通用户的账户信息页面
		if ("超级用户".equals(user.getRole())) {
			request.getRequestDispatcher("/admin/login/home.jsp").forward(request,response);

//			return;
		}else{
			request.getRequestDispatcher( "/client/myAccount.jsp").forward(request,response);
//			return;
		}
	}
}