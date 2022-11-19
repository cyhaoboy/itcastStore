package com.example.itcaststore.web.servlet.client;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.itcaststore.exception.ActiveUserException;
import com.example.itcaststore.service.UserService;


@WebServlet("/activeUser")
@SuppressWarnings("serial")
public class ActiveUserServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");
		// 1.获取激活码
		String activeCode = request.getParameter("activeCode");
		// 2.调用service中激活用户操作
		UserService service = new UserService();
		try {
			service.activeUser(activeCode);
			response.sendRedirect(request.getContextPath() + "/client/activesuccess.jsp");
			return;
		} catch (ActiveUserException e) {
			e.printStackTrace();
			response.getWriter().write(e.getMessage());
			return;
		}
	}
}