package com.compsci.hunterseeker.screens;

import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.compsci.hunterseeker.ai.BrainController;
import com.compsci.hunterseeker.ai.GameData;
import com.compsci.hunterseeker.util.Globals;

public class TrainScreen extends AbstractScreen {
	public static GameData gameData;
	
	static BrainController bc;
	static String nextScreen;
	private boolean finished;
	
	@Override
	public void show() {
		super.show();
		
		finished = false;
		bc.learn(gameData);
	}
	
	@Override
	public void resize(int width, int height) {
		super.resize(width, height);
		
		Label text = new Label("Learning...", skin);
		text.setPosition(width/2 - text.getWidth()/2*3, height/2 - text.getHeight()/2*3);
		text.setFontScale(3.0f);
		stage.addActor(text);
	}
	
	@Override
	public void render(float delta) {
		super.render(delta);
		if (finished) {
			Globals.game.showScreen(nextScreen);
		}
	}
	
	@Override
	public void back() {
	}
	
	public void finishTraining(){
		finished = true;
	}

}
