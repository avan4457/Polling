package polling.Servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import polling.Models.Election;
import polling.Models.Voter;
import polling.Services.IvoterServices;
import polling.Services.VoterServices;

/**
 * Servlet implementation class displyElectionsServlet
 */
@WebServlet("/displyElectionsServlet")
public class displyElectionsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public displyElectionsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
			response.setContentType("text/html");
			String id=request.getParameter("id");
			IvoterServices iv = new VoterServices();
			
			Voter voter =iv. getVoterByID(id); //  or id
			
			ArrayList<Election> election =iv.currentElections();
			request.setAttribute("election",election);
			request.setAttribute("voter",voter);
			
			/*request.setAttribute("id", id);*/
			RequestDispatcher d = getServletContext().getRequestDispatcher("/selectElection.jsp");
			d.forward(request, response);
	}

}
