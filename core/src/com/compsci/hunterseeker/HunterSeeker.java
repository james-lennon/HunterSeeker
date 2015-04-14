package com.compsci.hunterseeker;

import java.util.HashMap;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;
import com.compsci.hunterseeker.screens.TitleScreen;

public class HunterSeeker extends Game {
	
	HashMap<String, Screen> screens;
	
	@Override
	public void create () {
		setupScreens();
		
		
		showScreen("title");
	}
	
	private void setupScreens(){
		screens = new HashMap<String, Screen>();
		screens.put("title", new TitleScreen());
		
	}
	
	private void showScreen(String name){
		setScreen(screens.get(name));
	}
}
