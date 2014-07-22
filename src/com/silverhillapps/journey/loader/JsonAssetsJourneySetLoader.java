package com.silverhillapps.journey.loader;

import java.io.IOException;
import java.io.InputStream;
import java.util.Random;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.silverhillapps.journey.SHJApplication;
import com.silverhillapps.journey.conf.Conf;
import com.silverhillapps.journey.entities.Journey;
import com.silverhillapps.journey.entities.JourneySet;

import android.graphics.Color;



/**
 * This is the json loader from assets. This reads the json file and generates the JourneySet object which stores the information of the initial journeys.
 * @author salva
 *
 */
public class JsonAssetsJourneySetLoader extends JourneySetLoader {


	/**
	 * This method load the initial elements information
	 * @return returns the initial journeys
	 */
	@Override
	public JourneySet loadJourneys() {

		JourneySet js =  parse();
		js.sort();

		return js;
	}


	/**
	 * Internal method for reading the json file located in assets.
	 * @return the json contents
	 */
	private String loadJSONFromAsset() {
		String json = null;
		try {

			InputStream is = SHJApplication.getAppContext().getAssets().open(Conf.JSON_FILE_NAME);

			int size = is.available();

			byte[] buffer = new byte[size];

			is.read(buffer);

			is.close();

			json = new String(buffer, "UTF-8");


		} catch (IOException ex) {
			ex.printStackTrace();
			return null;
		}
		return json;

	}

	/**
	 * This method parses the json contents and creates the structure of the initial journeys
	 * @return The initial elements
	 */
	private JourneySet parse() {
		//FIXME
		//This parsing usually can be made directly using libraries like Gson.
		JourneySet js = new JourneySet();
		Journey j = null;

		JSONArray obj;
		try {
			String json = loadJSONFromAsset();

			obj = new JSONArray(json);

			for (int i = 0; i < obj.length(); i++) 
			{
				j = new Journey();
				JSONObject journey = obj.getJSONObject(i);

				j = parseJourney(journey);

				js.addJourney(j);

			}
		} catch (JSONException e1) {
			e1.printStackTrace();
		}

		return js;
	}

	/**
	 * This method parse a single element and create the model object
	 * @param journey
	 * @return The journey model object
	 * @throws JSONException
	 */

	private Journey parseJourney(JSONObject journey) throws JSONException {
		Journey j = new Journey();
		int order = Integer.MAX_VALUE;
		String originStation = "";
		String destinationStation = "";
		String operator = "";
		String startTime = "";
		String arrivalTime = "";

		if(journey!=null){
			if(journey.has("order")){
				order = journey.getInt("order");
			}
			if(journey.has("originStation")){
				originStation = journey.getString("originStation");
			}
			if(journey.has("destinationStation")){
				destinationStation = journey.getString("destinationStation");
			}
			if(journey.has("operator")){ // Operator could be an optional key
				operator = journey.getString("operator");
			}
			if(journey.has("startTime")){
				startTime = journey.getString("startTime");
			}
			if(journey.has("arrivalTime")){
				arrivalTime = journey.getString("arrivalTime");
			}

			j.setOrder(order);
			j.setOriginStation(originStation);
			j.setDestinationStation(destinationStation);
			j.setOperator(operator);
			j.setStartTime(startTime);
			j.setArrivalTime(arrivalTime);
		}

		return j;
	}


}
