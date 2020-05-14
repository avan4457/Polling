package polling.Services;

import java.util.ArrayList;

import polling.Models.Candidate;
import polling.Models.Election;
import polling.Models.Voter;

//IT19390260 
public interface IvoterServices {

	public ArrayList<Election>currentElections();
	public boolean districtStatus(String Vid);
	public ArrayList<Voter> getVoterDetails(String Vid);
	public Voter getVoterByID(String Vid);
	public boolean voterValidate(String Vid,String Eid);
	public int getElectionId(String Election);
	public boolean deleteVoterById(String Vid);
	public boolean RegisterVoter(String Vid, String district, String status);
	public  ArrayList<Candidate> GetParliamentCandidatelist(String party,String Vid,String Eid);
	public ArrayList<Candidate> GetPresidentCandidatelist(String Election,String Eid);
	public ArrayList<String> GetPartyies(String Election,String Vid,String Eid);
	public boolean addVoterVotes(String Election,String party,String Vid,String Eid,String Cid);
	public  ArrayList<Candidate> GetCandidateById(String Cid,String Eid);
}
