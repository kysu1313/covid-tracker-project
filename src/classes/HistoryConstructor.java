package classes;

public interface HistoryConstructor {
	
	//=================  GETTERS ===============
	
	/* Access data for COVID-19 cases */
	public String getMpopCases();
	public int getActive();
	public int getCritical();
	public int getRecovered();
	public int getTotalCases();
	
	/* Access data for COVID-19 deaths */
	public String getMpopDeaths();
	public int getTotalDeaths();
	
	/* Access data for COVID-19 locations */
	public String getContinent();
	public String getCountry();
	public int getPopulation();
	
	/* Access time information */
	public String getDate();
	
}
