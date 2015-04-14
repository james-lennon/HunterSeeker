package com.compsci.hunterseeker.screens;

import com.badlogic.gdx.scenes.scene2d.ui.Label;

public class TitleScreen extends AbstractScreen {
	
	@Override
	public void show() {
		// TODO Auto-generated method stub
		super.show();
	}
	
	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		super.resize(width, height);
		
		Label l = new Label("Hunter Seeker", skin);
		l.setPosition(width/2, height/2);
		l.setFontScale(5.0f);
		stage.addActor(l);
	}

	@Override
	public void back() {
		// TODO Auto-generated method stub

	}

}
