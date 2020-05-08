package polling.Services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Logger;

import polling.Models.Election;
import polling.Models.User;
import polling.Utils.DBConnectionUtil;

public class ElectionServices implements IElectionServices {

	public static Connection con;
	public static Logger log;
	private PreparedStatement ps;
	
	@Override
	public ArrayList<Election> getElectionsByClosingDate() {
		
		ArrayList<Election> elec = new ArrayList<Election>();
		
		try {
			con = DBConnectionUtil.getDBConnection();
			
			ps = con.prepareStatement("select * from election where endDate < current_date()");
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				Election e = new Election();
				e.setId(rs.getInt(1));
				e.setName(rs.getString(2));
				e.setType(rs.getString(3));
				e.setStartDate(rs.getDate(4));
				e.setEndDate(rs.getDate(5));
				elec.add(e);
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return elec;
	}

	@Override
	public ArrayList<String> genResults(int elecId) {
		
		ArrayList<String> res = new ArrayList<String>();
		String eName = " ";
		Boolean opt2 = false;
		IuserServices iu = new UserServices();
		try {
			con = DBConnectionUtil.getDBConnection();
			
			ps = con.prepareStatement("select * from results where electionId = ? order by count desc");			
			ps.setInt(1, elecId);
			
			ResultSet rs = ps.executeQuery();
			
			ps = con.prepareStatement("Select electionType from election where electionId = ?");
			ps.setInt(1, elecId);
			
			ResultSet r = ps.executeQuery();
			
			if(r.next())
				 eName = r.getString("electionType");
			
			if(eName == "Parliament")
				opt2 = true;
			//option 2 - with party wise count of votes for parliament elections add party wise count inside while	
			while(rs.next()){
				User u = new User();
				String name;
				int count;
				u = iu.getUserById(rs.getString(2));
				name = u.getName();
				count = rs.getInt(3);
				res.add(name + ":- " + count);
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		return res;
	}

}
