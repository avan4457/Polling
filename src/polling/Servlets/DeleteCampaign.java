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
import polling.Models.User;
import polling.Services.CampaignService;
import polling.Services.CandidateService;
import polling.Services.ICampaignService;
import polling.Services.ICandidateService;
import polling.Services.IuserServices;
import polling.Services.UserServices;

/**
 * Servlet implementation class DeleteCampaign
 */
@WebServlet(description = "Deletes the campaign created by the candidate", urlPatterns = { "/DeleteCampaign" })
public class DeleteCampaign extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteCampaign() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");

		String campaignID = request.getParameter("cid");
		String candidateId = request.getParameter("uid");
 		int electionId = Integer.parseInt(request.getParameter("eid"));
 		String election = request.getParameter("election");
 		String electionType = request.getParameter("election");
		
		ICampaignService iCampaignService = new CampaignService();
		iCampaignService.removeCampaign(campaignID,candidateId,electionId);
		
		ICandidateService iCandidateService = new CandidateService();
		List<Candidate> candidateDetails = iCandidateService.getCandidate(candidateId, electionId, election, electionType);
		request.setAttribute("candidateDetails", candidateDetails);
		
		User user = new User();
		IuserServices iuserServices = new UserServices();
		user = iuserServices.getUserById(candidateId);
		request.setAttribute("user", user);

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/view/Candidate.jsp");
		dispatcher.forward(request, response);
	}

}
