package com.silverhillapps.journey.entities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

/**
 * This class stores all the information that comes from the json file with all the journeys
 * @author salva
 *
 */
public class JourneySet implements Parcelable{

	private List<Journey> journeys;	//This is the list of journeys

	
	public JourneySet(){
		this.journeys = new ArrayList<Journey>();
	}
	
	/**
	 * Constructor used by the CREATOR
	 * @param source
	 */
	@SuppressWarnings("unchecked")
	public JourneySet(Parcel source) {
		this.journeys = (List<Journey>)source.readArrayList(Journey.class.getClassLoader());
	}

	
	//Getters and Setters
	public List<Journey> getJourneys() {
		return journeys;
	}

	public void setJourneys(List<Journey> js) {
		this.journeys = js;
	}
	
	public void addJourney(Journey j){
		this.journeys.add(j);
	}
	
	public int getSize(){
		return this.journeys.size();
	}
	
	public Journey getJourney(int position){
		return this.journeys.get(position);
	}

	/**
	 * Method responsible of sorting the journeys
	 */
	public void sort() {
		if(journeys != null){
			Collections.sort(journeys);

		}
		
	}

	//Parcelable methods
	
	@Override
	public int describeContents() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		
		dest.writeTypedList(journeys);
		
	}
	
	/**
	 * This is the creator of the parcelable
	 */
	public static final Parcelable.Creator<JourneySet> CREATOR = new Creator<JourneySet>() {

	    public JourneySet createFromParcel(Parcel source) {

	        return new JourneySet(source);
	    }

		@Override
		public JourneySet[] newArray(int size) {
			return new JourneySet[size];
		}


	};
	
	
}
