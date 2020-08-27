package apiConnections;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

/**
 * This class connects to the api. 
 * It stores all the information in
 * easy to access variables
 * @author Kyle
 *
 */
public class HistoryApiConn implements ApiInterface{
	
	private HttpResponse<JsonNode> response;
	private String body;
	
	/**
	 * Connect to the api and get the 
	 * response body.
	 * @param resp: api response
	 */
	public HistoryApiConn() {
		
		try {
			response = Unirest.get("https://covid-193.p.rapidapi.com/history?day=2020-06-02&country=usa")
					.header("x-rapidapi-host", "covid-193.p.rapidapi.com")
					.header("x-rapidapi-key", "310c3610fcmsheb7636d5c15a024p1a11dajsnf459d4f82cfc")
					.asJson();
		} catch (UnirestException e) {
			System.out.println(e);
			e.printStackTrace();
		}
		
		this.body = getBody();
	}

	/**
	 * Convert the api response into
	 * a string
	 */
	@Override
	public String getBody() {
		body = response.getBody().toString();
		return body;
	}
	
}
