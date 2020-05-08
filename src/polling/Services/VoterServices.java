package polling.Services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import polling.Models.Candidate;
import polling.Models.Election;
import polling.Models.Voter;
import polling.Utils.DBConnect;

import java.sql.Statement;


public class VoterServices implements IvoterServices {

	private static Connection con;
	private static PreparedStatement ps;
	private static Statement stmt;
	private static ResultSet rs ;
	@Override
	public void RegisterVoter(Voter v) {
	
		con = DBConnect.getconnection();
		
		try {
			con = DBConnect.getconnection();
			ps = con.prepareStatement("select * from voter where id=?");
			ps.setString(1,v.getId());
			rs=ps.executeQuery();
			if(rs.next()){
				/*con = DBConnect.getconnection();*/
				/*stmt = con.createStatement();
				String sql1 ="update voter set district=? where id= ?";
				ps = con.prepareStatement(sql1);*/
				
				ps = con.prepareStatement("update voter set district=?,status=? where id= ?");
				ps.setString(1,v.getDistrict());
				ps.setString(2,v.getStatus());
				ps.setString(3,v.getId());
			   ps.executeUpdate();
			   //int s=
			   
			}
			else{
				ps = con.prepareStatement("insert into voter values(?,?,?)");
				
				con.setAutoCommit(false);
				ps.setString(1, v.getId());
				ps.setString(3, v.getDistrict());
				ps.setString(2, v.getStatus());
				
				ps.execute();	
				con.commit();	
			}
			
				
			
			
		} catch (SQLException e ) {
			e.printStackTrace();
		}
		
	}

	@Override
	public ArrayList<Election> currentElections() {
		// TODO Auto-generated method stub
		ArrayList<Election> arr = new ArrayList<Election>();
		 
		try {
			con = DBConnect.getconnection();
			/*stmt = con.createStatement();*/
			/*String sql = "select name from Election where starting_date <=SYSDATE() and ending_date>=SYSDATE()";*/
			/*rs=stmt.executeQuery(sql);*/
			ps = con.prepareStatement("select * from election where startDate <=SYSDATE() and endDate>=SYSDATE()");
			rs=ps.executeQuery();
			
			while(rs.next()){
				Election election= new Election();
				election.setId(rs.getInt(1));
				election.setName(rs.getString(2));
				arr.add(election);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
		return arr;
	}

	@Override
	public boolean districtStatus(String id) {
		// TODO Auto-generated method stub
		boolean istrue = false;
		try {
			con = DBConnect.getconnection();
			/*stmt = con.createStatement();*/
			/*String sql = "select district from voter where id=?";*/
			ps = con.prepareStatement("select * from voter where id=?");
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
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
		con = DBConnect.getconnection();
		try {
			ps = con.prepareStatement("select * from voter where id=?");
			ps.setString(1,id);
			rs=ps.executeQuery();
		} catch (SQLException e) {
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
			e.printStackTrace();
		}
		return ar;
	}
	
	@Override
	public Voter getVoterByID(String voterID) {

		Voter voter = new Voter();
		try{
			con = DBConnect.getconnection();
			/*
			 * Before fetching employee it checks whether employee ID is
			 * available
			 */
			/*if (voterID != null && !voterID.isEmpty()) {*/
				/*
				 * Get employee by ID query will be retrieved from
				 * EmployeeQuery.xml
				 */
				ps = con.prepareStatement("select * from voter where id=?");
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

			while (rs.next()) {
				voter.setId(rs.getString(1));
				voter.setDistrict(rs.getString(3));
				voter.setStatus(rs.getString(2));
			}
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		return voter;
	}
	
	
	public boolean voterValidate(String id,String Eid) {
		// TODO Auto-generated method stub
		boolean istrue = false;
		try {
			con = DBConnect.getconnection();
			/*
			 * Before fetching employee it checks whether employee ID is
			 * available
			 */
			ps = con.prepareStatement("select * from voter  where id=?  ");
			ps.setString(1,id);
			rs=ps.executeQuery();
			
			if(rs.next()){
				String  status=rs.getString(2);
				
				ps = con.prepareStatement("select * from votes where electionId= ? and userId=?  ");
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
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
		con = DBConnect.getconnection();
		/*stmt = con.createStatement();*/
		/*String sql = "select name from Election where starting_date <=SYSDATE() and ending_date>=SYSDATE()";*/
		/*rs=stmt.executeQuery(sql);*/
		try {
			
			ps = con.prepareStatement("select * from election where startDate <=SYSDATE() and endDate>=SYSDATE() and electionName = ?");
			ps.setString(1,Election);
			rs=ps.executeQuery();
			
			while(rs.next()){
			 id=rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return id;
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
