package polling.Servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import polling.Services.IuserServices;
import polling.Services.IvoterServices;
import polling.Services.UserServices;
import polling.Services.VoterServices;
import polling.Models.User;
import polling.Models.Voter;


/**
 * Servlet implementation class updateVoterDetailsServlet
 */
@WebServlet("/updateVoterDetailsServlet")
public class updateVoterDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updateVoterDetailsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		/*User u = new User();
		u.setId("C01234");
		u.setEmail("dilshan@gmilcom");
		u.setGender("male");
		u.setName("dilshan");
		u.setNic("981303016V");
		u.setPassword("dilshan123");
		u.setPhoneNumber("0718827789");*/
		
		String id= request.getParameter("id");
		
		 
		/*request.setAttribute("user", u);*/
		
		IuserServices iu = new UserServices();
		User user=iu.getUserDetails(id);
		
		request.setAttribute("user", user);
		
		IvoterServices iv = new VoterServices();
		 Voter voter =iv.getVoterByID(id);
		 request.setAttribute("voter", voter);
		
		/*voter voter = iv.districtStatus(v);*/
		
		
		boolean isTrue =iv.districtStatus(id);
		
		/*RequestDispatcher di = getServletContext().getRequestDispatcher("/voterProfile.jsp");
		di.forward(request, response);*/
		
		 if(isTrue == false){
			
			RequestDispatcher d = getServletContext().getRequestDispatcher("/editVoterDetails.jsp");
			d.forward(request, response);
		 }
		 else if(isTrue == true){
			RequestDispatcher d = getServletContext().getRequestDispatcher("/voterProfile.jsp");
			d.forward(request, response);
		}
		
	}

}
