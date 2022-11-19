package com.example.itcaststore.web.servlet.client;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;
@WebServlet( "/CodeServlet")
public class CodeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        BufferedImage image = new BufferedImage(100,50,BufferedImage.TYPE_INT_RGB);
        Graphics g = image.getGraphics();
        g.setColor(Color.white);
        g.fillRect(0,0,100,50);
        g.setColor(Color.BLACK);
        StringBuilder sb=new StringBuilder();
       String str ="ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random rnd = new Random();
        int index;
        char ch;

        for (int i=0;i<4;i++){
            index = rnd.nextInt(str.length());
            ch  =str.charAt(index);
            g.drawString(ch+"",20+15*i,25);
            sb.append(ch);
        }

        int x,y;
        for (int i=0;i<100;i++){
            g.setColor(Color.pink);
            x=rnd.nextInt(100);
            y=rnd.nextInt(50);
            g.fillRoundRect(x,y,2,2,1,1);
        }
        HttpSession session = req.getSession();
        String code=sb.toString();
        session.setAttribute("chkcode",code);
        ImageIO.write(image,"jpg",resp.getOutputStream());

    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
