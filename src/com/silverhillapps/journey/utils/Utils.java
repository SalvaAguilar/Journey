package com.silverhillapps.journey.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Random;
import android.graphics.Color;
import android.util.Log;


/**
 * Class with utils for the application
 * @author salva
 *
 */
public class Utils {

	/**
	 * THis method generates a random color
	 * @return
	 */
	public static int randomColor(){
		Random rnd = new Random();
		int color = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));

		return color;
	}

	/**
	 * This method calculates the difference between two string dates with an specific format.
	 * @param startTime
	 * @param arrivalTime
	 * @return
	 */
	public static String timeBetweenTwoDates(String startTime,
			String arrivalTime) {

		String out = "00:00:00";
		DateFormat df = new SimpleDateFormat("kk:mm:ss", Locale.ENGLISH);

		try {
			Date origin = df.parse(startTime);

			Date end =  df.parse(arrivalTime);

			long correctionFactor = (1000*60*60); //Our minimum valid unit is the hour, and the dates starts at 0, so we need to substract 1 hour to get the correct difference 
			Date diference = new Date(end.getTime()-origin.getTime()-correctionFactor);
			out = df.format(diference);

		} catch (ParseException e) {
			Log.e("JOURNEY_ERROR", "The difference calculation failed");
			e.printStackTrace();
		}
		return out;
	}



}
