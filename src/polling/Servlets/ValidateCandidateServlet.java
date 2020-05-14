package polling.Servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import polling.Models.Candidate;
import polling.Models.Voter;
import polling.Services.ElectionServices;
import polling.Services.IElectionServices;

/**
 * Servlet implementation class ValidateCandidateServlet
 */
@WebServlet("/ValidateCandidateServlet")
public class ValidateCandidateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ValidateCandidateServlet() {
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
		
		Candidate c = new Candidate();
		c.setCandidateId(request.getParameter("id"));
		
		IElectionServices ie = new ElectionServices();
		ie.validateCandidate(c.getCandidateId());
		
		String msg = "Candidate Validation Successful"; 
				
		request.setAttribute("msg", msg);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/view/CandidateList.jsp");
		dispatcher.forward(request, response);
	}

}
