package polling.Servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import polling.Services.CampaignService;
import polling.Services.CandidateService;
import polling.Services.ICampaignService;
import polling.Services.ICandidateService;

/**
 * Servlet implementation class DeleteCandidate
 */
@WebServlet(description = "Delete the candidate profile and lose access to participating in the election", urlPatterns = { "/DeleteCandidate" })
public class DeleteCandidate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteCandidate() {
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

		String candidateId = request.getParameter("canId");			
		String electionId = request.getParameter("eId");
		String state = request.getParameter("state");
		ICandidateService iCandidateService = new CandidateService();
		boolean isTrue = iCandidateService.removeCandidate(candidateId,electionId,state);

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/view/user.jsp");
		dispatcher.forward(request, response);
	}

}
