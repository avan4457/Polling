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
import polling.Models.User;
import polling.Services.CampaignService;
import polling.Services.CandidateService;
import polling.Services.ICampaignService;
import polling.Services.ICandidateService;
import polling.Services.IuserServices;
import polling.Services.UserServices;

/**
 * Servlet implementation class AddCampaign
 */
@WebServlet(description = "Create a campaign", urlPatterns = { "/AddCampaign" })
public class AddCampaign extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCampaign() {
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
		int electionId =Integer.parseInt(request.getParameter("eid"));
		String electiontype = request.getParameter("etype");
		String election = request.getParameter("election");
		String party = request.getParameter("party");
		int num = Integer.parseInt(request.getParameter("num"));
		String district = request.getParameter("district");
		String state = request.getParameter("state");
		String heading = request.getParameter("heading");
		String statement = request.getParameter("statement");
		String description = request.getParameter("desc");
		
		ICampaignService iCampaignservice = new CampaignService();
		List<Campaign> camDetails=iCampaignservice.addCampaign(candidateId,electionId,heading,statement,description);
		request.setAttribute("camDetails", camDetails);
		
		ICandidateService iCandidateService = new CandidateService();
		List<Candidate> candidateDetails = iCandidateService.getCandidate(candidateId, electionId, election, electiontype);
		request.setAttribute("candidateDetails", candidateDetails);
		
		User user = new User();
		IuserServices iuserServices = new UserServices();
		user = iuserServices.getUserById(candidateId);
		request.setAttribute("user", user);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/view/Candidate.jsp");
		dispatcher.forward(request, response);
	}

}
