package polling.Utils;

public class CommonConstants {
	
	/*--------------------------COMMISSIONER-----------------------------*/
  
	public static final String QUERY_XML = "queryfilepath";
	public static final String PROPERTY_FILE = "config.properties";
	public static final String ATT_ID = "id";
	public static final String URL = "url";
	public static final String TAG = "Query";
	public static final String USER_NAME = "username";
	public static final String PASSWORD = "password";
	public static final String DRIVER_NAME = "driverName";
	public static final String CREATE_ELECTION = "create_election_table";
	public static final String DROP_ELECTION = "drop_table";
	public static final String INSERT_ELECTION ="insert_election";
	public static final String GET_ELECTION = "election_by_id";
	public static final String REMOVE_ELECTION = "remove_election";
	public static final String UPDATE_ELECTION = "update_election";
	public static final String GET_ELECTION_ID = "election_ids";
	public static final String ALL_SELECT_ELECTION = "select_all_election";
	public static final int INDEX_ONE = 1;
	public static final int INDEX_TWO = 2;
	public static final int INDEX_THREE = 3;
	public static final int INDEX_FOUR = 4;
	public static final int INDEX_FIVE = 5;
	public static final int ELECTION_ID_PREFIX = 0;
	
  /*--------------------------USER-----------------------------*/
  
	public static final String Url = "url";
	
	public static final String Driver_Name = "driverName";
	
	public static final String Username = "username";
	
	public static final String Password = "password";
	
	public static final String Query_xml = "queryFilePath";
	
	public static final String Tag_Name = "Query";
	
	public static final String Attr_Id = "id";
	
	public static final String Property_File = "config.properties";
	
	public static final String Query_Id_Create_Table = "Create_Table";
	
	public static final String Query_Id_Insert_User = "Insert_User";
	
	public static final String Query_Id_Select_User_By_MailandPW = "Select_User_by_emailandPW";
		
	public static final String Query_Id_Select_User_By_mail = "Select_User_by_email";

	public static final String Admin_Email = "admin@polling.lk";
	
	public static final String Commissioner_Mail = "com@gov.lk";
	
	public static final String Query_Id_Update_User = "Update_User_Details";
	
	public static final String Query_Id_Update_User_With_Pass = "Update_User_Details_with_Password";
	
	public static final String Query_Id_Select_User_By_Id = "Select_user_by_id";

	public static final String Query_Id_Remove_User_By_Id = "Remove_User_By_Id";
	
	public static final String Query_Update_Profile_Pic = "Update_Profile_Pic";
	

	/*--------------------------VOTER-----------------------------*/
	
	public static final String QUERY_ID_GET_VOTER = "voter_by_id";//"select * from voter where id=?"
	
	public static final String QUERY_ID_UPDATE_VOTER = "update_voter_by_id";//"update voter set district=?,status=? where id= ?"

	public static final String QUERY_ID_INSERT_VOTER = "insert_voter";//"insert into voter values(?,?,?)"
	
	public static final String QUERY_ID_GET_ELECTION = "get_current_election"; //"select * from election where startDate <=SYSDATE() and endDate>=SYSDATE()"
	
	public static final String QUERY_ID_CHECKED_VOTES_TABLE ="checked_votes_table"; //"select * from votes where electionId= ? and userId=?  "
	
	//public static final String QUERY_ID_GET_ELECTION_ID = "election_id_by_name"; //"select * from election where startDate <=SYSDATE() and endDate>=SYSDATE() and electionName = ?"
	
	public static final String QUERY_ID_DELETE_VOTER_BY_ID = "delete_voter"; // "delete from voter  where id= ?"
	
	public static final String QUERY_ID_GET_CANDIDATE_LIST = "candidate_list"; //"select c.userId, u.name ,c.candidateNum from candidate c,user u where (c.userId = u.Id and c.district =?) and (c.party=? and c.state =?) and c.electionId = ? ORDER BY c.candidateNum"
	
	public static final String QUERY_ID_GET_CANDIDATE_LIST_WITH_PARTY = "candidate_list_with_party"; //"select c.userId, u.name,c.party,c.candidateNum from candidate c,user u where c.userId = u.Id  and c.state =? and c.electionId = ? ORDER BY c.candidateNum"
	
	public static final String QUERY_ID_GET_PARTIES="get_parties";//"select DISTINCT party from candidate  where district = ?  and  state = ? and electionId = ?"
	
	public static final String QUERY_ID_INSERT_VOTES ="insert_into_votes"; //"insert into votes values(?,?)"

	public static final String QUERY_ID_CHECKED_RESULTS = "checked_results_table"; //"select * from results where electionId=? and userId =?"
	
	public static final String QUERY_ID_UPDATE_RESULTS ="update_results_table"; //"update results set count = count + 1 where electionId = ? and userId = ?"
	
	public static final String QUERY_ID_INSERT_RESULTS ="insert_into_results";//"insert into results values(?,?,?)"
	
	public static final String QUERY_ID_CHECKED_PARTYVOTES = "checked_partyvotes_table";//"select * from partyvotes where electionId=? and party =?"
	
	public static final String QUERY_ID_UPDATE_PARTYVOTES ="update_partyvotes_table";//"update partyvotes set count = count + 1 where electionId = ? and  party =?"
	
	public static final String QUERY_ID_INSERT_PARTYVOTES ="insert_into_partyvotes";//"insert into partyvotes values(?,?,?)"
	
	public static final String QUERY_ID_GET_CANDIDATE_LIST_WITH_status = "candidate_list_with_status";//"select c.userId, u.name,c.party,c.candidateNum from candidate c,user u where c.userId = u.Id   and c.electionId = ? and c.userId =? "
	
	
	/*--------------------------Candidate-----------------------------*/
	//public static final String URL = "url";

	/** Constant for user name key of MySQL database in config.properties */
	public static final String USERNAME = "username";

	/** Constant for password key of MySQL database in config.properties */
	//public static final String PASSWORD = "password";

	/** Constant for driver name key of MySQL database in config.properties */
	//public static final String DRIVER_NAME = "driverName";

	/** Constant for file path of config.properties */
	//public static final String PROPERTY_FILE = "config.properties";
	
	public static final String USER_ID = "CandidateId";

	/** Constant for query tag in Query.xml */
	public static final String TAG_NAME = "Query";

	/** Constant for query id in Query.xml */
	public static final String ATTRIB_ID = "id";

	/** Constant for Column index one */
	public static final int COLUMN_INDEX_ONE = 1;

	/** Constant for Column index two */
	public static final int COLUMN_INDEX_TWO = 2;

	/** Constant for Column index three */
	public static final int COLUMN_INDEX_THREE = 3;
	
	/** Constant for Column index four */
	public static final int COLUMN_INDEX_FOUR = 4;

	/** Constant for Column index five */
	public static final int COLUMN_INDEX_FIVE = 5;

	/** Constant for Column index six */
	public static final int COLUMN_INDEX_SIX = 6;
	
	/** Constant for campaign id prefix */
	public static final String CAMPAIGN_ID_PREFIX = "CAM";

	/** Constant for query id of insert candidate in Query.xml */
	public static final String QUERY_ID_INSERT_CANDIDATE = "insert_candidate";

	/** Constant for query id of get electionID of an election in Query.xml */
	public static final String QUERY_ID_GET_ELECTION_ID = "get_election_id";
	
	/** Constant for query id of get candidate number in Query.xml */
	public static final String QUERY_ID_GET_CANDIDATE_NUM ="get_candidate_num";
	
	/** Constant for query id of get candidate details in Query.xml */
	public static final String QUERY_ID_GET_CANDIDATE_DETAILS = "get_candidate_details";
	
	/** Constant for query id of get all candidate details in Query.xml */
	public static final String QUERY_ID_GET_ALL_CANDIDATE_DETAILS = "get_all_candidate_details";
	
	/** Constant for query id of insert campaign in Query.xml */
	public static final String QUERY_ID_INSERT_CAMPAIGN = "insert_campaign";

	/** Constant for query id of remove a employee in EmployeeQuery.xml */
	public static final String QUERY_ID_GET_CAMPAIGN_IDS = "get_campaign_ids";

	/** Constant for query id of get campaign details in Query.xml */
	public static final String QUERY_ID_GET_CAMPAIGN_DETAILS = "get_campaign_details";
	
	/** Constant for query id of get all campaign details in Query.xml */
	public static final String QUERY_ID_GET_ALL_CAMPAIGN_DETAILS = "get_all_campaign_details";
	
	/** Constant for query id of update a campaign in Query.xml */
	public static final String QUERY_ID_UPDATE_CAMPAIGN = "update_campaign";

	/** Constant for query id of remove a campaign in Query.xml */
	public static final String QUERY_ID_REMOVE_CAMPAIGN = "remove_campaign";

	/** Constant for query id of remove a candidate in Query.xml */
	public static final String QUERY_ID_REMOVE_CANDIDATE ="remove_candidate";
	}