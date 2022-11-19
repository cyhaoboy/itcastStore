package com.example.itcaststore.web.servlet.client;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.itcaststore.domain.User;
import com.example.itcaststore.exception.RegisterException;
import com.example.itcaststore.service.UserService;
import com.example.itcaststore.utils.ActiveCodeUtils;
import org.apache.commons.beanutils.BeanUtils;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");
		// 将表单提交的数据封装到javaBean
		User user = new User();
		try {
			BeanUtils.populate(user, request.getParameterMap());
			// 封裝激活码
			user.setActiveCode(ActiveCodeUtils.createActiveCode());
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		// 调用service完成注册操作。
		UserService service = new UserService();
		try {
			service.register(user);
		} catch (RegisterException e) {
			e.printStackTrace();
			response.getWriter().write(e.getMessage());
			return;
		}
		// 注册成功，跳转到registersuccess.jsp
		response.sendRedirect(request.getContextPath() + "/client/registersuccess.jsp");
		return;

//		// 将表单提交的数据封装到javaBean
//		User user = new User();
//		try {
//			BeanUtils.populate(user, request.getParameterMap());
//			// 封裝激活码
//			user.setActiveCode(ActiveCodeUtils.createActiveCode());
//
//		} catch (InvocationTargetException | IllegalAccessException e) {
//			e.printStackTrace();
//		}
//		System.out.println("gender:"+user.getGender());
//		// 调用service完成注册操作。
//		UserService service = new UserService();
//		try {
//			service.register(user);
//		} catch (RegisterException e) {
//			e.printStackTrace();
//			System.out.println("111");
//			response.getWriter().write(e.getMessage());
//			return;
//		}
//		// 注册成功，跳转到registersuccess.jsp
//		System.out.println("123");
////		request.getRequestDispatcher("/client/registersuccess.jsp").forward(request, response);
//		response.sendRedirect(request.getContextPath() + "/registersuccess.jsp");
//		System.out.println("321");
//		return;
	}
}
