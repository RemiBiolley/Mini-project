package project.mvc.controller;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.Objects;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import project.mvc.model.Authentication;

/**
 * Servlet implementation class AuthServlet
 */
@WebServlet("/AuthServlet")
public class AuthServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AuthServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		
		////////////////////////////////////////////////////////////////////
		// Part of the code executed when the servlet is called to log in //
		////////////////////////////////////////////////////////////////////
		if(request.getParameter("hidden")==null) {
			HttpSession s = request.getSession(true);
			
			Authentication auth = new Authentication();
			
			// checking if the couple "login-password" is present in the database and act in consequence
			if(auth.checkUser(request.getParameter("login"), request.getParameter("mdp"))) {
				s.setAttribute("login", request.getParameter("login"));
				RequestDispatcher dispatcher=getServletContext().getRequestDispatcher("/welcome.jsp");
				dispatcher.include(request, response);
			}
			else {
				RequestDispatcher dispatcher=getServletContext().getRequestDispatcher("/error.jsp");
				dispatcher.include(request, response);
			}
		}
		
		/////////////////////////////////////////////////////////////////////
		// Part of the code executed when the servlet is called to log out //
		/////////////////////////////////////////////////////////////////////
		else {
			HttpSession s = request.getSession(true);
			s.invalidate();
			RequestDispatcher dispatcher=getServletContext().getRequestDispatcher("/goodbye.jsp");
			dispatcher.include(request, response);
		}
	}

}
