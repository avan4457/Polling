package polling.Servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import polling.Models.Voter;
import polling.Services.IvoterServices;
import polling.Services.VoterServices;

/**
 * Servlet implementation class deleteVoterServlet
 */
@WebServlet("/deleteVoterServlet")
public class deleteVoterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public deleteVoterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String id =request.getParameter("id");
		/*IvoterServices iv = new VoterServices();
		boolean isTrue=iv.upda();*/
		/* if(isTrue == true){*/
		
		IvoterServices iv = new VoterServices();		
		Voter voter =iv. getVoterByID(id);
		request.setAttribute("voter", voter);
		
		RequestDispatcher d = getServletContext().getRequestDispatcher("/deleteAccount.jsp");
		d.forward(request, response);
		
		
	}

	
}