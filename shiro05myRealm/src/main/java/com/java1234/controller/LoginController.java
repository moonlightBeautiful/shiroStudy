package com.java1234.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author gaoxu
 * @date 2019-05-13 14:40
 * @description ... 类
 */
public class LoginController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("login doGet");
        req.getRequestDispatcher("login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("login doPost");
        String userName = req.getParameter("userName");
        String password = req.getParameter("password");
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(userName, password);

        try {
            subject.login(token);
            Session session = subject.getSession();
            System.out.println("sessionId:" + session.getId());
            System.out.println("sessionHost:" + session.getHost());
            System.out.println("sessionTimeout:" + session.getTimeout());
            session.setAttribute("info", "session的数据");
            resp.sendRedirect("success.jsp");
        } catch (Exception e) {
            e.printStackTrace();
            req.setAttribute("errorInfo", "用户名或者密码错误");
            req.getRequestDispatcher("login.jsp").forward(req, resp);
        }
    }
}
