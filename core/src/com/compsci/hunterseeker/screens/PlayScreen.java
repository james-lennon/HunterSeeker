package com.compsci.hunterseeker.screens;

import com.badlogic.gdx.Gdx;
import com.compsci.hunterseeker.ai.DumbController;
import com.compsci.hunterseeker.ai.GameData;
import com.compsci.hunterseeker.ai.InputManager;
import com.compsci.hunterseeker.items.Hunter;
import com.compsci.hunterseeker.items.Prey;

public class PlayScreen extends AbstractScreen {
	
	private Hunter h;
	private Prey p;
	private InputManager im;
	private GameData data;
	
	@Override
	public void show() {
		super.show();
		
		im = new InputManager();
		Gdx.input.setInputProcessor(im);
		h = new Hunter();
		h.setController(im);
		
		p = new Prey();
		p.setController(new DumbController());
		
		data = new GameData();
	}
	
	@Override
	public void resize(int width, int height) {
		super.resize(width, height);
		h.pos.set(width, height);
		h.show(stage);
		p.show(stage);
	}
	
	
	@Override
	public void render(float delta) {
		super.render(delta);
		im.update(h);
		h.update(delta);
		p.update(delta);
		
		data.addEntry(h, p);
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
