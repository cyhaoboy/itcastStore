package com.example.itcaststore.web.servlet.client;


import com.example.itcaststore.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "VerifyUserServlet", value = "/VerifyUserServlet")
public class VerifyUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username=request.getParameter("username");

        UserService userService = new UserService();
        boolean user= userService.queryByName(username);
        response.setContentType("application/json;charset=utf-8");
       Map<String,Object> map=new HashMap<String,Object>();
       if (user){
           map.put("user",true);
           map.put("msg","用户名已存在");
       }else {
           map.put("user",false);
           map.put("msg","用户名可用");
       }
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(response.getWriter(),map);
    }
}
