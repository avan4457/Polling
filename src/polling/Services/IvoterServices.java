package polling.Services;

import java.util.ArrayList;

import polling.Models.Election;
import polling.Models.Voter;


public interface IvoterServices {

	public void RegisterVoter(Voter v);
	public ArrayList<Election>currentElections();
	public boolean districtStatus(String id);
	public boolean upda();
	public ArrayList<Voter> getVoterDetails(String id);
	public Voter getVoterByID(String voterID);
	public boolean voterValidate(String id,String Eid);
	//public void voted(String id);
	public int getElectionId(String Election);
	public boolean deleteVoterById(String id);
}
