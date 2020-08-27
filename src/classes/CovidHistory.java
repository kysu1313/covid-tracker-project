package classes;

/**
 * This class accesses the COVID-19 History api. 
 * 
 * The api can be found here:
 * https://rapidapi.com/api-sports/api/covid-193?endpoint=apiendpoint_dfb9e52d-bd90-48ec-a571-8b78610a736d
 * 
 * Documentation for this api can be found here:
 * https://api-sports.io/documentation/covid-19
 * 
 * The class parses data into easily readable 
 * parameters using the getter methods
 */


import java.util.LinkedHashMap;
import java.util.LinkedList;

import org.json.JSONArray;
import org.json.JSONObject;

public class CovidHistory {
	
	LinkedList<HistoryObject> jar;
	LinkedHashMap<String, Integer> dataMap = new LinkedHashMap<String, Integer>();
	
	/**
	 * Constructor for this class.
	 * Takes the JSON response body and brakes it 
	 * down into many separate objects using the  
	 * HistoryObject class.
	 * @param str, the JSON body
	 */
	public CovidHistory(String str) {
		
		// Create object from the JSON text
		JSONObject obj = new JSONObject(str);
		
		// Extract the array named "response" 
		JSONArray data = obj.getJSONArray("response");
		
		// Initialize the array
		jar = new LinkedList<>();
		
		// Loop through the array creating HistoryObjects for each item
		for (int i = 0; i < data.length(); i++) {
			HistoryObject historyObj = new HistoryObject(data.getJSONObject(i));
			
			// Add the object to an array for later use
			jar.add(historyObj);
		}
	}
	
	// TODO: Create methods to get data from the array
	
	/**
	 * Simple method to return the array of HistoryObjects
	 * @return
	 */
	public LinkedList<HistoryObject> getLinkedElements() {
		return this.jar;
	}
	
	/**
	 * Returns a linked hash map of dates and their 
	 * corresponding number of covid cases.
	 * 
	 * LinkedHashMap is used to allow random selection
	 * of dates from the list
	 * @return LinkedHashMap<String, Integer>
	 * String: Date
	 * Integer: Number of cases
	 */
	public LinkedHashMap<String, Integer> getDateAndCases(){
		
		for (HistoryObject j : jar) {
			dataMap.put(j.getDate(), j.getTotalCases());
		}
		
		return dataMap;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
