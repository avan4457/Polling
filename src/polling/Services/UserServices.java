/**
 * 
 */
package polling.Services;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.http.Part;
import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import com.sun.org.apache.bcel.internal.generic.RETURN;

import polling.Models.User;
import polling.Utils.CommonConstants;
import polling.Utils.CommonUtil;
import polling.Utils.DBConnectionUtil;
import polling.Utils.QueryUtil;

/**
 * @author avchlk
 *
 */
public class UserServices implements IuserServices {

	public static Connection conn;

	public static final Logger log = Logger.getLogger(UserServices.class.getName());

	public static boolean exist;

	private PreparedStatement prepdStatement;

	/*
	 * (non-Javadoc)
	 * 
	 * @see polling.Services.IuserServices#RegisterUser()
	 */
	@Override
	public void RegisterUser(User user) {

		String id = CommonUtil.generateId(user);

		try {
			conn = DBConnectionUtil.getDBConnection();

			prepdStatement = conn.prepareStatement(QueryUtil.queryByID(CommonConstants.Query_Id_Insert_User));
			conn.setAutoCommit(false);

			user.setId(id);
			prepdStatement.setString(1, user.getId());
			prepdStatement.setString(2, user.getName());
			prepdStatement.setString(3, user.getEmail());
			prepdStatement.setString(4, user.getPassword());
			prepdStatement.setString(5, user.getPhoneNumber());
			prepdStatement.setString(6, user.getGender());
			prepdStatement.setString(7, user.getNic());

			prepdStatement.execute();
			conn.commit();
		} catch (SQLException | ClassNotFoundException | SAXException | IOException | ParserConfigurationException e) {
			log.log(Level.SEVERE, e.getMessage());
		} finally {
			if (prepdStatement != null)
				try {
					prepdStatement.close();
					if (conn != null)
						conn.close();
				} catch (SQLException e) {
					log.log(Level.SEVERE, e.getMessage());
				}
		}

	}

	@Override
	public boolean CheckExist(User user) {

		try {
			conn = DBConnectionUtil.getDBConnection();

			prepdStatement = conn
					.prepareStatement(QueryUtil.queryByID(CommonConstants.Query_Id_Select_User_By_MailandPW));

			prepdStatement.setString(1, user.getEmail());
			prepdStatement.setString(2, user.getPassword());

			ResultSet result = prepdStatement.executeQuery();

			if (result.next()) {
				exist = true;
			} else
				exist = false;

		} catch (ClassNotFoundException | SQLException | SAXException | IOException | ParserConfigurationException e) {
			log.log(Level.SEVERE, e.getMessage());
		} finally {
			if (prepdStatement != null)
				try {
					prepdStatement.close();
					if (conn != null)
						conn.close();
				} catch (SQLException e) {
					log.log(Level.SEVERE, e.getMessage());
				}
		}
		return exist;
	}

	@Override
	public User getUser(User user) {

		User u1 = new User();

		try {
			conn = DBConnectionUtil.getDBConnection();

			prepdStatement = conn
					.prepareStatement(QueryUtil.queryByID(CommonConstants.Query_Id_Select_User_By_MailandPW));

			prepdStatement.setString(1, user.getEmail());
			prepdStatement.setString(2, user.getPassword());

			ResultSet result = prepdStatement.executeQuery();

			while (result.next()) {
				u1.setId(result.getString(1));
				u1.setName(result.getString(2));
				u1.setEmail(result.getString(3));
				u1.setPassword(result.getString(4));
				u1.setPhoneNumber(result.getString(5));
				u1.setGender(result.getString(6));
				u1.setNic(result.getString(7));
				u1.setPic(result.getString(8));
			}

		} catch (ClassNotFoundException | SQLException | SAXException | IOException | ParserConfigurationException e) {
			log.log(Level.SEVERE, e.getMessage());
		} finally {
			if (prepdStatement != null)
				try {
					prepdStatement.close();
					if (conn != null)
						conn.close();
				} catch (SQLException e) {
					log.log(Level.SEVERE, e.getMessage());
				}
		}
		return u1;
	}

	@Override
	public boolean CheckEmailExists(User user) {

		boolean avail = false;
		try {
			conn = DBConnectionUtil.getDBConnection();

			prepdStatement = conn.prepareStatement(QueryUtil.queryByID(CommonConstants.Query_Id_Select_User_By_mail));

			prepdStatement.setString(1, user.getEmail());

			ResultSet result = prepdStatement.executeQuery();

			if (result.next()) {
				avail = true;
			} else
				avail = false;

		} catch (ClassNotFoundException | SQLException | SAXException | IOException | ParserConfigurationException e) {
			log.log(Level.SEVERE, e.getMessage());
		} finally {
			if (prepdStatement != null)
				try {
					prepdStatement.close();
					if (conn != null)
						conn.close();
				} catch (SQLException e) {
					log.log(Level.SEVERE, e.getMessage());
				}
		}
		return avail;
	}

	@Override
	public boolean updateUserProfile(User user, String oldPwd) {

		boolean run = false;
		try {
			conn = DBConnectionUtil.getDBConnection();

			if (user.getPassword().isEmpty()) {
				prepdStatement = conn.prepareStatement(QueryUtil.queryByID(CommonConstants.Query_Id_Update_User));

				prepdStatement.setString(1, user.getName());
				prepdStatement.setString(2, user.getPhoneNumber());
				prepdStatement.setString(3, user.getEmail());
				prepdStatement.setString(4, oldPwd);

				prepdStatement.executeUpdate();

				run = false;
			} else {
				prepdStatement = conn
						.prepareStatement(QueryUtil.queryByID(CommonConstants.Query_Id_Update_User_With_Pass));

				prepdStatement.setString(1, user.getName());
				prepdStatement.setString(2, user.getPhoneNumber());
				prepdStatement.setString(3, user.getPassword());
				prepdStatement.setString(4, user.getEmail());
				prepdStatement.setString(5, oldPwd);

				prepdStatement.executeUpdate();

				run = true;
			}

		} catch (ClassNotFoundException | SQLException | SAXException | IOException | ParserConfigurationException e) {
			log.log(Level.SEVERE, e.getMessage());
			;
		} finally {
			if (prepdStatement != null)
				try {
					prepdStatement.close();
					if (conn != null)
						conn.close();
				} catch (SQLException e) {
					log.log(Level.SEVERE, e.getMessage());
				}
		}
		return run;
	}

	@Override
	public User getUserByEmail(User user) {

		User u = new User();
		try {
			conn = DBConnectionUtil.getDBConnection();

			prepdStatement = conn.prepareStatement(QueryUtil.queryByID(CommonConstants.Query_Id_Select_User_By_mail));

			prepdStatement.setString(1, user.getEmail());
			ResultSet result = prepdStatement.executeQuery();

			while (result.next()) {
				u.setId(result.getString(1));
				u.setName(result.getString(2));
				u.setEmail(result.getString(3));
				u.setPassword(result.getString(4));
				u.setPhoneNumber(result.getString(5));
				u.setGender(result.getString(6));
				u.setNic(result.getString(7));
				u.setPic(result.getString(8));
			}

		} catch (ClassNotFoundException | SQLException | SAXException | IOException | ParserConfigurationException e) {
			log.log(Level.SEVERE, e.getMessage());
			;
		} finally {
			if (prepdStatement != null)
				try {
					prepdStatement.close();
					if (conn != null)
						conn.close();
				} catch (SQLException e) {
					log.log(Level.SEVERE, e.getMessage());
				}
		}
		return u;
	}

	@Override
	public void RemoveUser(User user) {

		try {
			conn = DBConnectionUtil.getDBConnection();

			prepdStatement = conn.prepareStatement(QueryUtil.queryByID(CommonConstants.Query_Id_Remove_User_By_Id));

			conn.setAutoCommit(false);
			prepdStatement.setString(1, user.getId());
			prepdStatement.execute();
			conn.commit();

		} catch (ClassNotFoundException | SQLException | SAXException | IOException | ParserConfigurationException e) {
			log.log(Level.SEVERE, e.getMessage());
			;
		} finally {
			if (prepdStatement != null)
				try {
					prepdStatement.close();
					if (conn != null)
						conn.close();
				} catch (SQLException e) {
					log.log(Level.SEVERE, e.getMessage());
				}
		}
	}

	@Override
	public String getFileName(Part part) {

		String DispContent = part.getHeader("content-disposition");
		String[] items = DispContent.split(";");
		for (String s : items) {
			if (s.trim().startsWith("filename")) {
				return s.substring(s.indexOf("=") + 2, s.length() - 1);
			}
		}
		return "";
	}

	@Override
	public void addProfImg(User user) {

		try {
			conn = DBConnectionUtil.getDBConnection();
			prepdStatement = conn.prepareStatement(QueryUtil.queryByID(CommonConstants.Query_Update_Profile_Pic));

			prepdStatement.setString(1, user.getPic());
			prepdStatement.setString(2, user.getEmail());

			prepdStatement.executeUpdate();

		} catch (SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException e) {
			log.log(Level.SEVERE, e.getMessage());
			;
		} finally {
			if (prepdStatement != null)
				try {
					prepdStatement.close();
					if (conn != null)
						conn.close();
				} catch (SQLException e) {
					log.log(Level.SEVERE, e.getMessage());
				}
		}
	}

	@Override
	public User getUserById(String Id) {

		User u = new User();
		try {
			conn = DBConnectionUtil.getDBConnection();

			prepdStatement = conn.prepareStatement("Select * from user where Id=?");

			prepdStatement.setString(1, Id);

			ResultSet rs = prepdStatement.executeQuery();

			if (rs.next()) {
				u.setId(rs.getString(1));
				u.setName(rs.getString(2));
				u.setEmail(rs.getString(3));
				u.setPassword(rs.getString(4));
				u.setPhoneNumber(rs.getString(5));
				u.setGender(rs.getString(6));
				u.setNic(rs.getString(7));
				u.setPic(rs.getString(8));
			}

		} catch (ClassNotFoundException | SQLException e) {
			log.log(Level.SEVERE, e.getMessage());
		}

		return u;
	}

	@Override
	public boolean checkReg(String Id) {
		boolean can = false;
		try {
			conn = DBConnectionUtil.getDBConnection();

			prepdStatement = conn.prepareStatement("select * from voter where id = ?");
			prepdStatement.setString(1, Id);
			ResultSet rv = prepdStatement.executeQuery();

			prepdStatement = conn.prepareStatement("select * from candidate where userId = ?");
			prepdStatement.setString(1, Id);
			ResultSet rc = prepdStatement.executeQuery();

			prepdStatement = conn.prepareStatement("select * from votes where userId = ?");
			prepdStatement.setString(1, Id);
			ResultSet rvs = prepdStatement.executeQuery();

			if (!rv.next() && !rc.next() && !rvs.next())
				can = true;

		} catch (ClassNotFoundException | SQLException e) {
			log.log(Level.SEVERE, e.getMessage());
		}
		return can;
	}

	@Override
	public boolean removeProfilePic(String Id) {
		boolean result = false;
		try {
			conn = DBConnectionUtil.getDBConnection();

			prepdStatement = conn.prepareStatement("update user set Image = 'default.png' where Id = ?");

			prepdStatement.setString(1, Id);
			int res = prepdStatement.executeUpdate();

			if (res > 0)
				result = true;
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public boolean checkCandidate(String Id) {
		boolean exist = false;

		try {
			conn = DBConnectionUtil.getDBConnection();

			prepdStatement = conn.prepareStatement("select * from candidate where userId = ?");

			prepdStatement.setString(1, Id);
			ResultSet rs = prepdStatement.executeQuery();

			if (rs.next())
				exist = true;
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return exist;
	}

	@Override
	public boolean checkCandidateStatus(String Id) {
		boolean exist = false;

		try {
			conn = DBConnectionUtil.getDBConnection();

			prepdStatement = conn.prepareStatement("select * from candidate where userId = ? and state = 'closed'");

			prepdStatement.setString(1, Id);

			ResultSet rs = prepdStatement.executeQuery();

			if (rs.next())
				exist = true;
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return exist;
	}
}
