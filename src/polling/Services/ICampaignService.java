package polling.Services;

import java.util.List;

import polling.Models.Campaign;

public interface ICampaignService {

	public List<Campaign> getCampaign(String campaignId,String candidateId,int electionId);

	public boolean updateCampaign(String campaignId,String candidateId, int electionId,Campaign campaign);

	public void removeCampaign(String campaignId,String candidateId, int electionId);

	public List<Campaign> addCampaign(String candidateId, int electionId, String heading, String statement,
			String description);
	
	public String[] getListElements(List<Campaign> campaign);

	List<Campaign> getCampaignByCandidate(String CandidateId);

}
