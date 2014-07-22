package com.silverhillapps.journey.adapter;

import java.util.List;

import com.silverhillapps.journey.R;
import com.silverhillapps.journey.entities.Journey;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

/**
 * Adapter class for representing the general list view. I use ArrayAdapter as the list is not enough complex to extend from BaseAdapter
 * @author salva
 *
 */
public class GeneralJourneyListAdapter extends ArrayAdapter<Journey>{

	private Context mContext;
	private List<Journey> mJourneys;
	private LayoutInflater mInflater = null;
	
	public GeneralJourneyListAdapter(Context context, List<Journey> objects) {
		super(context, R.layout.list_row_general, objects);
		
		this.mContext = context;
		this.mJourneys = objects;
		mInflater = LayoutInflater.from(mContext);
	}

	
	  static class ViewHolder {
		    public TextView originTextView;
		    public TextView destinationTextView;
		    public TextView startTimeTextView;
		    public TextView endTimeTextView;
		    public TextView lowestPriceTextView;
		  }
	  
	  
	  @Override
	  public View getView(int position, View convertView, ViewGroup parent) {
	    
		  ViewHolder holder;
		  View rowJourneyView = convertView;

	    // We reuse the views
	    if (rowJourneyView == null) {
	    	
	      rowJourneyView = mInflater.inflate(R.layout.list_row_general, null);
	      
	      holder = new ViewHolder();
	      holder.originTextView = (TextView) rowJourneyView.findViewById(R.id.originTextView);
	      holder.destinationTextView = (TextView) rowJourneyView.findViewById(R.id.destinationTextView);
	      holder.startTimeTextView = (TextView) rowJourneyView.findViewById(R.id.startTimeTextView);
	      holder.endTimeTextView = (TextView) rowJourneyView.findViewById(R.id.arrivalTimeTextView);
	      holder.lowestPriceTextView = (TextView) rowJourneyView.findViewById(R.id.lowestPriceTextView);
	      
	      rowJourneyView.setTag(holder);
	    }
	    else{
	    	holder = (ViewHolder) rowJourneyView.getTag();
	    }
	    
        Journey j = (Journey) getItem(position);
        
        // UI update
        holder.originTextView.setText(j.getOriginStation());
        holder.destinationTextView.setText(j.getDestinationStation());
        holder.startTimeTextView.setText(j.getStartTime());
        holder.endTimeTextView.setText(j.getArrivalTime());
        if(position == 0){
        	holder.lowestPriceTextView.setVisibility(View.VISIBLE);
        }else{
        	holder.lowestPriceTextView.setVisibility(View.INVISIBLE);
        }

	    return rowJourneyView;
	  }
}
