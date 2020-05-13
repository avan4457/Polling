package polling.Servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import polling.Models.Candidate;
import polling.Services.CandidateService;
import polling.Services.ICandidateService;

/**
 * Servlet implementation class AddCandidate
 */
@WebServlet(description = "When a candidate will be registering for the election", urlPatterns = { "/AddCandidate" })
public class AddCandidate extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// userId
	private static final Object UserId = 1;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCandidate() {
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
		response.setContentType("text/html");

		//Candidate candidate = new Candidate();
		//HttpSession session = request.getSession(false);
		
		//session.setAttribute("UserId", UserId);                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                          
		//adding the user id from the previous login page 
		//candidate.setCandidateId((Integer.parseInt(session.getAttribute((String) UserId)));
		//candidate.setElectionType(request.getParameter("etype"));
		//candidate.setElection(request.getParameter("election"));
		//candidate.setParty(request.getParameter("party"));
		//candidate.setDistrict(request.getParameter("district"));
		String candidateId = "1";
		String electionType  = request.getParameter("etype");
		String election = request.getParameter("election");
		String party = request.getParameter("party");
		String district = request.getParameter("district");
		ICandidateService iCandidateService = new CandidateService();
		int electionId = iCandidateService.obtainElectionId(election, electionType);
		iCandidateService.addCandidate(electionId,electionType,election,party,district);
		List<Candidate> candidateDetails = iCandidateService.getCandidate(candidateId, electionId, election, electionType);
		request.setAttribute("candidateDetails", candidateDetails);
			
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/Candidate.jsp");
			dispatcher.forward(request, response);
		
	}

}
