package com.compsci.hunterseeker.screens;

import com.badlogic.gdx.math.Vector2;
import com.compsci.hunterseeker.util.Globals;

public class AIScreen extends PlayScreen {

	@Override
	public void show() {
		super.show();
		h.setController(TrainScreen.bc);
		p.setController(im);
	}

	@Override
	public void render(float delta) {
		Vector2 dist = new Vector2(h.pos).sub(p.pos);
		TrainScreen.bc.setInputs(dist.x / Globals.APP_WIDTH, dist.y
				/ Globals.APP_HEIGHT);
		
		super.render(delta);
	}

}
