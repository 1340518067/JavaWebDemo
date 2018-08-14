package com.westos.web01.servlet;

import org.apache.commons.lang3.RandomUtils;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.util.UUID;

import static java.awt.image.ImageObserver.HEIGHT;

public class YanzhengmaServlet extends HttpServlet {
    private static final int WIDTH = 100;
    private static final int HEIGHT = 40;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取session
        HttpSession session = request.getSession();
        System.out.println(session.getId());
        //产生一张图片
        BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
        Graphics g = image.getGraphics();
        //设置背景色
        g.setColor(Color.WHITE);
        //填充背景色
        g.fillRect(0,0,WIDTH,HEIGHT);
        //设置前景色
        g.setColor(Color.RED);
        Font font=new Font("微软雅黑",Font.BOLD,20);
        g.setFont(font);
        String str=genRandomString(4);
        session.setAttribute("rndstr",str);
        g.drawString(str,20,30);
        for(int i=0;i<20;i++){
            int x1=RandomUtils.nextInt(0,WIDTH);
            int x2=RandomUtils.nextInt(0,WIDTH);
            int y1=RandomUtils.nextInt(0,HEIGHT);
            int y2=RandomUtils.nextInt(0,HEIGHT);
            Color color=new Color(RandomUtils.nextInt(0,255),RandomUtils.nextInt(0,255),RandomUtils.nextInt(0,255));
            g.setColor(color);
            g.drawLine(x1,y1,x2,y2);
        }
        //cookie的操作
        //写cookie
        Cookie cookie=new Cookie("name","westos");
        //过期时间
        cookie.setMaxAge(10000);
        //只允许服务端读取
        cookie.setHttpOnly(true);
        response.addCookie(cookie);

        //读取cookie
        Cookie[] cookies = request.getCookies();
        for(Cookie ck:cookies){
            System.out.println(ck.getName()+"="+ck.getValue());
        }

        //输出图片
        ImageIO.write(image,"jpg",response.getOutputStream());

        //response.getWriter().println("<h1>success</h1>");

    }

    private String genRandomString(int len){
        String result="";
        //获取len个随机字母
        for(int i=0;i<len;i++){
            char c = (char)RandomUtils.nextInt(65, 91);
            result=result+c;

        }
        return result;
    }
}
