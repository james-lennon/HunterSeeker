package com.compsci.hunterseeker.screens;

import com.badlogic.gdx.math.Vector2;
import com.compsci.hunterseeker.util.Globals;

public class AIScreen extends PlayScreen {

	private long showTime;
	
	@Override
	public void show() {
		super.show();
		showTime = System.currentTimeMillis();
		
		Globals.preyBc = TrainScreen.bc;
		// TrainScreen.bc = new BrainController();
		// TrainScreen.bc.load("aggregate_player.nnet");
		h.setController(Globals.hunterBc);
		p.setController(Globals.preyBc);
	}

	@Override
	public void render(float delta) {
		super.render(delta);
		Vector2 o1 = Globals.getOffset(h, p, false), o2 = Globals.getOffset(p,
				h, false);
		// TrainScreen.bc.setInputs(dist.x / Globals.APP_WIDTH, dist.y
		// / Globals.APP_HEIGHT);
		Globals.hunterBc.setInputs(
				(float) (o1.len() / Math.sqrt(Globals.APP_WIDTH
						* Globals.APP_WIDTH + Globals.APP_HEIGHT
						* Globals.APP_HEIGHT)), o1.angle() / 360);
		Globals.preyBc.setInputs(
				(float) (o2.len() / Math.sqrt(Globals.APP_WIDTH
						* Globals.APP_WIDTH + Globals.APP_HEIGHT
						* Globals.APP_HEIGHT)), o2.angle() / 360);

		if (System.currentTimeMillis() - showTime > Globals.watchTime * 1000) {
			Globals.game.showScreen("chaseData");
			return;
		}
	}

}
