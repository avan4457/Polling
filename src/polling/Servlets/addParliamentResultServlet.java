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
import polling.Services.IvoterServices;
import polling.Services.VoterServices;

//IT19390260 
/**
 * Servlet implementation class addParliamentResultServlet
 */
@WebServlet("/addParliamentResultServlet")
public class addParliamentResultServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addParliamentResultServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String Vid=request.getParameter("Vid");
		String party =request.getParameter("party");
		String Cid = request.getParameter("Cid");
		String Eid = request.getParameter("Eid");
		String Election = request.getParameter("Election");
		
		IvoterServices iv = new VoterServices();
		
		boolean istrue = iv.addVoterVotes(Election,party,Vid,Eid,Cid);
		
		ArrayList<Candidate>candidate = iv.GetCandidateById(Cid,Eid);
		request.setAttribute("candidate", candidate);
		
		request.setAttribute("Vid",Vid);
		request.setAttribute("party",party);
		request.setAttribute("Eid",Eid);
		request.setAttribute("Election",Election);
		
		if(istrue == true){
			String topic ="Vote has been entered successfully ";
			request.setAttribute("topic", topic);
			RequestDispatcher d = getServletContext().getRequestDispatcher("/Candidatelist.jsp");
			d.forward(request, response);
		}
		else{
			String topic ="Vote has been entered unsuccessfully ";
			request.setAttribute("topic", topic);
			RequestDispatcher d = getServletContext().getRequestDispatcher("/Candidatelist.jsp");
			d.forward(request, response);
		}
	
	}
		

}
