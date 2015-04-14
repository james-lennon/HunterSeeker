package com.compsci.hunterseeker.items;

import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.compsci.hunterseeker.util.ImageManager;

public class Hunter extends Item {
	
	public Hunter() {
		img = new Image(ImageManager.getImage("block"));
	}

	@Override
	public void update(float dt) {
		super.update(dt);
		
		pos.add(4*dt, 0);
		img.setPosition(pos.x, pos.y);
	}
	
}
