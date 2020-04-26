package com.ims.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author gaoxu
 * @date 2019-05-06 16:57
 * @description ... 类
 */
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static int i = 0;
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        System.out.println("login doPost");
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(userName, password);
        try {
            subject.login(token);
            System.out.println("subject获取session对象");
            Session session = subject.getSession();
            System.out.println("sessionId:" + session.getId());
            System.out.println("sessionHost:" + session.getHost());
            System.out.println("sessionTimeout:" + session.getTimeout());
            session.setAttribute("info", "session的数据");
            response.sendRedirect("success.jsp");
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("errorInfo", "用户名或者密码错误");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        System.out.println("login doGet:"+ i++);
    }
}
