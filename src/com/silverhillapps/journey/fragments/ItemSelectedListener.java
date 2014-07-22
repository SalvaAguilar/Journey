package com.silverhillapps.journey.fragments;

import com.silverhillapps.journey.entities.Journey;

/**
 * This interface models the communication between the main activity and the list fragment
 * @author salva
 *
 */
public interface ItemSelectedListener {
	
	/**
	 * This method is used to notify the parent which element was clicked.
	 * @param journey
	 */
	 public void onItemSelected(Journey journey);
	 
}
