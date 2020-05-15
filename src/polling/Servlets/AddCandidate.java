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
import polling.Models.User;
import polling.Services.CandidateService;
import polling.Services.ICandidateService;
import polling.Services.IuserServices;
import polling.Services.UserServices;

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

		
		String candidateId = request.getParameter("uid");
		String electionType  = request.getParameter("etype");
		String election = request.getParameter("election");
		String party = request.getParameter("party");
		String district = request.getParameter("district");
		ICandidateService iCandidateService = new CandidateService();
		int electionId = iCandidateService.obtainElectionId(election, electionType);
		iCandidateService.addCandidate(candidateId,electionId,electionType,election,party,district);
		List<Candidate> candidateDetails = iCandidateService.getCandidate(candidateId, electionId, election, electionType);
		request.setAttribute("candidateDetails", candidateDetails);
		
		IuserServices iu = new UserServices();
		User user =new User();
		user = iu.getUserById(candidateId);
		
			request.setAttribute("user", user);
			RequestDispatcher dispatcher;
			dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/view/Candidate.jsp");

			dispatcher.forward(request, response);
		
	}

}
