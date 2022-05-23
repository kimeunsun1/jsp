package com.githrd.blpink.controller.blpink;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/main.black")
public class Main extends HttpServlet {
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/views/blpink/main.jsp");
			rd.forward(req, resp);
		} catch(Exception e) {}
	}

}
