package com.compsci.hunterseeker.items;

import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.compsci.hunterseeker.util.ImageManager;

public class Prey extends Item {
	
	float w = 30;
	
	public Prey(){
		img = new Image(ImageManager.getImage("white"));
		img.setSize(w, w);
	}

	@Override
	public void update(float dt) {
		super.update(dt);
	}

}
