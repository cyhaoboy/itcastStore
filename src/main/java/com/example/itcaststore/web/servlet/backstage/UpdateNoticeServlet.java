package com.example.itcaststore.web.servlet.backstage;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.example.itcaststore.domain.Notice;
import com.example.itcaststore.service.NoticeService;

/**
 * 
 *	后台修改公告的servlet
 */
@WebServlet("/updateNotice")
public class UpdateNoticeServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doPost(req, resp);
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=UTF-8");
		NoticeService nService = new NoticeService();
		Notice bean = new Notice();
		//获取表单参数
		String title = req.getParameter("title");
		String details = req.getParameter("details");
		
		//将当前时间设为添加公告的时间
		String t = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
		bean.setTitle(title);
		bean.setDetails(details);
		bean.setN_time(t);
		//调用dao层方法
		nService.addNotice(bean);
		
		req.getRequestDispatcher("/listNotice").forward(req, resp);
	}
}
