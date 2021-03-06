package polling.Servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import polling.Models.Campaign;
import polling.Models.Candidate;
import polling.Models.Election;
import polling.Models.User;
import polling.Services.CampaignService;
import polling.Services.CandidateService;
import polling.Services.ElectionServicesImp;
import polling.Services.ICampaignService;
import polling.Services.ICandidateService;
import polling.Services.IElectionServices;
import polling.Services.IuserServices;
import polling.Services.UserServices;

/**
 * Servlet implementation class UpdateCampaign
 */
@WebServlet(description = "Make changes to the existing campaign", urlPatterns = { "/UpdateCampaign" })
public class UpdateCampaign extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateCampaign() {
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
		
		String campaignId = request.getParameter("cid");
 		String candidateId = request.getParameter("uid");
 		int electionId = Integer.parseInt(request.getParameter("eid"));
		String heading = request.getParameter("heading");
		String statement = request.getParameter("statement");
		String description = request.getParameter("desc");
		
		ICampaignService iCampaignService = new CampaignService();
		ICandidateService iCandidateService = new CandidateService();
		IElectionServices iElectionServices = new ElectionServicesImp();
		IuserServices iuserServices = new UserServices();
		User user = new User();
		user = iuserServices.getUserById(candidateId);
		Election e = new Election();
		e = iElectionServices.getElectionByID(electionId);
		
		Campaign campaign = new Campaign(campaignId, candidateId, electionId,heading,statement,description);
		
		
		boolean isSuccess = iCampaignService.updateCampaign(campaignId, candidateId, electionId,campaign);
		
		if(isSuccess == true){
		List<Campaign> camDetails = iCampaignService.getCampaign(campaignId, candidateId, electionId);
		
		List<Candidate> candidateDetails = iCandidateService.getCandidate(candidateId, electionId, e.getElectionName(), e.getElectionType());
		request.setAttribute("candidateDetails", candidateDetails);
		request.setAttribute("camDetails", camDetails);
		request.setAttribute("user", user);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/view/Candidate.jsp");
		dispatcher.forward(request, response);
		}
	}

}
