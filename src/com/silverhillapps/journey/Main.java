package com.silverhillapps.journey;

import com.silverhillapps.journey.conf.Constants;
import com.silverhillapps.journey.entities.Journey;
import com.silverhillapps.journey.entities.JourneySet;
import com.silverhillapps.journey.fragments.GeneralListFragment;
import com.silverhillapps.journey.fragments.ItemSelectedListener;
import com.silverhillapps.journey.loader.JourneySetLoader;
import com.silverhillapps.journey.loader.LoaderFactory;
import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

/**
 * This is the main activity of the application. It adds the list fragment that shows all the journeys. This
 * Journeys are loaded from the loader through the factory.
 * @author salva
 *
 */
public class Main extends ActionBarActivity implements ItemSelectedListener{

	private JourneySetLoader mLoader;	//This is the loader responsible for loading the journey data
	private JourneySet mJourneySet; 	//This is the journey information in our model.
	private LoaderFactory mFactory; 	//This should be loaded through injection
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		// Creates of the factory, and loads the data from the source generating the model. 
		mFactory = new LoaderFactory();
		mLoader = mFactory.getLoader(Constants.JSON_LOADER_CODE);
		mJourneySet = mLoader.loadJourneys();
		
		if (savedInstanceState == null) {
			
			//We create the list fragment and pass the model
			GeneralListFragment fragment = new GeneralListFragment();
			
			Bundle args = new Bundle();
		    args.putParcelable(Constants.JOURNEYSET_FRAGMENT_ARGUMENT_KEY, mJourneySet);
		    fragment.setArguments(args); 

			getFragmentManager().beginTransaction()
					.add(R.id.container, fragment, GeneralListFragment.TAG).commit();
		}
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {

		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onItemSelected(Journey journey) {
		
		/*Here we have two options depending on the final device. We can use the fragment manager to show 
		the two fragments in the same activity like master-detail or like this case, fire a new activity 
		that contains the detail fragment for smartphones. */
		
		
		Intent detailActivityIntent = new Intent(Main.this, DetailActivity.class);
		detailActivityIntent.putExtra(Constants.JOURNEY_ACTIVITY_ARGUMENT_KEY, journey);
		startActivity(detailActivityIntent);
		
	}


}
