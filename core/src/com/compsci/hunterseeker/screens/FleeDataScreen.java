package com.compsci.hunterseeker.screens;

import com.badlogic.gdx.math.Vector2;
import com.compsci.hunterseeker.ai.GameData;
import com.compsci.hunterseeker.util.Globals;

public class FleeDataScreen extends PlayScreen {
	
	@Override
	public void show() {
		super.show();
		
		Globals.hunterBc = TrainScreen.bc;
		
		data = new GameData("flee", false);
		p.setController(im);
		h.setController(TrainScreen.bc);
	}
	
	@Override
	public void render(float delta) {
		super.render(delta);
		data.addEntry(p, h);
		Vector2 o = Globals.getOffset(h, p, false);
		
		Globals.hunterBc.setInputs(
				(float) (o.len() / Math.sqrt(Globals.APP_WIDTH
						* Globals.APP_WIDTH + Globals.APP_HEIGHT
						* Globals.APP_HEIGHT)), o.angle() / 360);

		if (System.currentTimeMillis() - startTime > Globals.chaseTime * 1000) {
			goToNext();
		}
	}
	
	public void goToNext(){
		TrainScreen.gameData = data;
		TrainScreen.nextScreen = "chaseData";
		TrainScreen.bc = Globals.preyBc;
		data.save();
		Globals.game.showScreen("train");
	}

}
