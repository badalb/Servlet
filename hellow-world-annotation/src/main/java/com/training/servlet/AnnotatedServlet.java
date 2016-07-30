package com.training.servlet;

import java.io.IOException;
import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

@WebServlet(name = "testServlet", urlPatterns = { "/hello" }, initParams = {
		@WebInitParam(name = "simpleParam", value = "paramValue") })

public class AnnotatedServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1010792264138078734L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String simpleParam = getServletConfig().getInitParameter("simpleParam");
		out.println("Hello World " + simpleParam);
		out.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}