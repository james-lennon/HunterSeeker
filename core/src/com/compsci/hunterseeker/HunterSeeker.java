package com.compsci.hunterseeker;

import java.util.HashMap;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;
import com.compsci.hunterseeker.screens.AIScreen;
import com.compsci.hunterseeker.screens.ChaseDataScreen;
import com.compsci.hunterseeker.screens.FleeDataScreen;
import com.compsci.hunterseeker.screens.PlayScreen;
import com.compsci.hunterseeker.screens.TitleScreen;
import com.compsci.hunterseeker.screens.TrainScreen;
import com.compsci.hunterseeker.util.Globals;

public class HunterSeeker extends Game {
	
	HashMap<String, Screen> screens;
	
	@Override
	public void create () {
		Globals.game = this;
		setupScreens();
		
//		showScreen("ai");
		showScreen("chaseData");
	}
	
	private void setupScreens(){
		screens = new HashMap<String, Screen>();
		screens.put("title", new TitleScreen());
		screens.put("play", new PlayScreen());
		screens.put("train", new TrainScreen());
		screens.put("chaseData", new ChaseDataScreen());
		screens.put("ai", new AIScreen());
		screens.put("flee", new FleeDataScreen());
	}
	
	public void showScreen(String name){
		setScreen(screens.get(name));
	}
}
