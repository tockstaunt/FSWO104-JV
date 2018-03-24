package com.keithcollier.lesson2handson;

import java.io.IOException;

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
	private static final long serialVersionUID = 6699757404609535044L;

	public void init() throws ServletException {
			super.init();
		}
		
		public void destroy() {
			super.destroy();
		}
		
		// Create
				protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
					
					String testPostId = " ";
					testPostId = request.getHeader("test-post");
					
					String responseText = testPostId;
					response.getWriter().append(responseText);
					
					System.out.println("Post was called.");
				}

				// Read
				protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
					String testHeaderId = " ";
					testHeaderId = request.getHeader("test-header");
					
					String responseText =testHeaderId;
					response.getWriter().append(responseText);
					
					System.out.println("get was called");
				}

				// Update
				protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
					System.out.println("Put was called.");
					
					String putId = " ";
					putId = request.getHeader("putId");
					
					String responseText = putId;
					response.getWriter().append(responseText);
				}

				// Delete
				protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
					System.out.println("Delete was called.");
					
					String deleteId = " ";
					deleteId = request.getHeader("deleteId");
					
					String responseText = deleteId;
					response.getWriter().append(responseText);
				}
				
				
			}

