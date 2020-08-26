
/**
 * This class inherits from the history constructor.
 * The class is final because the data will not be
 * changed.
 */

package classes;

import org.json.JSONObject;

public final class HistoryObject implements HistoryConstructor {
	
	private int active;
	private int critical;
	private String newCases;
	private int recovered;
	private int totalCases;
	private String mPopCases;
	
	private String mPopDeaths;
	private String newDeaths;
	private int totalDeaths;
	
	private String continent;
	private String country;
	private int population;
	 
	private String time;
	
	public HistoryObject(JSONObject obj) {
		
		// Create JSONObjects for each object in the response
		JSONObject cases = obj.getJSONObject("cases");
		JSONObject deaths = obj.getJSONObject("deaths");
		
		// Data from the cases JSON object
		this.active = cases.getInt("active"); 
		this.critical = cases.getInt("critical");
//		this.newCases = cases.getString("new");			// TODO: fix this, "new" not string
		this.recovered = cases.getInt("recovered");
		this.totalCases = cases.getInt("total");
		
		// Data from the deaths JSON object
		this.mPopDeaths = deaths.getString("1M_pop");
//		this.newDeaths = deaths.getString("new");		// TODO: fix this, "new" not string
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
	public String getNew() {
		// TODO Auto-generated method stub
		return this.newCases;
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
	public String getNewDeaths() {
		// TODO Auto-generated method stub
		return this.newDeaths;
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
	
	
	
}
