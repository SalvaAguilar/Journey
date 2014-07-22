package com.silverhillapps.journey.entities;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.method.DateTimeKeyListener;

/**
 * Entity class that represent a single journey
 * @author salva
 *
 */
public class Journey implements Comparable<Journey>, Parcelable{

	private int order;
	// These three Strings below should be coded in anyway coding format to avoid problems with different languages or stations with the same name that could create unnecessary cycles in a possible graph. Besides it is more efficient in memory terms as the code could be an integer
	private String originStation;
	private String destinationStation;
	private String operator;
	// Could be better to manage this timestamps as long objects or Date to perform direct manipulations with them
	private String startTime;
	private String arrivalTime;	
	
	public Journey(){
		
	}
	
	/**
	 * Constructor used by the CREATOR
	 * @param source
	 */
	public Journey(Parcel source) {
		this.order = source.readInt();
		this.originStation = source.readString();
		this.destinationStation = source.readString();
		this.operator = source.readString();
		this.startTime = source.readString();
		this.arrivalTime = source.readString();
	}


	// Getters and Setters

	public int getOrder() {
		return order;
	}




	public void setOrder(int order) {
		this.order = order;
	}




	public String getOriginStation() {
		return originStation;
	}




	public void setOriginStation(String originStation) {
		this.originStation = originStation;
	}




	public String getDestinationStation() {
		return destinationStation;
	}




	public void setDestinationStation(String destinationStation) {
		this.destinationStation = destinationStation;
	}




	public String getOperator() {
		return operator;
	}




	public void setOperator(String operator) {
		this.operator = operator;
	}

	

	public String getStartTime() {
		return startTime;
	}




	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}




	public String getArrivalTime() {
		return arrivalTime;
	}




	public void setArrivalTime(String arrivalTime) {
		this.arrivalTime = arrivalTime;
	}


	//Comparable methods

	@Override
	public int compareTo(Journey another) {
	
		return this.order-another.order;
	}


	//Parcelable methods

	@Override
	public int describeContents() {
		// TODO Auto-generated method stub
		return 0;
	}



	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeInt(order);
		dest.writeString(originStation);
		dest.writeString(destinationStation);
		dest.writeString(operator);
		dest.writeString(startTime);
		dest.writeString(arrivalTime);
		
	}
	
	/**
	 * This is the creator of the parcelable
	 */
	public static final Parcelable.Creator<Journey> CREATOR = new Creator<Journey>() {

	    public Journey createFromParcel(Parcel source) {

	        return new Journey(source);
	    }

		@Override
		public Journey[] newArray(int size) {
			return new Journey[size];
		}


	};
	
	
}
