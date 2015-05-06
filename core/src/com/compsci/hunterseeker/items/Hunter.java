package com.compsci.hunterseeker.items;

import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.compsci.hunterseeker.screens.PlayScreen;
import com.compsci.hunterseeker.util.Globals;
import com.compsci.hunterseeker.util.ImageManager;

public class Hunter extends Item {
	
	float w = 30;
	
	public Hunter() {
		img = new Image(ImageManager.getImage("red"));
		img.setSize(w, w);
	}

	@Override
	public void update(float dt) {
		super.update(dt);
	}
	
	public void checkPrey(Item o){
		if (this.overlaps(o)) {
//			System.out.println("overlap");
			((PlayScreen)Globals.game.getScreen()).onCollide();
		}
	}
	
}
