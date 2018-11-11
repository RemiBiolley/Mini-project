package project.mvc.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Objects;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import project.mvc.model.Books;
import project.mvc.model.Reservation;

/**
 * Servlet implementation class ResServlet
 */
@WebServlet("/ResServlet")
public class ResServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ResServlet() {
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
		HttpSession s = request.getSession(true);
		
		if(request.getParameter("confirm")==null) {
			
			/*ArrayList <String> books = new ArrayList<String>(); 
			books.add("Harry Potter");
			books.add("Lord of the rings");
			books.add("Hamlet");
			books.add("Christine");
			books.add("I, Robot");
			
			if(books.contains(request.getParameter("book"))) {
				Reservation res = new Reservation();
				res.setBookName(request.getParameter("book"));
				request.setAttribute("books", res);
				s.setAttribute("book", res);
				RequestDispatcher dispatcher=getServletContext().getRequestDispatcher("/books.jsp");
				dispatcher.include(request, response);
			}
			else {
				request.setAttribute("noBook", ' ');
				RequestDispatcher dispatcher=getServletContext().getRequestDispatcher("/welcome.jsp");
				dispatcher.include(request, response);
			}*/
			
			Books books = new Books();
			if(books.bookInList(request.getParameter("book"))) {
				Reservation res = new Reservation();
				res.setBookName(request.getParameter("book"));
				request.setAttribute("books", res);
				s.setAttribute("book", res);
				RequestDispatcher dispatcher=getServletContext().getRequestDispatcher("/books.jsp");
				dispatcher.include(request, response);
			}
			else {
				request.setAttribute("noBook", ' ');
				RequestDispatcher dispatcher=getServletContext().getRequestDispatcher("/welcome.jsp");
				dispatcher.include(request, response);
			}
		}
		
		else {
			if(s.getAttribute("login")==null) {
				RequestDispatcher dispatcher=getServletContext().getRequestDispatcher("/index.jsp");
				dispatcher.include(request, response);
			}
			else {
				Books books = new Books();
				
				Reservation bookReservation = (Reservation)s.getAttribute("book");
				if(books.checkOwner(bookReservation)) {
					request.setAttribute("confResult", "failed");
					System.out.println("Je suis là");
				}
				else {
					books.changeOwner((String)s.getAttribute("login"), bookReservation);
					request.setAttribute("confResult", "success");
					System.out.println("Je suis ici");
				}
				//bookReservation.setUserLogin((String)s.getAttribute("login"));
				RequestDispatcher dispatcher=getServletContext().getRequestDispatcher("/confirmation.jsp");
				dispatcher.include(request, response);
			}
		}
		
		
		
	}

}
