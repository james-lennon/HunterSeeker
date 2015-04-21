package com.compsci.hunterseeker.ai;

import com.badlogic.gdx.math.Vector2;
import com.compsci.hunterseeker.items.Item;

public class DumbController implements ItemController{

	private long lastChange;

	@Override
	public void update(Item i){
		if (System.currentTimeMillis() - lastChange > 1000) {
			changeDir(i);
			lastChange = System.currentTimeMillis();
		}
	}
	
	private void changeDir(Item i){
		i.dir = new Vector2((float)(Math.random()*3)-1, (float)(Math.random()*3)-1);
	}

}
