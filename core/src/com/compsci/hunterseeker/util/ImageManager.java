package com.compsci.hunterseeker.util;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

/**
 * Created by jameslennon on 3/21/15.
 */
public class ImageManager {

    public static Texture getImage(String name){
        return new Texture(Gdx.files.internal("images/"+name+".png"));
    }
}
