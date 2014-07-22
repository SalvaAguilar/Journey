package com.silverhillapps.journey.loader;

import com.silverhillapps.journey.conf.Constants;


/**
 * This is the factory of loaders that is called from the primary controller.
 * @author salva
 *
 */
public class LoaderFactory {
 
	public JourneySetLoader getLoader(int loaderCode){
		
		JourneySetLoader loader = null;
		
		switch(loaderCode){

		case Constants.JSON_LOADER_CODE:
			loader = new JsonAssetsJourneySetLoader();
			break;
		}
		
		return loader;
	}
	
}
