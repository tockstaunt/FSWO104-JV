package com.keithcollier.hello;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ProjectServlet")
public class ProjectServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5381121865016970291L;
	
	public void init() throws ServletException {
		super.init();
	}
	
	public void destroy() {
		super.destroy();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String payloadHeaderId = "nothing";
		payloadHeaderId = request.getHeader("Payload-Data");
		
		String responseText = 	"GET is used to read information information." + payloadHeaderId;
		response.getWriter().append(responseText);
			
		System.out.println("GET was called."  + " " + payloadHeaderId);
		
		Enumeration <String> e = request.getHeaderNames();
		
		while(e.hasMoreElements()) {
			String name = (String)e.nextElement();			
			System.out.println(name);
		}
		
		response.setStatus(200);
		
	}
	
	

	

	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String payloadHeaderId = "nothing";
		payloadHeaderId = request.getHeader("Payload-Data");
		
		response.getWriter().append("Use this (PUT) to update information.");
		System.out.println("PUT was called" + " " + payloadHeaderId);
		
		Enumeration <String> e = request.getHeaderNames();
		
		while(e.hasMoreElements()) {
			String name = (String)e.nextElement();			
			System.out.println(name);
		}
		response.setStatus(200);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String payloadHeaderId = "nothing";
		payloadHeaderId = request.getHeader("Payload-Data");
		
		response.getWriter().append("Data can be created using this method (POST).");
		System.out.println("POST was called" + " " + payloadHeaderId);
		
		Enumeration <String> e = request.getHeaderNames();
		
		while(e.hasMoreElements()) {
			String name = (String)e.nextElement();			
			System.out.println(name);
		}
		response.setStatus(200);
	}
	
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
		String payloadHeaderId = "nothing";
		payloadHeaderId = request.getHeader("Payload-Data");
		
		response.getWriter().append("Only use DELETE to remove the specified target.");
		System.out.println("DELETE was called" + " " + payloadHeaderId);
		
		Enumeration <String> e = request.getHeaderNames();
		
		while(e.hasMoreElements()) {
			String name = (String)e.nextElement();			
			System.out.println(name);
		}
		response.sendError(204,"this is a error");
		
	}
	

}
