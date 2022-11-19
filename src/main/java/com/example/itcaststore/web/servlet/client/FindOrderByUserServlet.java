package com.example.itcaststore.web.servlet.client;

import com.example.itcaststore.domain.Order;
import com.example.itcaststore.domain.User;
import com.example.itcaststore.service.OrderService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet( "/findOrderByUser")
public class FindOrderByUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("user");
        // 调用service中的方法,根据用户信息查找订单
        OrderService service = new OrderService();
        List<Order> orders = service.findOrderByUser(user);
        request.setAttribute("orders", orders);
        request.getRequestDispatcher("/client/orderlist.jsp").forward(request, response);




    }
}
