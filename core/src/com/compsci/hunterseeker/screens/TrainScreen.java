package com.compsci.hunterseeker.screens;

import com.compsci.hunterseeker.ai.BrainController;
import com.compsci.hunterseeker.ai.GameData;
import com.compsci.hunterseeker.util.Globals;

public class TrainScreen extends AbstractScreen {
	public static GameData gameData;
	
	static BrainController bc;
	private boolean finished;
	
	@Override
	public void show() {
		super.show();
		
		bc = new BrainController();
		finished = false;
		bc.learn(gameData);
	}
	
	@Override
	public void render(float delta) {
		super.render(delta);
		if (finished) {
			Globals.game.showScreen("ai");
		}
	}
	
	@Override
	public void back() {
	}
	
	public void finishTraining(){
		finished = true;
	}

}
