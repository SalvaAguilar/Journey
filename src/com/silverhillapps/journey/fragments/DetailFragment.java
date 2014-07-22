package com.silverhillapps.journey.fragments;

import com.silverhillapps.journey.R;
import com.silverhillapps.journey.conf.Constants;
import com.silverhillapps.journey.entities.Journey;
import com.silverhillapps.journey.utils.Utils;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * This is the detail Fragment that shows the information of the selected journey
 * @author salva
 *
 */
public class DetailFragment extends Fragment{

    public static final String TAG = "DETAIL_FRAGMENT";

	private Journey mJourney;	// The journey to be detailed
    
    //UI elements
    private TextView mOriginStation;
    private TextView mDestinationStation;
    private TextView mOperator;
    private TextView mJourneyDuration;
    private TextView mJourneyStartTime;
    private TextView mJourneyArrivalTime;
 
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
 
        if (savedInstanceState != null) {
            mJourney = savedInstanceState.getParcelable(Constants.JOURNEY_FRAGMENT_ARGUMENT_KEY);
        }else{
        	mJourney = getArguments().getParcelable(Constants.JOURNEY_FRAGMENT_ARGUMENT_KEY);
        }
        
        View v = inflater.inflate(R.layout.fragment_detail, container, false); 
        mOriginStation = (TextView)v.findViewById(R.id.originStation_textView_detailFragment);
        mDestinationStation = (TextView)v.findViewById(R.id.destinationStation_textView_detailFragment);
        mOperator = (TextView)v.findViewById(R.id.operator_textView_detailFragment);
        mJourneyDuration = (TextView)v.findViewById(R.id.durationTime_textView_detailFragment);
        mJourneyStartTime = (TextView)v.findViewById(R.id.startTime_textView_detailFragment);
        mJourneyArrivalTime = (TextView)v.findViewById(R.id.arrivalTime_textView_detailFragment);
 
        updateContent();
        
        return v;
    }
 

    /**
     * Method for updating the UI
     */
    private void updateContent() {
    	
    	mOriginStation.setText(mJourney.getOriginStation());
    	mDestinationStation.setText(mJourney.getDestinationStation());
    	//The operator could be considered as optional value in the json
    	if("".compareTo(mJourney.getOperator()) == 0){
    		mOperator.setText(getResources().getString(R.string.undefined_message));
    	}else{
    		mOperator.setText(mJourney.getOperator());
    	}
    	
    	mJourneyStartTime.setText(mJourney.getStartTime());
    	mJourneyArrivalTime.setText(mJourney.getArrivalTime());
    	mJourneyDuration.setText(Utils.timeBetweenTwoDates(mJourney.getStartTime(), mJourney.getArrivalTime()));
    }
 
    
    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelable(Constants.JOURNEY_FRAGMENT_ARGUMENT_KEY, mJourney);
    }
	
	
}
