package authentification;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import user.User;

public class Register extends HttpServlet {

    /**
	 * 
	 */
	private static final long serialVersionUID = -604490449392631978L;
	
	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
        throws ServletException, IOException {
        this.getServletContext().getRequestDispatcher("/register.jsp")
				.forward(request, response);
    }
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
	    throws ServletException, IOException {
		RegisterForm rf = new RegisterForm();
		User user = rf.register(request);
		HttpSession session = request.getSession();
		
		session.setAttribute("user_session", user);
		
		request.setAttribute("form", rf);
		request.setAttribute("user", user);
		
		this.getServletContext().getRequestDispatcher("/accueil.jsp").forward(request, response);
	}
	
}

