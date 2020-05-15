package polling.Servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import polling.Models.User;
import polling.Services.IuserServices;
import polling.Services.UserServices;
import polling.Utils.CommonConstants;

/**
 * Servlet implementation class LogInUserServlet
 */
@WebServlet("/LogInUserServlet")
public class LogInUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LogInUserServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");

		User user = new User();

		String log = "Login failed,Check your credentials!!";

		user.setEmail(request.getParameter("email"));
		user.setPassword(request.getParameter("password"));

		String email = user.getEmail();
		IuserServices iuserservice = new UserServices();

		user = iuserservice.getUser(user);

		request.setAttribute("user", user);
		RequestDispatcher dispatcher;
		String submit = request.getParameter("submit");

		if (submit.equals("Login")) {
			if (iuserservice.CheckExist(user)) {
				request.setAttribute("user", user);
				JOptionPane.showMessageDialog(null, "Login Successful");
				if (user.getEmail().equals(CommonConstants.Admin_Email)) {
					dispatcher = getServletContext().getRequestDispatcher("/Admin.jsp");
					dispatcher.forward(request, response);
				} else if (user.getEmail().equals(CommonConstants.Commissioner_Mail)) {
					dispatcher = getServletContext().getRequestDispatcher("/Commissioner.jsp");
					dispatcher.forward(request, response);
				} else {
					dispatcher = getServletContext().getRequestDispatcher("/Home.jsp");
					dispatcher.forward(request, response);
				}
			} else {
				JOptionPane.showMessageDialog(null, "Login Failed");
				request.setAttribute("log", log);
				dispatcher = request.getRequestDispatcher("/index.jsp");
				dispatcher.forward(request, response);
			}
		} else if (submit.equals("forgot Password")) {
			if (!email.isEmpty()) {
				request.setAttribute("email", email);
				dispatcher = getServletContext().getRequestDispatcher("/ForgotPass.jsp");
			} else {
				JOptionPane.showMessageDialog(null, "Please enter your email first");
				dispatcher = request.getRequestDispatcher("/index.jsp");
			}
			dispatcher.forward(request, response);
		}
	}
}
