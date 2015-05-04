package com.compsci.hunterseeker.screens;

import com.compsci.hunterseeker.ai.DumbController;
import com.compsci.hunterseeker.util.Globals;

public class ChaseDataScreen extends PlayScreen {

	@Override
	public void show() {
		super.show();
		
		p.setController(new DumbController());
		h.setController(im);
	}
	
	@Override
	public void render(float delta) {
		super.render(delta);
		data.addEntry(h, p);

		if (System.currentTimeMillis() - startTime > 30000) {
			TrainScreen.gameData = data;
			data.save();
			Globals.game.showScreen("train");
		}
	}
	
}
