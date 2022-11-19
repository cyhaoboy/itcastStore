package com.example.itcaststore.web.servlet.client;

import com.example.itcaststore.service.OrderService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "DelOrderByIdServlet", value = "/delOrderById")
public class DelOrderByIdServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 订单id
        String id = request.getParameter("id");
        // 已支付的订单带有type值为client的参数
        String type = request.getParameter("type");
        OrderService service = new OrderService();
        if (type != null && type.trim().length() > 0) {
            service.delOrderById(id);
            if ("admin".equals(type)) {
                request.getRequestDispatcher("/findOrders").forward(request, response);
                return;
            }
        } else {
            // 调用service层方法删除相应订单
            service.delOrderByIdWithClient(id);
        }
        //response.sendRedirect(request.getContextPath() + "/client/delOrderSuccess.jsp");
        request.getRequestDispatcher("/findOrderByUser").forward(request, response);
        return;

    }
}
