package polling.Models;

import java.time.*;

/**
 * This Election class to get and set data
 * @author IT19020822 DilshanK.G.T
 *
 */

public class Election {
	
	private int ElectionID;
	
	private String ElectionName;
	
	private String ElectionType;
	
	private LocalDate StartDate;
	
	private LocalDate EndDate;
	

	/**
	 * 
	 * @return election Id
	 */

	public int getElectionID() {
		return ElectionID;
	}
	
	/**
	 * 
	 * @param electionID
	 */
	public void setElectionID(int electionID) {
		ElectionID = electionID;
	}
	
	/**
	 * 
	 * @return election Name
	 */

	public String getElectionName() {
		return ElectionName;
	}
	
	/**
	 * 
	 * @param electionName
	 */

	public void setElectionName(String electionName) {
		ElectionName = electionName;
	}
	
	/**
	 * 
	 * @return election Type
	 */

	public String getElectionType() {
		return ElectionType;
	}
	
	/**
	 * 
	 * @param electionType
	 */
	
	public void setElectionType(String electionType) {
		ElectionType = electionType;
	}
	
	/**
	 * 
	 * @return election start date 
	 */

	public LocalDate getStartDate() {
		return StartDate;
	}
	
	/**
	 * 
	 * @param startDate
	 */
	
	public void setStartDate(LocalDate startDate) {
		StartDate = startDate;
	}

	/**
	 * 
	 * @return election end date
	 */
	
	public LocalDate getEndDate() {
		return EndDate;
	}
	
	/**
	 * 
	 * @param endDate
	 */
	public void setEndDate(LocalDate endDate) {
		EndDate = endDate;
	}
	
	

}
