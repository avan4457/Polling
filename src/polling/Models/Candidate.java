package polling.Models;

public class Candidate {
	private String id;
	private String party;
	private int electionId;
	private int no;
	private String district;
	private String state;

	
	public Candidate(String party,String id,int no,String district,String state, int electionId){
		this.party = party;
		this.id = id;
		this.no = no;
		this.district = district;
		this.state = state;
		this.electionId = electionId;
	}
	public Candidate() {
	}
	public String getParty() {
		return party;
	}
	public void setParty(String party) {
		this.party = party;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
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
	
	
}
