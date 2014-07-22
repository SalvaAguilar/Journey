package com.silverhillapps.journey.fragments;

import com.silverhillapps.journey.adapter.GeneralJourneyListAdapter;
import com.silverhillapps.journey.conf.Constants;
import com.silverhillapps.journey.entities.JourneySet;

import android.app.Activity;
import android.app.ListFragment;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;


/**
 * This Fragment shows the list of the available journeys
 * @author salva
 *
 */
public class GeneralListFragment extends ListFragment {
	
	public static final String TAG = "GENERAL_LIST_FRAGMENT";
	
	private ItemSelectedListener mCallback;	// callback object for communicating with the parent activity
	private JourneySet mJourneySet;			// The journeys set model
	private GeneralJourneyListAdapter mAdapter;		// The list adapter
 
	public GeneralListFragment(){
		
	}
	
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // We retrieve the list of objects, create the adapter and associate it with the fragment.
        mJourneySet = getArguments().getParcelable(Constants.JOURNEYSET_FRAGMENT_ARGUMENT_KEY);
        
        mAdapter = new GeneralJourneyListAdapter(getActivity(), mJourneySet.getJourneys());
        setListAdapter(mAdapter);  
    }
 
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mCallback = (ItemSelectedListener) activity; // We set the callback as soon as the fragment is attached
        } catch (ClassCastException e) {
            Log.d("ClassCastException",
                    "The parent activity must implement the interface to get communication with the fragment");
        }
    }
 
    
    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        // Doing click on one item, we call the parent to perform the associated action.
        mCallback.onItemSelected(mJourneySet.getJourney(position));
    }
}
