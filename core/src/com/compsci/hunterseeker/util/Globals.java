package com.compsci.hunterseeker.util;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.compsci.hunterseeker.HunterSeeker;
import com.compsci.hunterseeker.ai.InputManager;

/**
 * Created by jameslennon on 3/21/15.
 */
public class Globals {

    public static final float PIXELS_PER_METER = 30;
    public static final int APP_WIDTH = 800;
    public static final int APP_HEIGHT = 500;
    public static final int TILE_WIDTH = 50;

    public static Stage stage;
    public static HunterSeeker game;
    public static Skin skin = new Skin(Gdx.files.internal("layout/uiskin.json"));
    public static InputManager inputManager = new InputManager();

    public static void scaleImage(Image img){
        img.setSize(img.getWidth()/Globals.PIXELS_PER_METER, img.getHeight()/Globals.PIXELS_PER_METER);
    }

}
