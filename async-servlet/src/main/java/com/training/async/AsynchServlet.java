package com.training.async;

import java.io.IOException;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

import javax.servlet.AsyncContext;
import javax.servlet.AsyncEvent;
import javax.servlet.AsyncListener;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = { "/asynch" }, asyncSupported = true)
public class AsynchServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1985769821602964971L;
	@SuppressWarnings("rawtypes")
	private static final Queue queue = new ConcurrentLinkedQueue();

	@SuppressWarnings("unchecked")
	public void doGet(HttpServletRequest request, HttpServletResponse response) {
		final AsyncContext ac = request.startAsync();
		ac.setTimeout(1 * 60 * 1000);
		queue.add(ac);
		ac.addListener(new AsyncListener() {

			@Override
			public void onError(AsyncEvent arg0) throws IOException {
				System.out.println("onError");

			}

			public void onComplete(AsyncEvent event) throws IOException {
				System.out.println("onComplete");
				queue.remove(ac);
			}

			public void onTimeout(AsyncEvent event) throws IOException {
				System.out.println("onTimeout");
				queue.remove(ac);
			}

			@Override
			public void onStartAsync(AsyncEvent arg0) throws IOException {
				System.out.println("onStartAsync");

			}

		});
		queue.add(ac);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) {
		doGet(request, response);
	}

}