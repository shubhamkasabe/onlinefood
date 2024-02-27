package com.online.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

import com.online.daos.CustomerDao;
import com.online.entites.Customer;
import com.online.helper.ConnectionProvider;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
			
			
			String customerEmail=request .getParameter("email"); 
			String customerPassword=request.getParameter("password");
			
			CustomerDao dao = new CustomerDao(ConnectionProvider.getConnection());
			Customer u=dao.getCustomerEmailAndPassword(customerEmail, customerPassword);
			
			if(u==null) 
			{
				System.out.println("Invalid details... try again");
				RequestDispatcher dispatcher = request.getRequestDispatcher("error_page.jsp");
			    dispatcher.forward(request, response);
			    
				
			}else 
			{
				HttpSession session = request.getSession();
				session.setAttribute("CurrentUser", u);
				response.sendRedirect("profile.jsp");
			}
			
			out.println("</body>");
			out.println("</html>");
		}catch(Exception e) 
		{
			e.printStackTrace();
		}

			// fatch all form data
			
			
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
