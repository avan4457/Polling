package polling.Models;

public class Candidate {
	private String candidateId;
	private int electionId;
  private String name;
	private String election;
	private String electionType;
	private String party;
	private int number;
	private String district;
	private String state;
	
	public Candidate(String candidateId,int electionId,String election,String electionType,String party,int number,String district,String state) {
		this.candidateId = candidateId;
		this.electionId = electionId;
		this.election = election;
		this.electionType = electionType;
		this.party = party;
		this.number = number;
		this.district = district;
		this.state = state;
	}
	
	public String getCandidateId () {
		return candidateId ;
	}
	
	/*public void setCandidateId (String candidateId) {
		this.CandidateId = candidateId;
	}*/
	
	public String getElection () {
		return election;
	}
	
	/*public void setElection (String election) {
		this.Election = election;
	}*/
	
	public int getElectionId () {
		return electionId;
	}
	
//	public void setElectionId (int electionId) {
//		this.ElectionId = electionId;
//	}
	
	public String getElectionType () {
		return electionType;

	}
	
//	public void setElectionType (String electionType) {
//		this.ElectionType = electionType;
//	}
	
	public String getParty () {
		return party;
	}
	
	/*public void setParty (String party) {
		this.Party = party;
	}*/
	
	public int getNumber () {
		return number;
	}
	
	/*public void setNumber (int number) {
		this.Number = number;
	}*/
	
	public String getDistrict () {
		return district;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public int getElectionId() {
		return electionId;
	}
	public void setElectionId(int electionId) {
		this.electionId = electionId;
	}
	
//	public void setDistrict (String district) {
//		this.District = district;
//	}
	
	public String getState () {
		return state;
	}
	
	/*public void setState (String state) {
		this.State = state;
	}*/
}
