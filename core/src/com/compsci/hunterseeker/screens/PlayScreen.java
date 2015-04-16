package com.compsci.hunterseeker.screens;

import com.badlogic.gdx.Gdx;
import com.compsci.hunterseeker.items.Hunter;
import com.compsci.hunterseeker.util.InputManager;

public class PlayScreen extends AbstractScreen {
	
	private Hunter h;
	private InputManager im;
	
	@Override
	public void show() {
		super.show();
		
		im = new InputManager();
		Gdx.input.setInputProcessor(im);
		h = new Hunter();
	}
	
	@Override
	public void resize(int width, int height) {
		super.resize(width, height);
		h.show(stage);
	}
	
	@Override
	public void render(float delta) {
		super.render(delta);
		im.update(h);
		h.update(delta);
	}

	@Override
	public void back() {
		// TODO Auto-generated method stub
		
	}

}
