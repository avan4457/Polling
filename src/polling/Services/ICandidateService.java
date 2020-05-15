package polling.Services;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import polling.Models.Candidate;
import polling.Models.Election;

public interface ICandidateService {

	/** Initialize logger */
	public static final Logger log = Logger.getLogger(ICandidateService.class.getName());
	
	
	public int obtainElectionId(String Election, String ElectionType);

	public List<Candidate> getCandidate(String candidateId,int electionId,String election,String electionType);

	public boolean removeCandidate(String candidateId, int electionId, String state);

	public void addCandidate(String candidateId,int electionId,String electionType, String election, String party, String district);
	
	public void closeCandidate(String candidateId, int electionId, String state);
	
	public List<Election> getElectionByType();
	
	public Candidate getCandidatebyId(String Id);
}
