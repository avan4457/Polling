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
import polling.Utils.DBConnectionUtil;
import polling.Utils.QueryUtil;

import java.sql.Statement;

//doiapdia
public class VoterServices implements IvoterServices {

	private static Connection con;
	public static final Logger log = Logger.getLogger(UserServices.class.getName());
	private static PreparedStatement ps;
	private static Statement stmt;
	private static ResultSet rs ;
	@Override
	public void RegisterVoter(Voter v) {
	
		
		
		try {
			con =DBConnectionUtil.getDBConnection();
			ps = con.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_GET_VOTER));
			ps.setString(1,v.getId());
			rs=ps.executeQuery();
			if(rs.next()){
				/*con = DBConnect.getconnection();*/
				/*stmt = con.createStatement();
				String sql1 ="update voter set district=? where id= ?";
				ps = con.prepareStatement(sql1);*/
				
				ps = con.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_UPDATE_VOTER));
				ps.setString(1,v.getDistrict());
				ps.setString(2,v.getStatus());
				ps.setString(3,v.getId());
			   ps.executeUpdate();
			   //int s=
			   
			}
			else{
				ps = con.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_INSERT_VOTER));
				
				con.setAutoCommit(false);
				ps.setString(1, v.getId());
				ps.setString(3, v.getDistrict());
				ps.setString(2, v.getStatus());
				
				ps.execute();	
				con.commit();	
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
		
	}

	@Override
	public ArrayList<Election> currentElections() {
		// TODO Auto-generated method stub
		ArrayList<Election> arr = new ArrayList<Election>();
		 
		try {
			con = DBConnectionUtil.getDBConnection();
			/*stmt = con.createStatement();*/
			/*String sql = "select name from Election where starting_date <=SYSDATE() and ending_date>=SYSDATE()";*/
			/*rs=stmt.executeQuery(sql);*/
			ps = con.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_GET_ELECTION));
			rs=ps.executeQuery();
			
			while(rs.next()){
				Election election= new Election();
				election.setElectionID(rs.getInt(1));
				election.setElectionName(rs.getString(2));
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
	public boolean districtStatus(String id) {
		// TODO Auto-generated method stub
		boolean istrue = false;
		try {
			con = DBConnectionUtil.getDBConnection();
			/*stmt = con.createStatement();*/
			/*String sql = "select district from voter where id=?";*/
			ps = con.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_GET_VOTER));
			ps.setString(1,id);
			rs=ps.executeQuery();
			/*rs=stmt.executeQuery(sql);*/
			/*String dis =rs.getString(1);*/
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

	public boolean upda(){
		boolean tr=true;
		return tr;
	}

	public ArrayList<Voter> getVoterDetails(String id){
		Voter va =  new Voter();
		ArrayList<Voter> ar = new ArrayList<>();
		
		try {
			con = DBConnectionUtil.getDBConnection();
			ps = con.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_GET_VOTER));
			ps.setString(1,id);
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
				va.setId(ID);
				va.setDistrict(district);
				va.setStatus(status);
				
				ar.add(va);
				
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
	public Voter getVoterByID(String voterID) {

		Voter voter = new Voter();
		try{
			con = DBConnectionUtil.getDBConnection();
			/*
			 * Before fetching employee it checks whether employee ID is
			 * available
			 */
			/*if (voterID != null && !voterID.isEmpty()) {*/
				/*
				 * Get employee by ID query will be retrieved from
				 * EmployeeQuery.xml
				 */
				ps = con.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_GET_VOTER));
				ps.setString(1,voterID);
				
			/*}*/
			/*
			 * If employee ID is not provided for get employee option it display
			 * all employees
			 */
			/*else {
				preparedStatement = connection
						.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_ALL_EMPLOYEES));
			}*/
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
	
	
	public boolean voterValidate(String id,String Eid) {
		// TODO Auto-generated method stub
		boolean istrue = false;
		try {
			con = DBConnectionUtil.getDBConnection();
			/*
			 * Before fetching employee it checks whether employee ID is
			 * available
			 */
			ps = con.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_GET_VOTER));
			ps.setString(1,id);
			rs=ps.executeQuery();
			
			if(rs.next()){
				String  status=rs.getString(2);
				
				ps = con.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_CHECKED_VOTES_TABLE));
				ps.setInt(1,Integer.parseInt(Eid));
				ps.setString(2,id);
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
	/*public void voted(String id){
		con = DBConnect.getconnection();
		String a = "Voted";
		try {
			ps = con.prepareStatement("update voter set PrEStatus = ?  where id=? "); //must change this
			ps.setString(1,a);
			ps.setString(2,id);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}*/
	
	public int getElectionId(String Election){
		int id=0;
		
		/*stmt = con.createStatement();*/
		/*String sql = "select name from Election where starting_date <=SYSDATE() and ending_date>=SYSDATE()";*/
		/*rs=stmt.executeQuery(sql);*/
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
	public boolean deleteVoterById(String id){
		boolean istrue = false;
		
		
		try {
			con=DBConnectionUtil.getDBConnection();
			ps = con.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_DELETE_VOTER_BY_ID));
			ps.setString(1,id);
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
	/*private ArrayList<Candidate> actionOnCandidate(String Election,String id) {

		ArrayList<Candidate> candidateList = new ArrayList<Candidate>();
		try {
			con = DBConnect.getconnection();
			
			 * Before fetching employee it checks whether employee ID is
			 * available
			 
			ps = con.prepareStatement("selct * from voter where id=? ");
			ps.setString(1,id);
			rs=ps.executeQuery();
			
			if(rs.next()){
				String  status=rs.getString(2);
				if(status.equals("Valid")){		//employeeID != null && !employeeID.isEmpty()
					//String namm = "passs";
					ps = con.prepareStatement("selct * from candidate where election = ? ");
					ps.setString(1,Election);
					String sql1 = "selct * from candidate where election = '"+Election+"' and id='"+Vaa+"' ";
					rs=ps.executeQuery();
					
					//String Vaa = "C01";
					//String sql1 = "update candidate set name ='"+namm+"' , where id ='"+Vaa+"' ";
					//int rs= stmt.executeUpdate(sql1);
					
					while(rs.next()){
						Candidate candidate = new Candidate();
						candidate.setName(rs.getString(2)); 
						candidate.setParty(rs.getString(4));
						candidateList.add(candidate);
						
					}
				}
			
			 * If employee ID is not provided for get employee option it display
			 * all employees
			 
		} 
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		return candidateList;
	}*/


}
