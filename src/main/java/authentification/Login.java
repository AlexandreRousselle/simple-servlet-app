package authentification;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Login extends HttpServlet {
	
	private static final long serialVersionUID = -2067814274381415814L;

	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
        throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher("/login.jsp")
				.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
	    throws ServletException, IOException {
	    response.getWriter().println("Login");
	}
	
}
