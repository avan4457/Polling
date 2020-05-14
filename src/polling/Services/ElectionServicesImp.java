package polling.Services;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.parsers.ParserConfigurationException;

import java.io.IOException;
import org.xml.sax.SAXException;

import polling.Models.Candidate;
import polling.Models.Election;
import polling.Models.Voter;
import polling.Utils.CommonConstants;
import polling.Utils.CommonUtil;
import polling.Utils.DBConnectionUtil;
import polling.Utils.QueryUtil;

public class ElectionServicesImp implements IElectionServices {

	public static final Logger logr = Logger.getLogger(ElectionServicesImp.class.getName());

	private static Connection con;

	private static Statement statement;

	private PreparedStatement preparedStatements;

	/*
	 * static { // create table or drop its exists createElectionTable(); }
	 */

	/*
	 * public static void createElectionTable() {
	 * 
	 * try { con = DBConnectionUtil.getDBConnection();
	 * 
	 * statement = con.createStatement();
	 * 
	 * statement.executeUpdate(QueryUtil.queryById(CommonConstants.DROP_ELECTION
	 * )); statement.executeUpdate(QueryUtil.queryById(CommonConstants.
	 * CREATE_ELECTION)); } catch (ClassNotFoundException | SQLException |
	 * SAXException | IOException | ParserConfigurationException e) { // TODO
	 * Auto-generated catch block logr.log(Level.SEVERE, e.getMessage()); }
	 * 
	 * }
	 */

	@Override
	public Election getElectionByID(int electionID) {

		ArrayList<Election> electionList = new ArrayList<Election>();
		try {
			con = DBConnectionUtil.getDBConnection();

			preparedStatements = con.prepareStatement("select * from election where election.electionID = ?");
			preparedStatements.setInt(1, electionID);

			ResultSet rs = preparedStatements.executeQuery();

			while (rs.next()) {
				Election election = new Election();

				election.setElectionID(rs.getInt(CommonConstants.INDEX_ONE));
				election.setElectionName(rs.getString(CommonConstants.INDEX_TWO));
				election.setElectionType(rs.getString(CommonConstants.INDEX_THREE));
				Date sDate = rs.getDate(CommonConstants.INDEX_FOUR);
				Date eDate = rs.getDate(CommonConstants.INDEX_FIVE);
				election.setStartDate(sDate.toLocalDate());
				election.setEndDate(eDate.toLocalDate());
				electionList.add(election);
			}

		} catch (SQLException | ClassNotFoundException e) {
			logr.log(Level.SEVERE, e.getMessage());

		} finally {
			try {
				if (preparedStatements != null) {
					preparedStatements.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				logr.log(Level.SEVERE, e.getMessage());
			}
		}
		return electionList.get(0);
	}

	@Override
	public ArrayList<Election> getElection() {

		ArrayList<Election> electionList = new ArrayList<Election>();

		try {
			con = DBConnectionUtil.getDBConnection();

			preparedStatements = con.prepareStatement("select * from election");// QueryUtil.queryById(CommonConstants.ALL_SELECT_ELECTION)

			ResultSet rs = preparedStatements.executeQuery();

			while (rs.next()) {
				Election election = new Election();

				election.setElectionID(rs.getInt(CommonConstants.INDEX_ONE));
				election.setElectionName(rs.getString(CommonConstants.INDEX_TWO));
				election.setElectionType(rs.getString(CommonConstants.INDEX_THREE));
				Date sDate = rs.getDate(CommonConstants.INDEX_FOUR);
				Date eDate = rs.getDate(CommonConstants.INDEX_FIVE);
				election.setStartDate(sDate.toLocalDate());
				election.setEndDate(eDate.toLocalDate());
				electionList.add(election);
			}

		} catch (SQLException | ClassNotFoundException e) {
			logr.log(Level.SEVERE, e.getMessage());

		} finally {
			try {
				if (preparedStatements != null) {
					preparedStatements.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				logr.log(Level.SEVERE, e.getMessage());
			}
		}
		return electionList;
	}

	/*
	 * @Override public ArrayList<Election> getElectionsByClosingDate() {
	 * 
	 * ArrayList<Election> elec = new ArrayList<Election>();
	 * 
	 * try { con = DBConnectionUtil.getDBConnection();
	 * 
	 * ps = con.
	 * prepareStatement("select * from election where endDate < current_date()"
	 * );
	 * 
	 * ResultSet rs = ps.executeQuery();
	 * 
	 * while(rs.next()){ Election e = new Election(); e.setId(rs.getInt(1));
	 * e.setName(rs.getString(2)); e.setType(rs.getString(3));
	 * e.setStartDate(rs.getDate(4)); e.setEndDate(rs.getDate(5)); elec.add(e);
	 * }
	 * 
	 * } catch (ClassNotFoundException | SQLException e) { e.printStackTrace();
	 * } return elec; }
	 */

	@Override
	public void upDateElection(Election election, int electionID) {
		// TODO Auto-generated method stub

		try {
			con = DBConnectionUtil.getDBConnection();
			preparedStatements = con.prepareStatement(
					"update election set election.electionName = ? , election.electionType = ?, election.startDate = ?, election.endDate = ? where election.electionID = ?");

			preparedStatements.setString(CommonConstants.INDEX_ONE, election.getElectionName());
			preparedStatements.setString(CommonConstants.INDEX_TWO, election.getElectionType());
			preparedStatements.setDate(CommonConstants.INDEX_THREE, Date.valueOf(election.getStartDate()));
			preparedStatements.setDate(CommonConstants.INDEX_FOUR, Date.valueOf(election.getEndDate()));
			preparedStatements.setInt(CommonConstants.INDEX_FIVE, election.getElectionID());

			preparedStatements.executeUpdate();

		} catch (SQLException | ClassNotFoundException e) {
			logr.log(Level.SEVERE, e.getMessage());

		} finally {
			try {
				if (preparedStatements != null) {
					preparedStatements.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				logr.log(Level.SEVERE, e.getMessage());
			}
		}
	}

	@Override
	public void deleteElection(int electionID) {
		// TODO Auto-generated method stub
		try {
			con = DBConnectionUtil.getDBConnection();
			preparedStatements = con.prepareStatement("delete from election where election.electionID = ?");
			preparedStatements.setInt(CommonConstants.INDEX_ONE, electionID);
			preparedStatements.execute();

		} catch (SQLException | ClassNotFoundException e) {
			logr.log(Level.SEVERE, e.getMessage());
		} finally {
			try {
				if (preparedStatements != null) {
					preparedStatements.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				logr.log(Level.SEVERE, e.getMessage());
			}
		}
	}

	@Override
	public void addElection(Election election) {
		// TODO Auto-generated method stub

		ArrayList<Election> elections = getElection();
		ArrayList<Integer> eIds = new ArrayList<Integer>();

		for (Election e : elections) {
			Election el = new Election();
			el.setElectionID(e.getElectionID());
			eIds.add(el.getElectionID());
		}

		int eleId = CommonUtil.genarateElectionId(eIds);

		try {
			con = DBConnectionUtil.getDBConnection();

			preparedStatements = con.prepareStatement("insert into election values(?,?,?,?,?)");

			con.setAutoCommit(false);

			election.setElectionID(eleId);

			preparedStatements.setInt(1, election.getElectionID());
			preparedStatements.setString(2, election.getElectionName());
			preparedStatements.setString(3, election.getElectionType());
			preparedStatements.setDate(4, Date.valueOf(election.getStartDate()));
			preparedStatements.setDate(5, Date.valueOf(election.getEndDate()));

			preparedStatements.execute();
			con.commit();

		} catch (SQLException | ClassNotFoundException e) {
			logr.log(Level.SEVERE, e.getMessage());
		} finally {
			try {
				if (preparedStatements != null) {
					preparedStatements.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				logr.log(Level.SEVERE, e.getMessage());
			}
		}
	}

	@Override
	public ArrayList<Election> getElectionsByClosingDate() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<String> genResults(int elecId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean validateVoter(String id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean validateCandidate(String id) {
		// TODO Auto-generated method stub
		return false;
	}

	public ArrayList<Voter> getVoterList() {

		ArrayList<Voter> arry = new ArrayList<Voter>();

		try {
			con = DBConnectionUtil.getDBConnection();
			preparedStatements = con.prepareStatement("select * from voter where status = 'Invalid' order by district");
			ResultSet result = preparedStatements.executeQuery();

			while (result.next()) {
				Voter voterLs = new Voter();

				voterLs.setId(result.getString(1));
				voterLs.setStatus(result.getString(2));
				voterLs.setDistrict(result.getString(3));
				arry.add(voterLs);
			}
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return arry;
	}

	public ArrayList<Candidate> getCandidateList() {

		ArrayList<Candidate> arr = new ArrayList<Candidate>();

		try {
			con = DBConnectionUtil.getDBConnection();
			preparedStatements = con.prepareStatement("select * from candidate where state = 'Nominated' order by district");
			ResultSet result = preparedStatements.executeQuery();

			while (result.next()) {
				Candidate candiLs = new Candidate();

				candiLs.setCandidateId(result.getString(1));
				candiLs.setElectionId(result.getInt(2));
				candiLs.setParty(result.getString(3));
				candiLs.setNumber(result.getInt(4));
				candiLs.setDistrict(result.getString(5));
				candiLs.setState(result.getString(6));
				arr.add(candiLs);
				
			}
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return arr;
	}

}
