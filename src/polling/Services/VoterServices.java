package polling.Services;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import polling.Models.Candidate;
import polling.Models.Election;
import polling.Models.Voter;
import polling.Utils.CommonConstants;
import polling.Utils.DBConnect;
import polling.Utils.DBConnectionUtil;
import polling.Utils.QueryUtil;

import java.sql.Statement;

public class VoterServices implements IvoterServices {

	private static Connection con;
	public static final Logger log = Logger.getLogger(UserServices.class.getName());
	private static PreparedStatement ps;
	private static Statement stmt;
	private static ResultSet rs ;
	
	@Override
	public boolean RegisterVoter(String Vid, String district, String status) {
		boolean istrue=false;
		try {
				
				con =DBConnectionUtil.getDBConnection();
				ps = con.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_GET_VOTER));
				ps.setString(1,Vid);
				rs=ps.executeQuery();
				if(rs.next()){
					
					ps = con.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_UPDATE_VOTER));
					ps.setString(1,district);
					ps.setString(2,status);
					ps.setString(3,Vid);
				   ps.executeUpdate();
				
				   istrue=true;
				}
				else{
					ps = con.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_INSERT_VOTER));
					ps.setString(1,Vid);
					ps.setString(2,status);
					ps.setString(3,district);
					ps.execute();	
					istrue=true;
				}
			
		} catch (SQLException | ClassNotFoundException | SAXException | IOException | ParserConfigurationException e ) {
			log.log(Level.SEVERE, e.getMessage());
		}
		finally{
			if(ps != null)
				try {
					ps.close();
					if(con != null)
						con.close();
				}
				catch (SQLException e) {
					log.log(Level.SEVERE, e.getMessage());
				}			
		}
		return istrue;
	}

	@Override
	public ArrayList<Election> currentElections() {
		// TODO Auto-generated method stub
		ArrayList<Election> arr = new ArrayList<Election>();
		 
		try {
			con = DBConnectionUtil.getDBConnection();
			ps = con.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_GET_ELECTION));
			rs=ps.executeQuery();
			
			while(rs.next()){
				Election election= new Election();
				election.setId(rs.getInt(1));
				election.setName(rs.getString(2));
				arr.add(election);
			}
		} catch (SQLException | ClassNotFoundException | SAXException | IOException | ParserConfigurationException e) {
			// TODO Auto-generated catch block
			log.log(Level.SEVERE, e.getMessage());
		}
		finally{
			if(ps != null)
				try {
					ps.close();
					if(con != null)
						con.close();
				}
				catch (SQLException e) {
					log.log(Level.SEVERE, e.getMessage());
				}			
		}	
		
		return arr;
	}

	@Override
	public boolean districtStatus(String Vid) {
		// TODO Auto-generated method stub
		boolean istrue = false;
		try {
			con = DBConnectionUtil.getDBConnection();
			ps = con.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_GET_VOTER));
			ps.setString(1,Vid);
			rs=ps.executeQuery();
			if(rs.next()){
				 istrue=true;
				 
			}
			else{
				istrue=false;
			}
		} catch (SQLException | ClassNotFoundException | SAXException | IOException | ParserConfigurationException e) {
			// TODO Auto-generated catch block
			log.log(Level.SEVERE, e.getMessage());
		}
		finally{
			if(ps != null)
				try {
					ps.close();
					if(con != null)
						con.close();
				}
				catch (SQLException e) {
					log.log(Level.SEVERE, e.getMessage());
				}			
		}
		
		return istrue;
	}



	public ArrayList<Voter> getVoterDetails(String Vid){
		Voter voter =  new Voter();
		ArrayList<Voter> ar = new ArrayList<>();
		
		try {
			con = DBConnectionUtil.getDBConnection();
			ps = con.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_GET_VOTER));
			ps.setString(1,Vid);
			rs=ps.executeQuery();
		} catch (SQLException | ClassNotFoundException | SAXException | IOException | ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		try {
			if(rs.next()){
				String ID=rs.getString(1);
				String status=rs.getString(2);
				String district=rs.getString(3);
				voter.setId(ID);
				voter.setDistrict(district);
				voter.setStatus(status);
				
				ar.add(voter);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			log.log(Level.SEVERE, e.getMessage());
		}
		finally{
			if(ps != null)
				try {
					ps.close();
					if(con != null)
						con.close();
				}
				catch (SQLException e) {
					log.log(Level.SEVERE, e.getMessage());
				}			
		}
		return ar;
	}
	
	@Override
	public Voter getVoterByID(String Vid) {

		Voter voter = new Voter();
		try{
			con = DBConnectionUtil.getDBConnection();
				ps = con.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_GET_VOTER));
				ps.setString(1,Vid);
			rs=ps.executeQuery();

			if (rs.next()) {
				voter.setId(rs.getString(1));
				voter.setDistrict(rs.getString(3));
				voter.setStatus(rs.getString(2));
			}
		}
		catch (SQLException | ClassNotFoundException | SAXException | IOException | ParserConfigurationException e) {
			// TODO Auto-generated catch block
			log.log(Level.SEVERE, e.getMessage());
		}
		finally{
			if(ps != null)
				try {
					ps.close();
					if(con != null)
						con.close();
				}
				catch (SQLException e) {
					log.log(Level.SEVERE, e.getMessage());
				}			
		}
		 
		return voter;
	}
	
	
	public boolean voterValidate(String Vid,String Eid) {
		// TODO Auto-generated method stub
		boolean istrue = false;
		try {
			con = DBConnectionUtil.getDBConnection();
			
			ps = con.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_GET_VOTER));
			ps.setString(1,Vid);
			rs=ps.executeQuery();
			
			if(rs.next()){
				String  status=rs.getString(2);
				
				ps = con.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_CHECKED_VOTES_TABLE));
				ps.setInt(1,Integer.parseInt(Eid));
				ps.setString(2,Vid);
				rs=ps.executeQuery();
				
				if(status.equals("Valid") && !rs.next()){	
				 istrue=true;
				}
				else{
					istrue=false;
				}
			}
			else{
				istrue=false;
			}
		} catch (SQLException | ClassNotFoundException | SAXException | IOException | ParserConfigurationException e) {
			// TODO Auto-generated catch block
			log.log(Level.SEVERE, e.getMessage());
		}
		finally{
			if(ps != null)
				try {
					ps.close();
					if(con != null)
						con.close();
				}
				catch (SQLException e) {
					log.log(Level.SEVERE, e.getMessage());
				}			
		}
		
		return istrue;
	}
	
	public int getElectionId(String Election){
		int id=0;
		
		try {
			con=DBConnectionUtil.getDBConnection();
			ps = con.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_GET_ELECTION_ID));
			ps.setString(1,Election);
			rs=ps.executeQuery();
			
			while(rs.next()){
			 id=rs.getInt(1);
			}
		} catch (SQLException | ClassNotFoundException | SAXException | IOException | ParserConfigurationException e) {
			// TODO Auto-generated catch block
			log.log(Level.SEVERE, e.getMessage());
		}
		finally{
			if(ps != null)
				try {
					ps.close();
					if(con != null)
						con.close();
				}
				catch (SQLException e) {
					log.log(Level.SEVERE, e.getMessage());
				}			
		}
		
		return id;
	}
	public boolean deleteVoterById(String Vid){
		boolean istrue = false;
		
		
		try {
			con=DBConnectionUtil.getDBConnection();
			ps = con.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_DELETE_VOTER_BY_ID));
			ps.setString(1,Vid);
			int r=ps.executeUpdate();
			if(r>0){
				istrue=true;
			}
			else{
				istrue = false;
			}
		} catch (SQLException | ClassNotFoundException | SAXException | IOException | ParserConfigurationException e) {
			// TODO Auto-generated catch block
			log.log(Level.SEVERE, e.getMessage());
		}
		finally{
			if(ps != null)
				try {
					ps.close();
					if(con != null)
						con.close();
				}
				catch (SQLException e) {
					log.log(Level.SEVERE, e.getMessage());
				}			
		}
		
		
		return istrue;
	}
/*	--------------------------------------------------------*/
	
public  ArrayList<Candidate> GetParliamentCandidatelist(String party,String Vid,String Eid) {

		ArrayList<Candidate> candidateList = new ArrayList<Candidate>();
		try {
			con = DBConnectionUtil.getDBConnection();
			ps = con.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_GET_VOTER));
			ps.setString(1,Vid);
			rs=ps.executeQuery();
			
			if(rs.next()){
				String  district=rs.getString(3);
				String  Election = "Parliament";
						
					ps = con.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_GET_CANDIDATE_LIST)); 
					
					ps.setString(1,district);
					ps.setString(2,party);
					ps.setString(3,"Valid");
					ps.setString(4,Eid);
					
					
					rs=ps.executeQuery();
					
					
					
					while(rs.next()){
						Candidate candidate = new Candidate();
						candidate.setId(rs.getString(1));
						candidate.setName(rs.getString(2));
						candidate.setNo(rs.getInt(3));
						candidateList.add(candidate);
						
					}
				
			
		} 
		}catch (SQLException | ClassNotFoundException | SAXException | IOException | ParserConfigurationException e) {
			// TODO Auto-generated catch block
			log.log(Level.SEVERE, e.getMessage());
		}
		finally{
			if(ps != null)
				try {
					ps.close();
					if(con != null)
						con.close();
				}
				catch (SQLException e) {
					log.log(Level.SEVERE, e.getMessage());
				}			
		}
		
		return candidateList;
	}
	
	
	public  ArrayList<Candidate> GetPresidentCandidatelist(String Election,String Eid) {

		ArrayList<Candidate> candidateList = new ArrayList<Candidate>();
		try {
			con =DBConnectionUtil.getDBConnection();
					ps = con.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_GET_CANDIDATE_LIST_WITH_PARTY)); 
					ps.setString(1,"Valid");
					ps.setString(2,Eid);
					rs=ps.executeQuery();
					
				
					
					while(rs.next()){
						Candidate candidate = new Candidate();
						candidate.setId(rs.getString(1));
						candidate.setName(rs.getString(2)); 
						candidate.setParty(rs.getString(3));
						candidate.setNo(rs.getInt(4));
						candidateList.add(candidate);
						
					}
				
		
		}catch (SQLException | ClassNotFoundException | SAXException | IOException | ParserConfigurationException e) {
			// TODO Auto-generated catch block
			log.log(Level.SEVERE, e.getMessage());
		}
		finally{
			if(ps != null)
				try {
					ps.close();
					if(con != null)
						con.close();
				}
				catch (SQLException e) {
					log.log(Level.SEVERE, e.getMessage());
				}			
		}
		
		return candidateList;
	}
	
	public ArrayList<String> GetPartyies(String Election,String Vid,String Eid){
		ArrayList<String> par= new ArrayList<String>();
		try {
			con = DBConnectionUtil.getDBConnection();
			ps = con.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_GET_VOTER));// it checks whether Voter ID is available
			ps.setString(1,Vid);
			rs=ps.executeQuery();
		
		if(rs.next()){
			String dis=rs.getString(3);
			String status = "Valid";
				ps = con.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_GET_PARTIES));  
				ps.setString(1,dis);
				ps.setString(2,status);
				ps.setString(3,Eid);
				rs=ps.executeQuery();
				
				while(rs.next()){
					String party = rs.getString(1);
					par.add(party);
					
				}
			}
			else{
				
			}
				
		
		 
		} catch (SQLException | ClassNotFoundException | SAXException | IOException | ParserConfigurationException e) {
			// TODO Auto-generated catch block
			log.log(Level.SEVERE, e.getMessage());
		}
		finally{
			if(ps != null)
				try {
					ps.close();
					if(con != null)
						con.close();
				}
				catch (SQLException e) {
					log.log(Level.SEVERE, e.getMessage());
				}			
		}
		
		
		return par;
	}   
	public  boolean addVoterVotes(String Election,String party,String Vid,String Eid,String Cid){
		boolean istrue=false;
		
		try {
			con=DBConnectionUtil.getDBConnection();
			ps = con.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_INSERT_VOTES));
			ps.setInt(1,Integer.parseInt(Eid));
			ps.setString(2,Vid);
			ps.execute();
			
			ps = con.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_CHECKED_RESULTS));
			ps.setInt(1,Integer.parseInt(Eid));
			ps.setString(2,Cid);
			rs=ps.executeQuery();
			istrue=true;
			if(rs.next()){
				ps = con.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_UPDATE_RESULTS));
				ps.setInt(1,Integer.parseInt(Eid));
				ps.setString(2,Cid);
				ps.executeUpdate();
			}
			else{
				ps = con.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_INSERT_RESULTS));
				ps.setInt(1,Integer.parseInt(Eid));
				ps.setString(2,Cid);
				ps.setInt(3, 1);
				ps.execute();
				
			}
			if(Election.equals("Parliament")){
				ps = con.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_CHECKED_PARTYVOTES));
				ps.setInt(1,Integer.parseInt(Eid));
				ps.setString(2,party);
				rs=ps.executeQuery();
				if(rs.next()){
					ps = con.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_UPDATE_PARTYVOTES));
					ps.setInt(1,Integer.parseInt(Eid));
					ps.setString(2,party);
					ps.executeUpdate();
				}
				else{
					ps = con.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_INSERT_PARTYVOTES));
					ps.setInt(1,Integer.parseInt(Eid));
					ps.setString(2,party);
					ps.setInt(3, 1);
					ps.execute();
				}
			}
			else{
				istrue=true;
			}
			istrue=true;
		} catch (SQLException | ClassNotFoundException | SAXException | IOException | ParserConfigurationException e) {
			// TODO Auto-generated catch block
			log.log(Level.SEVERE, e.getMessage());
		}
		finally{
			if(ps != null)
				try {
					ps.close();
					if(con != null)
						con.close();
				}
				catch (SQLException e) {
					log.log(Level.SEVERE, e.getMessage());
				}			
		}
		return istrue;
	} 
	public  ArrayList<Candidate> GetCandidateById(String Cid,String Eid) {

		ArrayList<Candidate> candidateList = new ArrayList<Candidate>();
		try {
			con = DBConnectionUtil.getDBConnection();
					ps = con.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_GET_CANDIDATE_LIST_WITH_status)); 
					ps.setString(1,Eid);
					ps.setString(2,Cid);
					rs=ps.executeQuery();
					
					while(rs.next()){
						Candidate candidate = new Candidate();
						candidate.setId(rs.getString(1));
						candidate.setName(rs.getString(2)); 
						candidate.setParty(rs.getString(3));
						candidate.setNo(rs.getInt(4));
						candidateList.add(candidate);
						
					}
			
		
		}catch (SQLException | ClassNotFoundException | SAXException | IOException | ParserConfigurationException e) {
			// TODO Auto-generated catch block
			log.log(Level.SEVERE, e.getMessage());
		}
		finally{
			if(ps != null)
				try {
					ps.close();
					if(con != null)
						con.close();
				}
				catch (SQLException e) {
					log.log(Level.SEVERE, e.getMessage());
				}			
		} 
		
		return candidateList;
	}
}

