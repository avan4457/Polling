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
		String id=request.getParameter("id");
		
		IvoterServices iv = new VoterServices();
		boolean istrue	=iv.deleteVoterById(id);
		
		IuserServices iu = new UserServices();
		User user=iu.getUserById(id);
		request.setAttribute("user", user);
		Voter voter =iv. getVoterByID(id);
		request.setAttribute("voter", voter);
		
		if(istrue == true){
			
			RequestDispatcher d = getServletContext().getRequestDispatcher("/editVoterDetails.jsp");
			d.forward(request, response);
		}
		else{		
			
			
			RequestDispatcher d = getServletContext().getRequestDispatcher("/voterProfile.jsp");
			d.forward(request, response);
		}
	}

}
