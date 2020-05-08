package polling.Servlets;

import java.io.File;
import java.io.IOException;

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
 * Servlet implementation class SavePicServlet
 */
@WebServlet("/ProfilePicServlet")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2,
maxFileSize = 1024 * 1024 * 10,
maxRequestSize = 1024 * 1024 * 5)
public class ProfilePicServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProfilePicServlet() {
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
		
		User user = new User();
		String action = request.getParameter("submit");
		IuserServices iuserServices = new UserServices();
		user.setEmail(request.getParameter("pemail"));
		
		user = iuserServices.getUserByEmail(user);
		if(action.equals("Save")){
		Part part = request.getPart("pic");
		
		String fileName = iuserServices.getFileName(part);
		String savepath = "C:\\Users\\avant\\OneDrive\\Desktop\\SLIIT\\OOP\\eclipseP\\Project\\WebContent\\images\\" + File.separator + fileName;
		File file = new File(savepath);
		part.write(savepath + File.separator);
		
		user.setPic(fileName);
		
		iuserServices.addProfImg(user);		
		}
		else if(action.equals("Remove"))
			iuserServices.removeProfilePic(user.getId());
		user = iuserServices.getUserByEmail(user);
			
		request.setAttribute("user", user);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Home.jsp");
		dispatcher.forward(request, response);
	}

}
