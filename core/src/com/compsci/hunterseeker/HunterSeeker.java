package com.compsci.hunterseeker;

import java.util.HashMap;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class HunterSeeker extends Game {
	
	HashMap<String, Screen> screens;
	
	@Override
	public void create () {
	}
	
	private void setupScreens(){
		screens = new HashMap<String, Screen>();
		
		
	}
	
	private void showScreen(String name){
		setScreen(screens.get(name));
	}
}
