package polling.Servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.IntUnaryOperator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import polling.Models.Candidate;
import polling.Models.Election;
import polling.Models.Voter;
import polling.Services.IvoterServices;
import polling.Services.VoterServices;
import polling.Services.displyCandidate;

/**
 * Servlet implementation class selectElectionServlet
 */
@WebServlet("/selectElectionServlet")
public class selectElectionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String Election = request.getParameter("Election");
		String id = request.getParameter("id");
		/*int Eid = Integerpassint(request.getParameter("Eid"));*/
		
		
		IvoterServices iv = new VoterServices();
		int Ei=iv.getElectionId(Election);
		String Eid=Integer.toString(Ei);
		boolean istrue=iv.voterValidate(id,Eid);	//1
		
		String topic = "status is invalid or you have already voted for " +Election+" Election";
		
		request.setAttribute("id", id);
		request.setAttribute("Eid",Eid);
		Voter voter =iv. getVoterByID(id);
		request.setAttribute("voter",voter);
		if(istrue == true){
			if(Election.equals("President") ){
				List<Candidate> candidate= displyCandidate.validate1(Election,Eid);
				request.setAttribute("candidate", candidate);
				RequestDispatcher d = getServletContext().getRequestDispatcher("/PresidentCandidatelist.jsp");
				d.forward(request, response);
			}
			else if(Election.equals("Parliament")){
				List<String> party= displyCandidate.validate2(Election,id,Eid);
				request.setAttribute("party", party);
				RequestDispatcher d = getServletContext().getRequestDispatcher("/selectAParty.jsp");
				d.forward(request, response);
				
			}    
		}
		else{
			ArrayList<Election> election =iv.currentElections();
			request.setAttribute("election",election);
			request.setAttribute("topic", topic);
			RequestDispatcher d = getServletContext().getRequestDispatcher("/selectElection.jsp");
			d.forward(request, response);
		}
	}
	
}

