package polling.Servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import polling.Models.Candidate;
import polling.Services.displyCandidate;

/**
 * Servlet implementation class selectParliamentCandidateServlet
 */
@WebServlet("/selectParliamentCandidateServlet")
public class selectParliamentCandidateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public selectParliamentCandidateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id=request.getParameter("id");
		String party =request.getParameter("party");
		String Eid = request.getParameter("Eid");
		
		ArrayList<Candidate> candidate= displyCandidate.validate3(party,id,Eid);
		request.setAttribute("candidate", candidate);
		request.setAttribute("Eid", Eid);
		request.setAttribute("id", id);
		request.setAttribute("party", party);
		RequestDispatcher d = getServletContext().getRequestDispatcher("/ParliamentCandidatelist.jsp");
		d.forward(request, response);
	}

}
