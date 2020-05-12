package polling.Servlets;

import javax.servlet.http.HttpServlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import polling.Models.Election;
import polling.Services.ElectionServicesImp;
import polling.Services.IElectionServices;

@WebServlet("/GetElectionServlet")
public class GetElectionServlet extends HttpServlet {

	
	private static final long serialVersionUID = 1L;


	public GetElectionServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	/**
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");

 		int electionID = Integer.parseInt(request.getParameter("electionID"));			
		IElectionServices iElectionService = new ElectionServicesImp();
		Election election = iElectionService.getElectionByID(electionID);

		request.setAttribute("election", election);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/view/CreateElection.jsp");
		dispatcher.forward(request, response);
	}
	
	
}
