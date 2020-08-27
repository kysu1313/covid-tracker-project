

import classes.*;
import java.io.*;
import java.text.ParseException;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

import org.json.JSONArray;
import org.json.JSONObject;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;


/** This page is the main api interface. Here the api
 *  is called and html is printed to the page.
 */

@WebServlet("/hello")
public class HelloWorld extends HttpServlet {
	
	String[] dates;
	int[] cases;
	
	/**
	 * Intercept the GET request when the page is loaded
	 * and add our data to it.
	 */
  @Override
  public void doGet(HttpServletRequest req,
                    HttpServletResponse res)
      throws ServletException, IOException {
    PrintWriter out = res.getWriter();
    
    out.println("Data Page\n");
    
    
    try {
    	HttpResponse<JsonNode> response = Unirest.get("https://covid-19-coronavirus-statistics.p.rapidapi.com/v1/total?country=Canada")
    			.header("x-rapidapi-host", "covid-19-coronavirus-statistics.p.rapidapi.com")
    			.header("x-rapidapi-key", "310c3610fcmsheb7636d5c15a024p1a11dajsnf459d4f82cfc")
    			.asJson();
    	
    	String resp = response.getBody().toString();
    	
    	CovidStatistics stats = new CovidStatistics(resp);
    	
		out.println("Status Code: " + stats.getStatusCode() + "\n"
				+ "Error: " + stats.getError() + "\n"
				+ "Message: " + stats.getMessage() + "\n"
				+ "Recovered: " + stats.getRecovered() + "\n"
				+ "Deaths: " + stats.getDeaths() + "\n"
				+ "Confirmed: " + stats.getConfirmed());
		
		HttpResponse<JsonNode> response2 = Unirest.get("https://covid-193.p.rapidapi.com/history?day=2020-06-02&country=usa")
				.header("x-rapidapi-host", "covid-193.p.rapidapi.com")
				.header("x-rapidapi-key", "310c3610fcmsheb7636d5c15a024p1a11dajsnf459d4f82cfc")
				.asJson();
		
		String resp2 = response2.getBody().toString();
		
//		out.println(resp2);
		CovidHistory hist = new CovidHistory(resp2);
		
//		out.println("TEST: " + hist.)
		
		LinkedHashMap<?, ?> lhm = hist.getDateAndCases();
		
		dates = new String[lhm.size()];
		cases = new int[lhm.size()];
		
		int i = 0;
		lhm.forEach((key, value) -> {
			dates[i] = (String) key;
			cases[i] = (int) value;
		});
		
		LinkedList<HistoryObject> histList = hist.getLinkedElements();
		
		//Testing
		
//		for (HistoryObject ho : histList) {
//			out.println("Critical: " + ho.getCritical());
//		}
		
		
        
		
	} catch (UnirestException e) {
		System.out.println(e);
		e.printStackTrace();
	} catch (ParseException e) {
		System.out.println(e);
		e.printStackTrace();
	}
    
    res.setContentType("text/html");
    
    out.println
      ("<!DOCTYPE html>\n" +
       "<html>\n" +
       "<head><title>A Test Servlet</title></head>\n" +
       "<body bgcolor=\"#fdf5e6\">\n" +
       "<h1>Test</h1>\n" +
       "<p>Simple servlet for testing.</p>\n" +
       "<div class=\"inline-div\" style=\"float: left\">\n" + 
       "	<a class=\"twitter-timeline\" data-width=\"220\" data-height=\"400\" data-theme=\"dark\" href=\"https://twitter.com/CDCgov?ref_src=twsrc%5Etfw\">Tweets by CDCgov</a> <script async src=\"https://platform.twitter.com/widgets.js\" charset=\"utf-8\"></script>	\n" + 
       "</div>" +
       "<table style=\"width:60%\">\n" + 
       "  <tr>\n" +
       "    <th>Servlets</th>\n" + 
       "    <th href=\"src/testPackage/TestServlet2.java\">TestServlet2</th>\n" + 
       		"<th href=\"src/testPackage/TestServlet2.java\">TestServlet2</th>\n" +
       "  </tr>\n" + 
       "  <tr>\n" + 
       "    <td>HTML</td>\n" + 
       "    <td href=\"src/WebContent/index.html\">index.html</td>\n" + 
       "    <td href=\"src/WebContent/hello.html\">hello.html</td>\n" + 
       "  </tr>\n" + 
       "  <tr>\n" + 
       "    <td>HTML</td>\n" + 
       "    <td href=\"src/WebContent/index.html\">index.html</td>\n" + 
       "    <td href=\"src/WebContent/hello.html\">hello.html</td>\n" + 
       "  </tr>\n" +
       "</table>" +
       "</body></html>");
    
    
  }
  
}
