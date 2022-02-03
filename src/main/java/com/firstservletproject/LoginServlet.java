package com.firstservletproject;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(
        description = "Login Servlet",
        urlPatterns = "/LoginServlet",
        initParams = {
                @WebInitParam(name = "user", value = "Srinath"),
                @WebInitParam(name = "password", value = "1234")
        }
)

public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // TODO Auto-generated method stub

        //get request parameters for user ID and password
        String user = req.getParameter("user");
        String pwd = req.getParameter("pwd");

        // get servlet config init params
        String userID = getServletConfig().getInitParameter("user");
        String password = getServletConfig().getInitParameter("password");

        String regexName = "^[A-Z]{1}[a-zA-Z]{2,}$";
        String regexPassword = "^(?=.*[0-9])(?=[^@#$%^&+=]*[@#$%^&+=][^@#$%^&+=]*$)(?=.*[a-z])(?=.*[A-Z]).{8,}$";

        if(userID.equals(user) && userID.matches(regexName) && password.equals(pwd) && password.matches(regexPassword)) {
            req.setAttribute("user", user);
            req.getRequestDispatcher("LoginSuccess.jsp").forward(req, resp);
        } else {
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/login.html");
            PrintWriter out = resp.getWriter();
            out.println("<font color=red>Either username or password is incorrect!</font>");
            rd.include(req, resp);
        }

    }

}

