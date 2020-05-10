package polling.Services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

import polling.Utils.DBConnectionUtil;

import polling.Models.Candidate;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class displyCandidate {
	private static Connection con;
	private static PreparedStatement ps;
	private static Statement stmt;
	private static ResultSet rs ;
	
	/*public static List<candidate> validate1(String Election,String id){
		ArrayList<candidate> can= new ArrayList<>();
		try {
		
		con = DBConnect.getconnection();
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
					String name=rs.getString(2);
					String party = rs.getString(4);
					
					candidate ca = new candidate();
					ca.setName(name); 
					ca.setParty(party);
					can.add(ca);
					
				}
			}
		
				
		}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return can;
	} */   
	public static ArrayList<Candidate> validate3(String party,String id,String Eid) {

		ArrayList<Candidate> candidateList = new ArrayList<Candidate>();
		try {
			con = DBConnectionUtil.getDBConnection();
			/*
			 * Before fetching employee it checks whether employee ID is
			 * available
			 */
			ps = con.prepareStatement("select * from voter where id=? ");
			ps.setString(1,id);
			rs=ps.executeQuery();
			
			if(rs.next()){
				String  district=rs.getString(3);
				String  Election = "Parliament";
						//employeeID != null && !employeeID.isEmpty()
					//String namm = "passs";
					ps = con.prepareStatement("select c.userId, u.name ,c.candidateNum from candidate c,user u where (c.userId = u.Id and c.district =?) and (c.party=? and c.state =?) and c.electionId = ? ORDER BY c.candidateNum"); //election = ? and
					/*ps.setString(1,Election);*/
					ps.setString(1,district);
					ps.setString(2,party);
					ps.setString(3,"Valid");
					
					/*String sql1 = "selct * from candidate where election = '"+Election+"' and id='"+Vaa+"' ";*/
					rs=ps.executeQuery();
					
					//String Vaa = "C01";
					//String sql1 = "update candidate set name ='"+namm+"' , where id ='"+Vaa+"' ";
					//int rs= stmt.executeUpdate(sql1);
					
					while(rs.next()){
						Candidate candidate = new Candidate();
						candidate.setId(rs.getString(1));
						candidate.setName(rs.getString(2));
						candidate.setNo(rs.getInt(3));
						candidateList.add(candidate);
						
					}
				
			/*
			 * If employee ID is not provided for get employee option it display
			 * all employees
			 */
		} 
			
		}catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		return candidateList;
	}
	
	
	public static ArrayList<Candidate> validate1(String Election,String Eid) {

		ArrayList<Candidate> candidateList = new ArrayList<Candidate>();
		try {
			con = DBConnectionUtil.getDBConnection();
			/*
			 * Before fetching employee it checks whether employee ID is
			 * available
			 */
			/*ps = con.prepareStatement("selct * from voter where id=? ");
			ps.setString(1,id);
			rs=ps.executeQuery();*/
			
			/*if(rs.next()){
				String  status=rs.getString(2);
				if(status.equals("Valid")){*/		//employeeID != null && !employeeID.isEmpty()
					//String namm = "passs";
					ps = con.prepareStatement("select c.userId, u.name,c.party,c.candidateNum from candidate c,user u where c.userId = u.Id  and c.state =? and c.electionId = ? ORDER BY c.candidateNum"); ///election = ? and 
					ps.setString(1,"Valid");
					ps.setString(2,Eid);
					/*ps.setString(1,Election);*/
					/*String sql1 = "selct * from candidate where election = '"+Election+"' and id='"+Vaa+"' ";*/
					rs=ps.executeQuery();
					
					//String Vaa = "C01";
					//String sql1 = "update candidate set name ='"+namm+"' , where id ='"+Vaa+"' ";
					//int rs= stmt.executeUpdate(sql1);
					
					while(rs.next()){
						Candidate candidate = new Candidate();
						candidate.setId(rs.getString(1));
						candidate.setName(rs.getString(2)); 
						candidate.setParty(rs.getString(3));
						candidate.setNo(rs.getInt(4));
						candidateList.add(candidate);
						
					}
				/*}*/
				/*else{
					
				}
			
			 * If employee ID is not provided for get employee option it display
			 * all employees
			 */
		
		}catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		return candidateList;
	}
	
	public static ArrayList<String> validate2(String Election,String id,String Eid){
		ArrayList<String> par= new ArrayList<String>();
		try {
			con = DBConnectionUtil.getDBConnection();
			ps = con.prepareStatement("select * from voter where id=?");
			ps.setString(1,id);
			rs=ps.executeQuery();
		
		if(rs.next()){
			String dis=rs.getString(3);
			String status = "Valid";
				ps = con.prepareStatement("select DISTINCT party from candidate  where district = ?  and  state = ? and electionId = ?");  //and election = ?
				ps.setString(1,dis);
				/*ps.setString(2,Election);*/
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
				
		
		 
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return par;
	}   
	public static void addVoter(String Election,String party,String id,String Eid,String Cid){
		
		try {
			con = DBConnectionUtil.getDBConnection();
			ps = con.prepareStatement("insert into votes values(?,?)");
			ps.setInt(1,Integer.parseInt(Eid));
			ps.setString(2,id);
			ps.executeUpdate();
			
			ps = con.prepareStatement("select * from results where electionId=? and userId =?");
			ps.setInt(1,Integer.parseInt(Eid));
			ps.setString(2,Cid);
			rs=ps.executeQuery();
			if(rs.next()){
				//int coun=rs.getInt(3);
				//problem update candidate count 
				ps = con.prepareStatement("update results set count = count + 1 where electionId = ? and userId = ?");
				//ps.setInt(1, coun);
				ps.setInt(1,Integer.parseInt(Eid));
				ps.setString(2,Cid);
				ps.executeUpdate();
			}
			else{
				ps = con.prepareStatement("insert results values(?,?,?)");
				ps.setInt(1,Integer.parseInt(Eid));
				ps.setString(2,Cid);
				ps.setInt(3, 1);// problem
				
				
			}
			if(Election.equals("Parliament")){
				//problem party count
			}
			else{
				
			}
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	} 
	/*public static List<Voter> getProfileDetails(String Id){
		ArrayList<Voter> vo = new ArrayList<>();
		
	
		try {
			con =DBConnect.getconnection();
			ps = con.prepareStatement("selct district,status from voter where id='"+Id+"'  ");
			ps.setString(1,vo.Id);
			rs = ps.executeQuery();
			
			if(rs.next()){
				String district = rs.getString(1);
				String status = rs.getString(2);
				if(status.equals("valid")){
					
				}
				
				Voter vot = new Voter(Id,status,district);
				 
				vo.add(vot);
			}
		}	
		 catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return vo;
	}*/
}