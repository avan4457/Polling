package polling.Services;

import java.util.logging.Logger;
import java.util.logging.Level;
import java.io.IOException;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;

import java.util.ArrayList;
import java.util.List;

import polling.Models.Candidate;
import polling.Utils.CommonConstants;
import polling.Utils.CommonUtil;
import polling.Utils.DBConnectionUtil;
import polling.Utils.QueryUtil;


public class CandidateService implements ICandidateService {

	public static final Logger log = Logger.getLogger(CandidateService.class.getName());
	

	private PreparedStatement preparedStatement;
	private static Connection connection;
	
	/**
	 * This method will retrieve all candidate numbers in the candidate table
	 * 
	 */
	
	private ArrayList<Integer> getCandidateNum(){
		ArrayList<Integer> arrayList = new ArrayList <Integer>();
		try {
			connection = DBConnectionUtil.getDBConnection();
			preparedStatement = connection
					.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_GET_CANDIDATE_NUM));
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				arrayList.add(resultSet.getInt(CommonConstants.COLUMN_INDEX_ONE));
			}
		} catch (SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException e) {
			log.log(Level.SEVERE, e.getMessage());
		} finally {
			/*
			 * Close prepared statement and database connectivity at the end of
			 * transaction
			 */
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return arrayList;
	}
	
	/**
	 * This method will obtain the electionId using the election and election type
	 * 
	 */
	
	public int obtainElectionId(String Election, String ElectionType) {
		int electionId = 0;
		try {
			connection = DBConnectionUtil.getDBConnection();
			preparedStatement = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_GET_ELECTION_ID));
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, Election);
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_TWO, ElectionType);
			ResultSet resultset = preparedStatement.executeQuery();
			while(resultset.next()) {
				electionId = resultset.getInt(CommonConstants.COLUMN_INDEX_ONE);
			}
		} catch (SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException e) {
			log.log(Level.SEVERE, e.getMessage());
		} finally {
			/*
			 * Close prepared statement and database connectivity at the end of
			 * transaction
			 */
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				log.log(Level.SEVERE, e.getMessage());
			}
		}
		return electionId;
	}
	
	/**
	 * This method will add a candidate in the candidate table
	 * 
	 */
	
	public void addCandidate(int electionId,String electionType, String election, String party, String district) {
	
		try {
			String candidateId = "1";
			int candidateNum = CommonUtil.generateNum(getCandidateNum());
			String state = "Nominated";
			connection = DBConnectionUtil.getDBConnection();
			preparedStatement = connection.prepareStatement((QueryUtil.queryByID(CommonConstants.QUERY_ID_INSERT_CANDIDATE)));
			
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, candidateId);
			preparedStatement.setInt(CommonConstants.COLUMN_INDEX_TWO, electionId);
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_THREE, party);
			preparedStatement.setInt(CommonConstants.COLUMN_INDEX_FOUR, candidateNum);
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_FIVE, district);
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_SIX, state);
			
			preparedStatement.executeUpdate();
			
			//connection.commit();
			
			
		} catch (SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException e) {
			log.log(Level.SEVERE, e.getMessage());
		} finally {
			
			 // Close prepared statement and database connectivity at the end of
			 //transaction
			 
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				log.log(Level.SEVERE, e.getMessage());
			}
		}
		
	}
	
	/**
	 * This method will retrieve the candidate in the candidate table
	 * 
	 */
	
	public ArrayList<Candidate> getCandidate(String candidateId, int electionId,String election,String electionType) {
		ArrayList<Candidate> canDetails = new ArrayList<Candidate>();
		try {
			connection = DBConnectionUtil.getDBConnection();
			preparedStatement = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_GET_CANDIDATE_DETAILS));
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, candidateId);
			preparedStatement.setInt(CommonConstants.COLUMN_INDEX_TWO, electionId);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				String candidateID = resultSet.getString(CommonConstants.COLUMN_INDEX_ONE);
				int electionID = resultSet.getInt(CommonConstants.COLUMN_INDEX_TWO);
				String party = resultSet.getString(CommonConstants.COLUMN_INDEX_THREE);
				int number = resultSet.getInt(CommonConstants.COLUMN_INDEX_FOUR);
				String district = resultSet.getString(CommonConstants.COLUMN_INDEX_FIVE);
				String state = resultSet.getString(CommonConstants.COLUMN_INDEX_SIX);
				
				Candidate candidate = new Candidate(candidateID,electionID,election,electionType,party,number,district,state);
				canDetails.add(candidate);
			}
		} catch (SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException e) {
			log.log(Level.SEVERE, e.getMessage());
		}finally {
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				log.log(Level.SEVERE, e.getMessage());
			}
		}
		return canDetails;
	}
	
	/**
	 * This method will check and delete the candidate if the state is only nominated
	 * 
	 */
	
	public boolean removeCandidate(String candidateId, String electionId, String state) {
		String canState="Nominated";
		boolean isTrue = false;
		if (candidateId != null && !candidateId.isEmpty() && electionId != null && !electionId.isEmpty() && state == canState) {
			try {
				connection = DBConnectionUtil.getDBConnection();
				preparedStatement = connection
						.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_REMOVE_CANDIDATE));
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, candidateId);
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_TWO, electionId);
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_THREE, canState);
				int result = preparedStatement.executeUpdate();
				if(result > 0) {
					isTrue = true;
				}
				else {
					isTrue = false;
				}
			} catch (SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException e) {
				log.log(Level.SEVERE, e.getMessage());
			} finally {
				/*
				 * Close prepared statement and database connectivity at the end
				 * of transaction
				 */
				try {
					if (preparedStatement != null) {
						preparedStatement.close();
					}
					if (connection != null) {
						connection.close();
					}
				} catch (SQLException e) {
					log.log(Level.SEVERE, e.getMessage());
				}
			}
		}
		return isTrue;
	}
	
	/**
	 * This method will change state of candidate to closed if election date is
	 * 
	 */
	
	/*public boolean closeCandidate(String candidateId, String electionId, String state) {
			
	}*/
}
	
	
		

	

