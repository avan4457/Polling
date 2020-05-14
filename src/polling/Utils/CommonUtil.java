package polling.Utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

import polling.Models.User;
import polling.Services.ICandidateService;
import polling.Services.IElectionServices;

public class CommonUtil {

	public static final Logger logr =  Logger.getLogger(IElectionServices.class.getName());
	
	public static final Properties properties = new Properties();

	public static String generateId(User user){
		Random rand = new Random();
		String id = "u";
		int n = rand.nextInt(100);
		return id + Integer.toString(n);	
	}
	
	static{
		try{
			properties.load(QueryUtil.class.getResourceAsStream(CommonConstants.PROPERTY_FILE));
		} catch(IOException e){
		
			logr.log(Level.SEVERE,e.getMessage());
			
		}
	}
	
	
	public static int genarateElectionId(ArrayList<Integer> arrayList){
		int id;
		int next = arrayList.size();
		next++;
		id = CommonConstants.ELECTION_ID_PREFIX + next;
		
		if(arrayList.contains(id)){
			next++;
			id = CommonConstants.ELECTION_ID_PREFIX + next;
		}
		return id;
	}
	
	public static String generateIDs(ArrayList<String> arrayList) {

		String id;
		int next = arrayList.size();
		next++;
		id = CommonConstants.CAMPAIGN_ID_PREFIX + next;
		if (arrayList.contains(id)) {
			next++;
			id = CommonConstants.CAMPAIGN_ID_PREFIX + next;
		}
		return id;
	}


	public static int generateNum(ArrayList<Integer> arrayList){
		int Num;
		int next = arrayList.size();
		next++;
		Num = next;
		if (arrayList.contains(Num)) {
			next++;
			Num = next;
		}
		return Num;
	}
}
