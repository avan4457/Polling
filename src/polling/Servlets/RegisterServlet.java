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
import polling.Services.IvoterServices;
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
		User u = new User();
		u.setId(request.getParameter("id"));
		u.setEmail(request.getParameter("email"));
		u.setGender(request.getParameter("gender"));
		u.setName(request.getParameter("name"));
		u.setNic(request.getParameter("nic"));
		u.setPassword(request.getParameter("password"));
		u.setPhoneNumber(request.getParameter("phoneNumber"));
		Voter v = new Voter();
		
		v.setId(request.getParameter("id"));
		v.setDistrict(request.getParameter("district"));
		//v.setStatus(request.getParameter("Status"));
		v.setStatus("Invalid");
		/*v.setId("c0123456");*/
		
		
		//request.setAttribute("v", v);
		
		IvoterServices iv = new VoterServices();
		
		iv.RegisterVoter(v);		
		Voter voter =iv. getVoterByID(v.getId());
		request.setAttribute("voter", voter);
		request.setAttribute("user", u);
		
		RequestDispatcher d = getServletContext().getRequestDispatcher("/voterProfile.jsp");
		d.forward(request, response);
		
		
	}

}