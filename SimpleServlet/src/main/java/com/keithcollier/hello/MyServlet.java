package com.keithcollier.hello;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/MyServlet")
public class MyServlet extends HttpServlet {

	private static final long serialVersionUID = -2726730210728774719L;

	public void init() throws ServletException {
		super.init();
	}
	
	public void destroy() {
		super.destroy();
	}
	
	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException {
		//retieves test-header value from http request header
		String testHeaderId = "nothing";
		testHeaderId = request.getHeader("Test-Header");
		
		//stores responceText to be sent to client
		String responceText = "You sent "+testHeaderId+" to the server. ";
		response.getWriter().append(responceText);
		
		System.out.println("doGet was called");
	}
	
	protected void doPut(HttpServletRequest request,HttpServletResponse responce) throws ServletException,IOException {
		System.out.println("doPut was called");
	}
	
	protected void doPost(HttpServletRequest request,HttpServletResponse responce) throws ServletException,IOException {
		System.out.println("doPost was called");
	}
	
	protected void doDelete(HttpServletRequest request,HttpServletResponse responce) throws ServletException,IOException {
		System.out.println("doDelete was called");
	}

}
