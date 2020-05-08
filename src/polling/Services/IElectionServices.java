package polling.Services;

import java.util.ArrayList;

import polling.Models.Election;

public interface IElectionServices {

	public ArrayList<Election> getElectionsByClosingDate();
	
	public ArrayList<String> genResults(int elecId);
}
