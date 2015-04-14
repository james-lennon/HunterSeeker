package com.compsci.hunterseeker.items;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class Item {
	
	public Image img;
	public Vector2 pos;
	
	public Item() {
		pos = new Vector2();
	}
	
	public void update(float dt){
		
	}
	
	public void show(Stage s){
		s.addActor(img);
	}
	
	public void die(){
		img.remove();
	}

}
