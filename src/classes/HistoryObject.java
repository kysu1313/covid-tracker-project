package classes;

/**
 * This class inherits from the history constructor.
 * The class is final because the data will not be
 * changed once it is added.
 */


import org.json.JSONObject;

public final class HistoryObject implements HistoryConstructor {
	
	// Cases
	private int active;
	private int critical;
	private int recovered;
	private String newCases;
	private int totalCases;
	private String mPopCases;
	
	// Deaths
	private String newDeaths;
	private String mPopDeaths;
	private int totalDeaths;
	
	//Location
	private String continent;
	private String country;
	private int population; 
	 
	// Date & time
	private String time;
	
	public HistoryObject(JSONObject obj) {
		
		// Create JSONObjects for each object in the response
		JSONObject cases = obj.getJSONObject("cases");
		JSONObject deaths = obj.getJSONObject("deaths");
		
		// Data from the cases JSON object
		this.active = cases.getInt("active"); 
		this.critical = cases.getInt("critical");
//		this.newCases = cases.getString("new");		//TODO: fix bad type
		this.recovered = cases.getInt("recovered");
		this.totalCases = cases.getInt("total");
		
		// Data from the deaths JSON object
		this.mPopDeaths = deaths.getString("1M_pop");
//		this.newDeaths = deaths.getString("new");	//TODO: fix bad type
		this.totalDeaths = deaths.getInt("total");
		
		// Data from the main JSON body
		this.continent = obj.getString("continent");
		this.country = obj.getString("country");
		this.time = obj.getString("time");
	}
	
	
	//=================  GETTERS ===============

	@Override
	public int getActive() {
		// TODO Auto-generated method stub
		return this.active;
	}

	@Override
	public int getCritical() {
		// TODO Auto-generated method stub
		return this.critical;
	}

	@Override
	public int getRecovered() {
		// TODO Auto-generated method stub
		return this.recovered;
	}

	@Override
	public int getTotalCases() {
		// TODO Auto-generated method stub
		return this.totalCases;
	}

	@Override
	public String getMpopCases() {
		// TODO Auto-generated method stub
		return this.mPopCases;
	}

	@Override
	public int getTotalDeaths() {
		// TODO Auto-generated method stub
		return this.totalDeaths;
	}

	@Override
	public String getContinent() {
		// TODO Auto-generated method stub
		return this.continent;
	}

	@Override
	public String getCountry() {
		// TODO Auto-generated method stub
		return this.country;
	}

	@Override
	public int getPopulation() {
		// TODO Auto-generated method stub
		return this.population;
	}

	@Override
	public String getDate() {
		// TODO Auto-generated method stub
		return this.time;
	}


	@Override
	public String getMpopDeaths() {
		// TODO Auto-generated method stub
		return this.mPopDeaths;
	}
	
	public String getNewCases() {
		return this.newCases;
	}
	
	public String getNewDeaths() {
		return this.newDeaths;
	}
	
	
	
}
