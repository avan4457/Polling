package polling.Servlets;

import javax.servlet.http.HttpServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import polling.Services.ElectionServicesImp;
import polling.Services.IElectionServices;

import java.io.IOException;

@WebServlet("/DeleteElectionServlet")
public class DeleteElectionServlet extends HttpServlet {
//delete servlet
	private static final long serialVersionEID = 1871871796669342804L;

	public DeleteElectionServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String msg2 = "WELCOME!!";
		response.setContentType("text/html");

		int electionID = Integer.parseInt(request.getParameter("electionID"));

		IElectionServices iElectionServices = new ElectionServicesImp();
		boolean resul = iElectionServices.deleteElection(electionID);
		request.setAttribute("msg2", msg2);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/view/ElectionList.jsp");
		if (resul == false) {
			msg2 = "Sorry the Election is currently running or unavailable!!";
			request.setAttribute("msg2", msg2);
			dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/view/ElectionList.jsp");

		}
		dispatcher.forward(request, response);
	}

}
