package com.compsci.hunterseeker.util;

import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.math.Vector2;
import com.compsci.hunterseeker.items.Item;

public class InputManager extends InputAdapter {

	private boolean up, down, left, right;

	@Override
	public boolean keyDown(int keycode) {
		if (keycode == Keys.UP || keycode == Keys.W) {
			up = true;
		} else if (keycode == Keys.RIGHT || keycode == Keys.D) {
			right = true;
		} else if (keycode == Keys.DOWN || keycode == Keys.S) {
			down = true;
		} else if (keycode == Keys.LEFT || keycode == Keys.A) {
			left = true;
		}
		return true;
	}

	@Override
	public boolean keyUp(int keycode) {
		if (keycode == Keys.UP || keycode == Keys.W) {
			up = false;
		} else if (keycode == Keys.RIGHT || keycode == Keys.D) {
			right = false;
		} else if (keycode == Keys.DOWN || keycode == Keys.S) {
			down = false;
		} else if (keycode == Keys.LEFT || keycode == Keys.A) {
			left = false;
		}
		return true;
	}

	public void update(Item i) {
		Vector2 d = new Vector2();
		d.x = right ? 1 : left ? -1 : 0;
		d.y = up ? 1 : down ? -1 : 0;
		i.setDir(d);
	}

}
