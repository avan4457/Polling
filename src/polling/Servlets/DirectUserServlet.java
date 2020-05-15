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
import polling.Models.Voter;
import polling.Services.CampaignService;
import polling.Services.CandidateService;
import polling.Services.ElectionServices;
import polling.Services.ICampaignService;
import polling.Services.ICandidateService;
import polling.Services.IElectionServices;
import polling.Services.IuserServices;
import polling.Services.IvoterServices;
import polling.Services.UserServices;
import polling.Services.VoterServices;

/**
 * Servlet implementation class DirectUserServlet
 */
@WebServlet("/DirectUserServlet")
public class DirectUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DirectUserServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		User user = new User();

		user.setEmail(request.getParameter("email"));

		IuserServices iuserServices = new UserServices();
		user = iuserServices.getUserByEmail(user);

		request.setAttribute("user", user);
		RequestDispatcher dispatcher;

		String action = request.getParameter("choose");

		
		Candidate c = new Candidate();
		Election elec = new Election();
		ICampaignService iCampaignService = new CampaignService();
		ICandidateService iCandidateService = new CandidateService();
		IElectionServices ie = new ElectionServices();
		if(action.equals("VOTER")){

			IvoterServices iv = new VoterServices();
			Voter voter = iv.getVoterByID(user.getId());
			String district = " ";
			if (voter.getDistrict() == null) {
				voter.setDistrict(district);
				request.setAttribute("voter", voter);
				dispatcher = getServletContext().getRequestDispatcher("/editVoterDetails.jsp");
			} else {
				request.setAttribute("voter", voter);
				dispatcher = getServletContext().getRequestDispatcher("/voterProfile.jsp");
			}

		}
		else{
			//boolean check exist by method
			//if() candidate is not registered
			if(!iuserServices.checkCandidate(user.getId()) || iuserServices.checkCandidateStatus(user.getId()))
			dispatcher = getServletContext().getRequestDispatcher("/CandidateRegistration.jsp");
			else {
				c = iCandidateService.getCandidatebyId(user.getId());
				elec = ie.getElectionByID(c.getElectionId());
				List<Campaign> camDetails = iCampaignService.getCampaignByCandidate(user.getId());
				List<Candidate> candidateDetails = null; //iCandidateService.getCandidate(c.getCandidateId(), c.getElectionId(), e.getElectionName(),e.getElectionType());
				//List<Candidate> candidateDetails = iCandidateService.getCandidate(c.getCandidateId(), c.getElectionId(), e.getElectionName(),e.getElectionType());
				
				request.setAttribute("candidateDetails", candidateDetails);
				request.setAttribute("camDetails", camDetails);

				dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/view/Candidate.jsp");
			// else to candidate profile if registered
		}
		}
		dispatcher.forward(request, response);
	}

}
