package polling.Services;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;
import java.io.IOException;

import polling.Models.Campaign;
import polling.Utils.CommonConstants;
import polling.Utils.CommonUtil;
import polling.Utils.DBConnectionUtil;
import polling.Utils.QueryUtil;

public class CampaignService implements ICampaignService {
	
	public static final Logger log = Logger.getLogger(CampaignService.class.getName());
	private static Connection connection;
	private PreparedStatement preparedStatement;
	
	/**
	 * This method will retrieve all the campaign id in the campaign table
	 * 
	 */
	
	private ArrayList<String> getCampaignIDs(){
		
		ArrayList<String> arrayList = new ArrayList<String>();
		/*
		 * List of campaignIds fromQuery.xml
		 */
		try {
			connection = DBConnectionUtil.getDBConnection();
			preparedStatement = connection
					.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_GET_CAMPAIGN_IDS));
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				arrayList.add(resultSet.getString(CommonConstants.COLUMN_INDEX_ONE));
			}
		} catch (Exception e) {
			e.printStackTrace();
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
			}  catch (SQLException e) {
				log.log(Level.SEVERE, e.getMessage());
			}
		}
		return arrayList;
	}
	
	/**
	 * This method will add a campaign to the campaign table with reference
	 *  to the user id and the election id
	 * 
	 */
	
	public List<Campaign> addCampaign (String candidateId, int electionId, String heading, String statement,String description) {
		ArrayList<Campaign> campaignDetails = new ArrayList<Campaign>();
		String CampaignId = CommonUtil.generateIDs(getCampaignIDs());
		try {
			connection = DBConnectionUtil.getDBConnection();
			preparedStatement = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_INSERT_CAMPAIGN));
			
			connection.setAutoCommit(false);
			String campaignId = CampaignId;
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, campaignId);
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_TWO, candidateId);
			preparedStatement.setInt(CommonConstants.COLUMN_INDEX_THREE, electionId);
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_FOUR, heading);
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_FIVE, statement);
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_SIX, description);
			
			preparedStatement.executeUpdate();
			Campaign campaign = new Campaign(campaignId,candidateId,electionId,heading,statement,description);
			campaignDetails.add(campaign);
			connection.commit();
		}  catch (SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException e) {
			log.log(Level.SEVERE, e.getMessage());
		}finally {
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
		return campaignDetails;
	}
	
	/**
	 * This method will retrieve all the campaign details by using 
	 * the campaign id, user id and election id
	 * 
	 */
	
	public List<Campaign> getCampaign(String campaignId,String candidateId,int electionId){
		ArrayList<Campaign> campaignDetails = new ArrayList<Campaign>();
		try {
			connection = DBConnectionUtil.getDBConnection();
			preparedStatement = connection.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_GET_CAMPAIGN_DETAILS));
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, campaignId);
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_TWO, candidateId);
			preparedStatement.setInt(CommonConstants.COLUMN_INDEX_THREE, electionId);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				String campaignID=resultSet.getString(CommonConstants.COLUMN_INDEX_ONE);
				String candidateID=resultSet.getString(CommonConstants.COLUMN_INDEX_TWO);
				int electionID =resultSet.getInt(CommonConstants.COLUMN_INDEX_THREE);
				String heading=resultSet.getString(CommonConstants.COLUMN_INDEX_FOUR);
				String statement=resultSet.getString(CommonConstants.COLUMN_INDEX_FIVE);
				String description =resultSet.getString(CommonConstants.COLUMN_INDEX_SIX);
				
				Campaign campaign = new Campaign(campaignID,candidateID,electionID,heading,statement,description);
				campaignDetails.add(campaign);
			}
		}  catch (SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException e) {
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
		return campaignDetails;
	}
	
	/**
	 * This method will set the changes / update the campaign details of a distinct record in the campaign table
	 * 
	 */
	
	public boolean updateCampaign(String campaignId,String candidateId, int electionId,Campaign campaign) {
		
		boolean isTrue = false;
		
		if (campaignId != null && !campaignId.isEmpty() && candidateId != null && !candidateId.isEmpty() && electionId != 0 ) {
			try {
				connection = DBConnectionUtil.getDBConnection();
				preparedStatement = connection
						.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_UPDATE_CAMPAIGN));
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, campaign.getHeading());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_TWO, campaign.getStatement());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_THREE, campaign.getDescription());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_FOUR, campaign.getCampaignId());
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_FIVE, campaign.getCandidateId());
				preparedStatement.setInt(CommonConstants.COLUMN_INDEX_SIX, campaign.getElectionId());
				int result = preparedStatement.executeUpdate();
				
				if (result>0) {
					isTrue = true;
				}
				else {
					isTrue = false;
				}

			}  catch (SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException e) {
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
	 * This method will delete the record of the campaign from the campaign table
	 * 
	 */
	
	public void removeCampaign(String campaignId,String candidateId, int electionId) {
		if (campaignId != null && !campaignId.isEmpty()) {
			try {
				connection = DBConnectionUtil.getDBConnection();
				preparedStatement = connection
						.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_REMOVE_CAMPAIGN));
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, campaignId);
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_TWO, candidateId);
				preparedStatement.setInt(CommonConstants.COLUMN_INDEX_THREE, electionId);
				preparedStatement.executeUpdate();
			}  catch (SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException e) {
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
	}
	
	/**
	 * This method will take a campaign type object list and assign the objects value to an array
	 * 
	 */
	
	public String[] getListElements(List<Campaign> campaign) {
		
		List<Campaign> cam = campaign;
		String arr[] = new String [3];
		
		arr[0] = cam.get(0).getHeading();
		arr[1] = cam.get(0).getStatement();
		arr[2] = cam.get(0).getDescription();
		
		return arr;
	}
		
	@Override
	public List<Campaign> getCampaignByCandidate(String CandidateId){
		
		List<Campaign> cam = new ArrayList<>();
		
		try {
			connection = DBConnectionUtil.getDBConnection();
			
			preparedStatement = connection.prepareStatement("select * from campaign where userid = ?");
			
			preparedStatement.setString(1, CandidateId);
			
			ResultSet rs = preparedStatement.executeQuery();
			
			while(rs.next()){
				Campaign c = new Campaign();
				c.setCampaignId(rs.getString(1));
				c.setDescription(rs.getString(6));
				c.setHeading(rs.getString(4));
				c.setStatement(rs.getString(5));
				cam.add(c);
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return cam;
	}
	
}
