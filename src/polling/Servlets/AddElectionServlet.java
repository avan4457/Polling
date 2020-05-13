package polling.Servlets;

import java.io.IOException;
import java.time.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import polling.Models.Election;
import polling.Services.ElectionServicesImp;
import polling.Services.IElectionServices;

/**
 * Servlet implementation class GenResultServlet
 */
@WebServlet("/AddElectionServlet")
public class AddElectionServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AddElectionServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		String msg = "Election Created successfully";

		Election election = new Election();
		LocalDate sdate = null,edate = null;
		sdate = LocalDate.parse(request.getParameter("startDate"));
		edate = LocalDate.parse(request.getParameter("endDate"));
		

		election.setElectionName(request.getParameter("eleName"));
		election.setElectionType(request.getParameter("eleType"));
		election.setStartDate(sdate);
		election.setEndDate(edate);

		IElectionServices iElectionSrevices = new ElectionServicesImp();

		iElectionSrevices.addElection(election);

		request.setAttribute("msg", msg);
		//request.setAttribute("election", election);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Commissioner.jsp");
                                                      
		dispatcher.forward(request, response);

	}

}
