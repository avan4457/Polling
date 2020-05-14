package polling.Servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import polling.Services.CampaignService;
import polling.Services.ICampaignService;

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
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");

		String campaignID = request.getParameter("cid");
		String candidateId = request.getParameter("uid");
 		int electionId = Integer.parseInt(request.getParameter("eid"));
		
		ICampaignService iCampaignService = new CampaignService();
		iCampaignService.removeCampaign(campaignID,candidateId,electionId);

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/Candidate.jsp");
		dispatcher.forward(request, response);
	}

}