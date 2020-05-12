package polling.Utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import polling.Services.IElectionServices;

/**
 * 
 * @author IT19020822
 *
 */

public class CommonUtil {
	
	public static final Logger logr =  Logger.getLogger(IElectionServices.class.getName());
	
	public static final Properties  properties = new Properties();
	
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
}
