package com.silverhillapps.journey;

import com.silverhillapps.journey.conf.Constants;
import com.silverhillapps.journey.entities.Journey;
import com.silverhillapps.journey.fragments.DetailFragment;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

/**
 * This Activity has the function to show the detail fragment for devices with small screens.
 * @author salva
 *
 */
public class DetailActivity extends ActionBarActivity {

	//This is the journey which is going to be shown in the detail view.
	private Journey mJourney;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_detail);

		if (savedInstanceState == null) {

			mJourney = getIntent().getExtras().getParcelable(Constants.JOURNEY_ACTIVITY_ARGUMENT_KEY);

			DetailFragment fragment = new DetailFragment();

			// We pass the journey to our fragment
			Bundle args = new Bundle();
			args.putParcelable(Constants.JOURNEY_FRAGMENT_ARGUMENT_KEY, mJourney);
			fragment.setArguments(args); 

			getFragmentManager().beginTransaction()
			.add(R.id.container, fragment, DetailFragment.TAG).commit();
		}

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
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


}
