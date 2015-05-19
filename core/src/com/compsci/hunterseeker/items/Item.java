package com.compsci.hunterseeker.items;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.compsci.hunterseeker.ai.ItemController;
import com.compsci.hunterseeker.util.Globals;

public class Item {

	public Image img;
	public Vector2 pos;
	public Vector2 dir;
	protected float speed;
	protected ItemController cont;

	public Item() {
		pos = new Vector2();
		dir = new Vector2();
		speed = 300;
	}

	public void update(float dt) {
		if (cont != null) {
			cont.update(this);
		}
		checkBounds();
		pos.add(new Vector2(dir).setLength(speed * dt));
		img.setPosition(pos.x, pos.y);
	}

	public void show(Stage s) {
		s.addActor(img);
	}

	public void die() {
		img.remove();
	}

	public void setDir(Vector2 d) {
		dir.set(d);
	}

	public void checkBounds() {
		if (top() > Globals.APP_HEIGHT && dir.y > 0) {
			dir.y = 0;
		} else if (bottom() < 0 && dir.y < 0) {
			dir.y = 0;
		}
		if (right() > Globals.APP_WIDTH && dir.x > 0) {
			dir.x = 0;
//			pos.x -= Globals.APP_WIDTH;
		} else if (left() < 0 && dir.x < 0) {
			dir.x = 0;
//			pos.x += Globals.APP_WIDTH;
		}
	}

	public void setController(ItemController c) {
		cont = c;
	}

	public double top() {
		return pos.y + img.getHeight();
	}

	public double bottom() {
		return pos.y;// - img.getHeight() / 2;
	}

	public double right() {
		return pos.x + img.getWidth();
	}

	public double left() {
		return pos.x; // - img.getWidth() / 2;
	}

	public boolean overlaps(Item other) {
		if (pos.x < other.pos.x && right() > other.left()) {
			if (pos.y < other.pos.y && top() > other.bottom()) {
				return true;
			} else if (pos.y > other.pos.y && bottom() < other.top()) {
				return true;
			}
			return false;
		} else if (pos.x > other.pos.x && left() < other.right()) {
			if (pos.y < other.pos.y && top() > other.bottom()) {
				return true;
			} else if (pos.y > other.pos.y && bottom() < other.top()) {
				return true;
			}
			return false;
		}
		return false;
	}

}
