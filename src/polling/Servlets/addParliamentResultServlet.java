package polling.Servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import polling.Services.displyCandidate;

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
		String id=request.getParameter("id");
		String party =request.getParameter("party");
		String Cid = request.getParameter("Cid");
		String Eid = request.getParameter("Eid");
		String Election = request.getParameter("Election");
		
		displyCandidate.addVoter(Election,party,id,Eid,Cid);
		
		RequestDispatcher d = getServletContext().getRequestDispatcher("/selectUser.jsp");
		d.forward(request, response);
	}

}
