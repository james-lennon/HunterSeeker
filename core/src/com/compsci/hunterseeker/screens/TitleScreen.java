package com.compsci.hunterseeker.screens;

import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.compsci.hunterseeker.items.Hunter;

public class TitleScreen extends AbstractScreen {
	
	Hunter h;
	
	@Override
	public void show() {
		// TODO Auto-generated method stub
		super.show();
	}
	
	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		super.resize(width, height);
		
		stage.clear();
		
		
		Label l = new Label("Hunter Seeker", skin);
		l.setPosition(width/2, height/2);
		l.setFontScale(5.0f);
		stage.addActor(l);
		
		h = new Hunter();
		h.show(stage);
	}
	
	@Override
	public void render(float delta) {
		super.render(delta);
		
		h.update(delta);
		
	}

	@Override
	public void back() {
		// TODO Auto-generated method stub

	}

}
