package polling.Models;

public class Campaign {
	private String campaignId;
	private String candidateId;
	private int electionId;
	private String statement;
	private String heading;
	private String description;
	
	public Campaign(String campaignId,String candidateId,int electionId,String heading,String statement,String description) {
		this.campaignId = campaignId;
		this.candidateId = candidateId;
		this.electionId = electionId;
		this.heading = heading;
		this.statement = statement;
		this.description = description;
	}
	
	public String getCampaignId () {
		return campaignId;
	}

	public String getCandidateId () {
		return candidateId;
	}
	
	public int getElectionId () {
		return electionId;
	}
	
	public String getStatement () {
		return statement;
	}
	
	public String getHeading () {
		return heading;
	}
	
	public String getDescription () {
		return description;
	}
	
}
