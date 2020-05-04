package polling.Servlets;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import polling.Models.User;
import polling.Services.IuserServices;
import polling.Services.UserServices;

/**
 * Servlet implementation class EditDetailsServlet
 */
@WebServlet("/EditDetailsServlet")
public class EditDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditDetailsServlet() {
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
		
		User user = new User();
		String oldPwd = "Your password..";
		String msg = "*You must enter your current password to perform this action!!";
		
		user.setName(request.getParameter("name"));
		user.setPassword(request.getParameter("newPwd"));
		user.setPhoneNumber(request.getParameter("phone"));
		user.setEmail(request.getParameter("email"));
		oldPwd = request.getParameter("crtPwd");			
		
		IuserServices iuserServices = new UserServices();
		
		RequestDispatcher dispatcher;
		
		String action = request.getParameter("submit");
		
		if(action.equals("Save")){
		if(!oldPwd.isEmpty()){	
		if(!user.getName().isEmpty()){
			iuserServices.updateUserProfile(user, oldPwd);
			
		if(!iuserServices.updateUserProfile(user, oldPwd))
			user.setPassword(request.getParameter("crtPwd"));
			
		if(iuserServices.CheckExist(user)){
			user = iuserServices.getUser(user);
			
			request.setAttribute("user", user);
		}
		}
		else{
			msg = "Name should be filled!!";
			user = iuserServices.getUserByEmail(user);
			request.setAttribute("user", user);
			request.setAttribute("msg", msg);
		}
		}	
		else{
			//When Current password not entered
			user = iuserServices.getUserByEmail(user);
			request.setAttribute("user", user);
			request.setAttribute("msg", msg);
		}
		dispatcher = getServletContext().getRequestDispatcher("/Home.jsp");
		dispatcher.forward(request, response);
		}
		else{			
			if(!oldPwd.isEmpty()){
			user.setPassword(request.getParameter("crtPwd"));
			user = iuserServices.getUser(user);
			
			//if() to check user's relation to other tables
			iuserServices.RemoveUser(user);
			//else and set msg attribute
			
			dispatcher = getServletContext().getRequestDispatcher("/index.jsp");
			}
			else{
			user = iuserServices.getUserByEmail(user);
			request.setAttribute("user", user);
			request.setAttribute("msg", msg);
			dispatcher = getServletContext().getRequestDispatcher("/Home.jsp");
			}
			dispatcher.forward(request, response);
		}
		
	}
	
	

}
