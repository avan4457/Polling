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
import polling.Services.CampaignService;
import polling.Services.ICampaignService;

/**
 * Servlet implementation class GetCampaign
 */
@WebServlet(description = "Fetch the campaign from the database", urlPatterns = { "/GetCampaign" })
public class GetCampaign extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetCampaign() {
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

 		String campaignId = request.getParameter("cid");
 		String candidateId = request.getParameter("uid");
 		int electionId = Integer.parseInt(request.getParameter("eid"));
		ICampaignService iCampaignService = new CampaignService();
		List<Campaign> camDetails = iCampaignService.getCampaign(campaignId,candidateId,electionId);

		request.setAttribute("camDetails", camDetails);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/view/Campaign.jsp");
		dispatcher.forward(request, response);
	}

}
