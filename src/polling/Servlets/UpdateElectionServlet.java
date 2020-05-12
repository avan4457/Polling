package polling.Servlets;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
	
	private static final long serialVersionUID = 1L;

	public UpdateElectionServlet() {
		super();
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	
	//@SuppressWarnings("static-access")
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		//LocalDate d = null;
		LocalDate sdate = null,edate = null;
		sdate = LocalDate.parse(request.getParameter("startDate"));
		edate = LocalDate.parse(request.getParameter("endDate"));

		Election election = new Election();
		int electionID = Integer.parseInt(request.getParameter("electionID"));	
		election.setElectionID(electionID);
		election.setElectionName(request.getParameter("eleName"));
		election.setElectionType(request.getParameter("eleType"));
		election.setStartDate(sdate);
		election.setEndDate(edate);
		//election.setStartDate(d.parse(request.getParameter("StartDate")));
		//election.setEndDate(d.parse(request.getParameter("EndDate")));
		
		
		IElectionServices iElectionServices = new ElectionServicesImp();
		iElectionServices.upDateElection(election, electionID);

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/view/ElectionList.jsp");
		dispatcher.forward(request, response);
	}

}
