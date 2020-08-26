
package classes;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import com.google.gson.*;
import com.google.gson.annotations.*;
import com.mashape.unirest.http.HttpResponse;

/**
 * Response for the getLatestTotals COVID-19 api
 * Unirest.get("https://covid-19-data.p.rapidapi.com/report/totals?date-format=YYYY-MM-DD&format=json&date=2020-07-21
 * @author kms
 *
 */
public class ResponseLatestTotals {
	
	@SerializedName("confirmed")
	private int confirmed;
	@SerializedName("critical")
	private int critical;
	@SerializedName("deaths")
	private int deaths;
	@SerializedName("lastChange")
	private Date lastChange;
	@SerializedName("lastUpdate")
	private int lastUpdate;
	@SerializedName("recovered")
	private int recovered;
	
	public ResponseLatestTotals(HttpResponse<String> resp) throws ParseException {
		
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
        JsonParser jp = new JsonParser();
        JsonElement je = jp.parse(resp.getBody().toString());
        JsonObject job = je.getAsJsonObject();
        
        JsonElement jsonEle = new JsonParser().parse(resp.getBody().toString());
        JsonObject jsonObject = jsonEle.getAsJsonObject();
        
        String prettyJsonString = gson.toJson(je);
        System.out.println(prettyJsonString);
		
        
//		JSONArray data = obj.getJSONArray("0");
//		
//		JSONObject properties = data.getJSONObject(0);
		
		this.confirmed = jsonObject.get("confirmed").getAsInt();
		this.critical = jsonObject.get("critical").getAsInt();
		this.deaths = jsonObject.get("deaths").getAsInt();
		String tmpDate = jsonObject.get("lastChange").getAsString();
		Date date1=new SimpleDateFormat("dd/MM/yyyy").parse(tmpDate);  
		this.lastChange = date1;
		this.lastUpdate = jsonObject.get("lastUpdate").getAsInt();
		this.recovered = jsonObject.get("recovered").getAsInt();
	}
	
	public long getConfirmed() {
		return this.confirmed;
	}
	public long getCritical() {
		return this.critical;
	}
	public long getDeaths() {
		return this.deaths;
	}
	public Date getdate() {
		return this.lastChange;
	}
	public long getLastUpdate() {
		return this.lastUpdate;
	}
	public long getRecovered() {
		return this.recovered;
	}
	
}