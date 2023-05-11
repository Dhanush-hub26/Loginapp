

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import p1.RegisterBean;

/**
 * Servlet implementation class for Servlet: RegisterServlet
 *
 */
 public class RegisterServlet extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
   static final long serialVersionUID = 1L;
   
    /* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#HttpServlet()
	 */
	public RegisterServlet() {
		super();
	}   	
	
	/* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}  	
	
	/* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String firstname=request.getParameter("firstname");
		String lastname=request.getParameter("lastname");
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		RegisterBean o=new RegisterBean();
		o.setFirstname(firstname);
		o.setLastname(lastname);
		o.setUsername(username);
		o.setPassword(password);
		RegisterAction ra=new RegisterAction();
		boolean status=ra.Registerdetails(o);  
		if(status){
			RequestDispatcher r=getServletContext().
			    getRequestDispatcher("/RegisterSuccess.jsp");
			r.forward(request,response);
		}else{
			response.sendRedirect("RegisterUnSuccess.jsp");
			
		}
	}
 }
		
		



	  	  	    
