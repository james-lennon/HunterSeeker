package com.compsci.hunterseeker.items;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class Item {
	
	public Image img;
	public Vector2 pos;
	public Vector2 dir;
	protected float speed;
	
	public Item() {
		pos = new Vector2();
		dir = new Vector2();
		speed = 100;
	}
	
	public void update(float dt){
		pos.add(dir.setLength(speed*dt));
		
	}
	
	public void show(Stage s){
		s.addActor(img);
	}
	
	public void die(){
		img.remove();
	}
	
	public void setDir(Vector2 d) {
		dir.set(d);
	}
	
}
