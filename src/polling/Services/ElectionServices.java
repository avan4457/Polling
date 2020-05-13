package polling.Services;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Logger;

import polling.Models.Election;
import polling.Models.User;
import polling.Models.Voter;
import polling.Utils.CommonConstants;
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
				e.setElectionID(rs.getInt(1));
				e.setElectionName(rs.getString(2));
				e.setElectionType(rs.getString(3));
				Date sDate = rs.getDate(CommonConstants.INDEX_FOUR);
				Date eDate = rs.getDate(CommonConstants.INDEX_FIVE);
				e.setStartDate(sDate.toLocalDate());
				e.setEndDate(eDate.toLocalDate());
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

	@Override
	public Election getElectionByID(int electionID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Election> getElection() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void upDateElection(Election election, int electionID) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteElection(int electionID) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addElection(Election election) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean validateVoter(String id) {
		
		boolean res = false;
		try {
			con = DBConnectionUtil.getDBConnection();
			
			ps = con.prepareStatement("update voter set status = 'Valid' where id = ?");
			ps.setString(1, id);
			
			int check = ps.executeUpdate();
			
			if(check > 0)
				res = true;
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return res;
	}

	@Override
	public boolean validateCandidate(String id) {
		
		boolean res = false;
		try {
			con = DBConnectionUtil.getDBConnection();
			
			ps = con.prepareStatement("update candidate set state = 'Approved' where userId = ?");
			ps.setString(1, id);
			
			int check = ps.executeUpdate();
			
			if(check > 0)
				res = true;
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return res;
	}

	@Override
	public ArrayList<Voter> getVoterList() {
		// TODO Auto-generated method stub
		return null;
	}

}
