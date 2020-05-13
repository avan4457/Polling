package polling.Services;

import java.util.ArrayList;
import java.util.logging.Logger;

import polling.Models.Election;
import polling.Models.Voter;



/**
 * 
 * @author IT19020822 Dilshan K.G.T
 *
 */

public interface IElectionServices {
	
	/** Initialize Logger **/
	
	public static final Logger logr = Logger.getLogger(IElectionServices.class.getName());

	/**
	 * 
	 * generate result
	 */
	public ArrayList<Election> getElectionsByClosingDate();
	public ArrayList<String> genResults(int elecId);
	
	/**
	 * Get an particular election
	 * @param electionID
	 * @return
	 */
	public Election getElectionByID(int electionID);
	
	/**
	 * generate list of Elections
	 * @return
	 */
	public ArrayList<Election> getElection();
	
	/**
	 * Update existing election
	 * @param election
	 * @param electionID
	 */
	public void upDateElection(Election election, int electionID);
	
	/**
	 * delete election
	 * @param electionID
	 */
	public void deleteElection(int electionID);
	
	/**
	 * add election
	 * @param election
	 */
	public void addElection(Election election);
	
	public boolean validateVoter(String id);
	
	public boolean validateCandidate(String id);
	
	public ArrayList<Voter> getVoterList();
}
