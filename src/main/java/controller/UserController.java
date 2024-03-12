package controller;

import jakarta.servlet.RequestDispatcher; 

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.User;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class UserController
 */
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public UserController() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd=request.getRequestDispatcher("/views/login.jsp");  
        rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
          
        String email=request.getParameter("email");  
        String password=request.getParameter("password");
        
        User user = new User();
        user.setEmail(email);
        user.setPassword(password);
        
        request.setAttribute("user",user);  
        
        boolean status = user.validate();
        
        if(status){  
        	response.sendRedirect("HomeController");
        }  
        else{  
            RequestDispatcher rd=request.getRequestDispatcher("/views/login-error.jsp");  
            rd.forward(request, response);  
        }  
		
	}
}

