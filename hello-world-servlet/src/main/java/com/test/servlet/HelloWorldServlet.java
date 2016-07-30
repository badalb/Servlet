package com.test.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletDemo
 */
public class HelloWorldServlet extends HttpServlet {

	/**
		 * 
		 */
	private static final long serialVersionUID = -3942942026857266328L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		out.println("<html>");
		out.println("  <head>");
		out.println("    <title>SimpleServlet</title>");
		out.println("  </head>");
		out.println("  <body>");
		out.println("    Hello, World");
		out.println("  </body>");
		out.println("</html>");
	}

	public void destroy() {
		System.out.println("shutting down....");
	}
}