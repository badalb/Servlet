package com.training.servlet.security;

import javax.servlet.ServletException;
import javax.servlet.annotation.HttpConstraint;
import javax.servlet.annotation.HttpMethodConstraint;
import javax.servlet.annotation.ServletSecurity;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/secured")
@ServletSecurity(
        value = @HttpConstraint(
                rolesAllowed = {
                        "secured"
                }),
        httpMethodConstraints = {
                @HttpMethodConstraint(value = "GET", rolesAllowed = {
                        "secured"
                }),
                @HttpMethodConstraint(value = "POST")
        })
public class SecuredServlet extends HttpServlet{

    /**
	 * 
	 */
	private static final long serialVersionUID = -5725667918170058957L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        out.write("Servlet basic authentication annotation configuration: secured servlet");
    }

}
