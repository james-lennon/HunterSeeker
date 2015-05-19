package com.compsci.hunterseeker.util;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.compsci.hunterseeker.HunterSeeker;
import com.compsci.hunterseeker.ai.BrainController;
import com.compsci.hunterseeker.ai.InputManager;
import com.compsci.hunterseeker.items.Item;

/**
 * Created by jameslennon on 3/21/15.
 */
public class Globals {

	public static final float PIXELS_PER_METER = 30;
	public static final int APP_WIDTH = 800;
	public static final int APP_HEIGHT = 500;
	public static final int TILE_WIDTH = 50;

	public static float chaseTime = 25.f, learnTime = 15.f, watchTime = 15.f;
	public static BrainController hunterBc = new BrainController(),
			preyBc = new BrainController();
	public static boolean firstRun = true;

	public static Stage stage;
	public static HunterSeeker game;
	public static Skin skin = new Skin(Gdx.files.internal("layout/uiskin.json"));
	public static InputManager inputManager = new InputManager();

	public static void scaleImage(Image img) {
		img.setSize(img.getWidth() / Globals.PIXELS_PER_METER, img.getHeight()
				/ Globals.PIXELS_PER_METER);
	}

	public static Vector2 getOffset(Item i, Item target) {
		return getOffset(i, target, true);
	}

	public static Vector2 getOffset(Item i, Item target, boolean overlap) {
		Vector2 offset1 = new Vector2(i.pos).sub(target.pos);
		Vector2 offset2 = new Vector2(i.pos).sub(new Vector2(target.pos).sub(0,
				Globals.APP_WIDTH));
		Vector2 offset3 = new Vector2(i.pos).sub(new Vector2(target.pos).add(0,
				Globals.APP_WIDTH));
		Vector2 offset = offset1;
		if (!overlap) {
			return offset;
		}
		if (offset2.len() < offset.len()) {
			offset = offset2;
		}
		if (offset3.len() < offset.len()) {
			offset = offset3;
		}
		return offset;
	}

}
