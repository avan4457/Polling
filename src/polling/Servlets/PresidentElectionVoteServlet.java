package polling.Servlets;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import polling.Services.IvoterServices;
import polling.Services.VoterServices;

/**
 * Servlet implementation class voterProfileServlet
 */
@WebServlet("/voterProfileServlet")
public class PresidentElectionVoteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PresidentElectionVoteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		/*String name=request.getParameter("name");*/
	/*	String cid=request.getParameter("cid");
		String vid=request.getParameter("vid");
		request.setAttribute("name",name);
		request.setAttribute("cid",cid);
		request.setAttribute("vid",vid);
		
		
		IvoterServices iv = new VoterServices();
		iv.voted(vid);
		
		RequestDispatcher dis = request.getRequestDispatcher("/selectUser.jsp");
		dis.forward(request, response);*/
		/*String kaal = request.getParameter("kaal");
		String v="voter";
		String Id = "C15";
		if(v.equals("voter")){
				List<Voter> vote=displyCandidate.getProfileDetails(Id);
				request.setAttribute("voter",vote );
				RequestDispatcher dis = request.getRequestDispatcher("voterProfile.jsp");
				dis.forward(request, response);
		}	*/	
	}

}
