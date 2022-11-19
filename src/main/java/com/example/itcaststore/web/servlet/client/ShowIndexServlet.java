package com.example.itcaststore.web.servlet.client;

import com.example.itcaststore.domain.Notice;
import com.example.itcaststore.domain.WeekHotProduct;
import com.example.itcaststore.service.NoticeService;
import com.example.itcaststore.service.ProductService;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/showIndexServlet")
public class ShowIndexServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doPost(req, resp);
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//查询最近一条公告，传递到index.jsp页面进行展示
		NoticeService nService = new NoticeService();
		Notice notice = nService.getRecentNotice();
		req.setAttribute("n", notice);
		
		//查询本周热销的两条商品，传递到index.jsp页面进行展示
		ProductService pService = new ProductService();
		List<WeekHotProduct> pList =  pService.getWeekHotProduct();

		req.setAttribute("pList", pList);
		
		//请求转发
		req.getRequestDispatcher("/client/index.jsp").forward(req, resp);
//		resp.sendRedirect();
	}
}
