package polling.Servlets;

import java.io.IOException;
import java.time.LocalDate;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import polling.Models.Election;
import polling.Services.ElectionServicesImp;
import polling.Services.IElectionServices;

@WebServlet("/UpdateElectionServlet")
public class UpdateElectionServlet extends HttpServlet {
//Update election servlet
	private static final long serialVersionUID = 1L;

	public UpdateElectionServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	// @SuppressWarnings("static-access")
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String msg1 = "WELCOME!!";
		response.setContentType("text/html");
		// LocalDate d = null;
		Election election = new Election();
		IElectionServices iElectionServices = new ElectionServicesImp();

		int electionID = Integer.parseInt(request.getParameter("electionID"));
		LocalDate sdate = null, edate = null;
		sdate = LocalDate.parse(request.getParameter("startDate"));
		edate = LocalDate.parse(request.getParameter("endDate"));
		election.setElectionID(electionID);
		election.setElectionName(request.getParameter("eleName"));
		election.setElectionType(request.getParameter("eleType"));
		election.setStartDate(sdate);
		election.setEndDate(edate);
		request.setAttribute("election", election);
		boolean exist = iElectionServices.upDateElection(election, electionID);
		request.setAttribute("msg1", msg1);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/view/ElectionList.jsp");
		if (exist == false) {
			msg1 = "Election is running or closed, can't do updates now!!!";
			request.setAttribute("msg1", msg1);
			dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/view/CreateElection.jsp");

		}

		dispatcher.forward(request, response);

	}

}
