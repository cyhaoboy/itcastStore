package com.example.itcaststore.web.servlet.backstage;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.itcaststore.domain.PageBean;
import com.example.itcaststore.domain.Product;
import com.example.itcaststore.exception.ListProductException;
import com.example.itcaststore.service.ProductService;

/**
 * 后台系统
 * 查询所有商品信息的servlet
 */
@WebServlet("/listProduct")
public class ListProductServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int currentPage = 1;
		String _currentPage = request.getParameter("currentPage");
		if (_currentPage != null&&_currentPage.length()>0) {
			currentPage = Integer.parseInt(_currentPage);
		}
		// 2.定义每页显示条数,默认为4
		int currentCount = 4;
		String _currentCount = request.getParameter("currentCount");
		if (_currentCount != null&&_currentCount.length()>0) {
			currentCount = Integer.parseInt(_currentCount);
		}
		// 1.创建service层的对象
		ProductService service = new ProductService();

			// 2.调用service层用于查询所有商品的方法
		PageBean bean =service.queryProduct(currentPage,currentCount);
			// 3.将查询出的所有商品放进request域中
			request.setAttribute("bean", bean);

			// 4.重定向到list.jsp页面
			request.getRequestDispatcher("/admin/products/list.jsp").forward(
					request, response);
		}
	}

