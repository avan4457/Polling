package polling.Servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import polling.Models.Candidate;
import polling.Services.CandidateService;
import polling.Services.ICandidateService;

/**
 * Servlet implementation class GetCandidate
 */
@WebServlet(description = "Retrieve information of the candidate", urlPatterns = { "/GetCandidate" })
public class GetCandidate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetCandidate() {
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
 		int electionId = 1;
 		String election = null;
 		String electionType = null;
		ICandidateService iCandidateService = new CandidateService();
		List<Candidate> canDetails = iCandidateService.getCandidate(candidateId, electionId, election, electionType);

		request.setAttribute("canDetails", canDetails);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/Candidate.jsp");
		dispatcher.forward(request, response);
	}

}
