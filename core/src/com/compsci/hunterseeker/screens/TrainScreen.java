package com.compsci.hunterseeker.screens;

import com.compsci.hunterseeker.ai.BrainController;
import com.compsci.hunterseeker.ai.GameData;

public class TrainScreen extends AbstractScreen {
	public static GameData gameData;
	
	private BrainController bc;
	
	@Override
	public void show() {
		super.show();
		
		bc = new BrainController();
		bc.learn(gameData);
	}
	
	@Override
	public void render(float delta) {
		super.render(delta);
	}
	
	@Override
	public void back() {
	}

}
