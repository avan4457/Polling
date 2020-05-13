package polling.Servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import polling.Models.User;
import polling.Models.Voter;
import polling.Services.IuserServices;
import polling.Services.IvoterServices;
import polling.Services.UserServices;
import polling.Services.VoterServices;


/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
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
		String Vid=request.getParameter("Vid");
		String district=request.getParameter("district");
		String status = "Invalid";
		
		IuserServices iu = new UserServices();
		User user=iu.getUserById(Vid);
		request.setAttribute("user", user);
		
		
		
		IvoterServices iv = new VoterServices();
		
		boolean istrue =iv.RegisterVoter(Vid,district,status);		
		Voter voter =iv. getVoterByID(Vid);
		request.setAttribute("voter", voter);
		
		
		if(istrue == true){
		RequestDispatcher d = getServletContext().getRequestDispatcher("/voterProfile.jsp");
		d.forward(request, response);
		}
		else if(istrue == false){
			RequestDispatcher d = getServletContext().getRequestDispatcher("/editVoterDetails.jsp");
			d.forward(request, response);
		}
		
	}

}
