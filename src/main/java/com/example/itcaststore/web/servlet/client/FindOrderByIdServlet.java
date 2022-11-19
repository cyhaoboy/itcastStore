package com.example.itcaststore.web.servlet.client;

import com.example.itcaststore.domain.Order;
import com.example.itcaststore.service.OrderService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet( "/findOrderById")
public class FindOrderByIdServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //1.获取用户类型
        String type=request.getParameter("type");
        //2.得到要查询的订单的id
        String id = request.getParameter("id");
        //3.根据id查找订单
        OrderService service = new OrderService();
        Order order = service.findOrderById(id);
        //4.将查询出的订单信息添加到request作用域中
        request.setAttribute("order", order);
        //5.如果用户类型不为null，则请求转发到view.jsp页面，否则转发到orderInfo.jsp页面
        if(type!=null){
            request.getRequestDispatcher("/admin/orders/view.jsp").forward(request, response);
            return;
        }
        request.getRequestDispatcher("/client/orderInfo.jsp").forward(request, response);
    }
    }

