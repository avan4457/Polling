package polling.Models;

public class Candidate {
	private String id;
	private String party;
	private String name;
	private int no;
	
	public Candidate(String party, String name,String id,int no){
		this.party = party;
		this.name = name;
		this.id = id;
		this.no = no;
	}
	public Candidate() {
	}
	public String getParty() {
		return party;
	}
	public void setParty(String party) {
		this.party = party;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	
	
}
