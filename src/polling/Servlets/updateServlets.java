package polling.Servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import polling.Models.User;
import polling.Models.Voter;
import polling.Services.IuserServices;
import polling.Services.IvoterServices;
import polling.Services.UserServices;
import polling.Services.VoterServices;


/**
 * Servlet implementation class updateServlets
 */
@WebServlet("/updateServlets")
public class updateServlets extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updateServlets() {
        super();
        // TODO Auto-generated constructor stub
    }

	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String Vid =request.getParameter("Vid");
	
		
	IvoterServices iv = new VoterServices();		
		Voter voter =iv. getVoterByID(Vid);
		request.setAttribute("voter", voter);
		
		IuserServices iu = new UserServices();
		User user=iu.getUserById(Vid);
		request.setAttribute("user", user);
		
				RequestDispatcher d = getServletContext().getRequestDispatcher("/editVoterDetails.jsp");
				d.forward(request, response);
		
	}

}
