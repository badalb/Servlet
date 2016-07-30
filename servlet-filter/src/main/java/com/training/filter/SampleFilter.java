package com.training.filter;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;

@WebFilter(urlPatterns = { "/*" }, initParams = { @WebInitParam(name = "simpleParam", value = "paramValue") })
public class SampleFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		StringWriter sw = new StringWriter();
		PrintWriter writer = new PrintWriter(sw);

		writer.println("===============");
		writer.println("Filter intercepted!");
		writer.println("===============");

		// Log the resulting string
		writer.flush();
		filterConfig.getServletContext().log(sw.getBuffer().toString());

		chain.doFilter(request, response);

	}

	private FilterConfig filterConfig = null;

	public void init(FilterConfig filterConfig) throws ServletException {
		this.filterConfig = filterConfig;
	}

	@Override
	public void destroy() {
	}
}