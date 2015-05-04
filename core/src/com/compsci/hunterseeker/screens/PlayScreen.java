package com.compsci.hunterseeker.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import com.compsci.hunterseeker.ai.DumbController;
import com.compsci.hunterseeker.ai.GameData;
import com.compsci.hunterseeker.ai.InputManager;
import com.compsci.hunterseeker.items.Hunter;
import com.compsci.hunterseeker.items.Prey;
import com.compsci.hunterseeker.util.Globals;

public class PlayScreen extends AbstractScreen {

	protected Hunter h;
	protected Prey p;
	protected InputManager im;
	protected GameData data;

	protected long startTime;
	private Vector2[] spawns;

	@Override
	public void show() {
		super.show();

		im = new InputManager();
		Gdx.input.setInputProcessor(im);
		h = new Hunter();
//		h.setController(im);

		p = new Prey();
//		p.setController(new DumbController());

		data = new GameData();

		startTime = System.currentTimeMillis();
	}

	public void onCollide() {
		spawnItems();
	}
	
	private Vector2 choosePoint(){
		int index = (int) (Math.random()*4);
		return spawns[index];
	}
	
	public void spawnItems() {
		Vector2 a = choosePoint(), b = choosePoint();
		h.pos.set(a);
		p.pos.set(b);
	}

	@Override
	public void resize(int width, int height) {
		super.resize(width, height);
		float offset = 150;
		spawns = new Vector2[4];
		spawns[0] = new Vector2(width - offset, height - offset);
		spawns[1] = new Vector2(width - offset, offset);
		spawns[2] = new Vector2(offset, height - offset);
		spawns[3] = new Vector2(offset, offset);

		spawnItems();
//		h.pos.set(width - h.img.getWidth(), height - h.img.getHeight());
		h.show(stage);
		p.show(stage);
	}

	@Override
	public void render(float delta) {
		super.render(delta);
		im.update(h);
		h.update(delta);
		p.update(delta);

		h.checkPrey(p);
		
	}

	@Override
	public void hide() {

		System.out.println(data);

		super.hide();
	}

	@Override
	public void back() {
		// TODO Auto-generated method stub

	}

}
