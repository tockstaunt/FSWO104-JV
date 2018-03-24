package com.keithcollier.Servlet;


	import java.io.IOException;
	import javax.servlet.ServletException;
	import javax.servlet.annotation.WebServlet;
	import javax.servlet.http.HttpServlet;
	import javax.servlet.http.HttpServletRequest;
	import javax.servlet.http.HttpServletResponse;

	@WebServlet("/MyServlet")
	public class MyServlet extends HttpServlet {

		private static final long serialVersionUID = 6632886175268784375L;

		// resource management
		// throws ServletException
		public void init() throws ServletException {
			super.init();
		}

		// resource management
		public void destroy() {
			super.destroy();
		}

		// Create
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			System.out.println("doPost was called.");
		}

		// Read
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String testHeaderId = "nothing";
			testHeaderId = request.getHeader("test-header");
			
			String responseText = "You sent "+ testHeaderId + " to the server";
			response.getWriter().append(responseText);
			
			System.out.println("doget was called");
		}

		// Update
		protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			System.out.println("doPut was called.");
		}

		// Delete
		protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			System.out.println("doDelete was called.");
		}
	}

