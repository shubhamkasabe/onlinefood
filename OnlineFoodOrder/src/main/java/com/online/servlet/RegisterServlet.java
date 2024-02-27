package com.online.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import com.online.daos.CustomerDao;
import com.online.entites.Customer;
import com.online.helper.ConnectionProvider;

/**
 * Servlet implementation class RegisterServlet
 */
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegisterServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
		try (PrintWriter out = response.getWriter())

		{
			out.println("<!DOCTYPE html>");
			out.println("<html>");
			out.println("<head>");
			out.println("<meta charset=\"UTF-8\">");
			out.println("<title>Home Page</title>");
			out.println("</head>");
			out.println("<body>");

			// fatch all form data
			
			String customerIdStr = request.getParameter("customerId");
			int customerId = Integer.parseInt(customerIdStr);
			String customername = request.getParameter("customerName");
			String customercity = request.getParameter("customerCity");
			String customerpassword = request.getParameter("customerPassword");
			String customeremail = request.getParameter("customerEmail");
			
			//create object to save data in database;
			
			Customer cust= new Customer(customerId, customername, customercity, customerpassword, customeremail);	
			
			//Create CustomerDao Object
			
			CustomerDao user= new CustomerDao(ConnectionProvider.getConnection());
			if(user.saveCustomer(cust)) 
			{
				System.out.println("Done!!!");
			}else 
			{
				System.out.println("Somthing went wrong!!!");
			}
			
			

			out.println("</body>");
			out.println("</html>");
			
			

		}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
