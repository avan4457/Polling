package polling.Utils;

import java.sql.*;
import java.util.Properties;

public class DBConnectionUtil extends CommonUtil {

	private static Connection con;

	private DBConnectionUtil() {
	}

	public static Connection getDBConnection() throws ClassNotFoundException, SQLException {

		if (con == null || con.isClosed()) {
			Class.forName(properties.getProperty(CommonConstants.DRIVER_NAME));
			con = DriverManager.getConnection(properties.getProperty(CommonConstants.URL),
					properties.getProperty(CommonConstants.USER_NAME),
					properties.getProperty(CommonConstants.PASSWORD));
		}
		return con;
	}

}
