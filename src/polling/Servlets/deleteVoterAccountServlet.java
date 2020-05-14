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
//IT19390260 
/**
 * Servlet implementation class deleteVoterAccountServlet
 */
@WebServlet("/deleteVoterAccountServlet")
public class deleteVoterAccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String Vid=request.getParameter("Vid");
		
		IvoterServices iv = new VoterServices();
		boolean istrue	=iv.deleteVoterById(Vid);
		
		IuserServices iu = new UserServices();
		User user=iu.getUserById(Vid);
		request.setAttribute("user", user);
		Voter voter =iv. getVoterByID(Vid);
		request.setAttribute("voter", voter);
		
		if(istrue == true){
			
			RequestDispatcher d = getServletContext().getRequestDispatcher("/Home.jsp");
			d.forward(request, response);
		}
		else{		
			
			
			RequestDispatcher d = getServletContext().getRequestDispatcher("/voterProfile.jsp");
			d.forward(request, response);
		}
	}

}
