package classes;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import com.google.gson.*;
import com.google.gson.annotations.*;

public class ResponseDailyTotals {
	
	@SerializedName("active")
	private long active;
	@SerializedName("confirmed")
	private long confirmed;
	@SerializedName("critical")
	private long critical;
	@SerializedName("date")
	private Date date;
	@SerializedName("deaths")
	private long deaths;
	@SerializedName("recovered")
	private long recovered;
	
	public ResponseDailyTotals(JSONObject obj) throws ParseException {
		
	}
	
	public long getActive() {
		return this.active;
	}
	public long getConfirmed() {
		return this.confirmed;
	}
	public long getCritical() {
		return this.critical;
	}
	public Date getdate() {
		return this.date;
	}
	public long getDeaths() {
		return this.deaths;
	}
	public long getRecovered() {
		return this.recovered;
	}
	
}
