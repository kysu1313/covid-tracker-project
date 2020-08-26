
/**
 * This is for the API:
 * COVID-19 Coronavirus Statistics
 * at url:
 * https://rapidapi.com/KishCom/api/covid-19-coronavirus-statistics?endpoint=apiendpoint_177563f5-bb6d-4f4f-86ae-456f919afbc2
 * By Kyle Supple
 */

package classes;

import java.text.ParseException;
import org.json.JSONObject;
import com.google.gson.annotations.*;

/**
 * To use this class:
 * 1) Convert the HttpResponse<String> to HttpResponse<JsonNode>
 * 2) Get the JSON body as a string: response.getBody().toString()
 * 3) Pass to class constructor
 * @author kms
 *
 */
public class CovidStatistics {
	
	private JSONObject jobj;
	private JSONObject innerObj;
	
	@SerializedName("error")
	private boolean error;
	@SerializedName("statusCode")
	private int statusCode;
	@SerializedName("message")
	private String message;
	
	private int recovered;
	private int deaths;
	private int confirmed;
	private String lastChecked;
	private String lastReported;
	private String location;
	
	public CovidStatistics(String str) throws ParseException {
		
		jobj = new JSONObject(str);
		innerObj = jobj.getJSONObject("data");
		
		setError();
		setStatusCode();
		setMessage();
		setRecovered();
		setDeaths();
		setConfirmed();
		setLastChecked();
		setLastReported();
		setLocation();
		
	}
	
	public boolean getError() {
		return this.error;
	}
	public int getStatusCode() {
		return this.statusCode;
	}
	public String getMessage() {
		return this.message;
	}
	public int getRecovered() {
		return this.recovered;
	}
	public int getDeaths() {
		return this.deaths;
	}
	public int getConfirmed() {
		return this.confirmed;
	}
	public String getLastChecked() {
		return this.lastChecked;
	}
	public String getLastReported() {
		return this.lastReported;
	}
	public String getLocation() {
		return this.location;
	}
	
	private void setError() {
		this.error = jobj.getBoolean("error");
	}
	private void setStatusCode() {
		this.statusCode = jobj.getInt("statusCode");
	}
	private void setMessage() {
		this.message = jobj.getString("message");
	}
	private void setRecovered() {
		this.recovered = innerObj.getInt("recovered");
	}
	private void setDeaths() {
		this.deaths = innerObj.getInt("deaths");
	}
	private void setConfirmed() {
		this.confirmed = innerObj.getInt("confirmed");
	}
	private void setLastChecked() {
		this.lastChecked = innerObj.getString("lastChecked");
	}
	private void setLastReported() {
		this.lastReported = innerObj.getString("lastReported");
	}
	private void setLocation() {
		this.location = innerObj.getString("location");
	}
	
}
