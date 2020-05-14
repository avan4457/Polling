package polling.Models;
/*IT19390260*/
public class Voter {
	private String id;
	private String status;
	private String district;
	public Voter(String id, String status, String district) {
		this.id = id;
		this.status = status;
		this.district = district;
	}
	
	public Voter(){
		
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}

	

}
