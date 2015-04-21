package com.compsci.hunterseeker.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.compsci.hunterseeker.HunterSeeker;
import com.compsci.hunterseeker.util.Globals;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.height = Globals.APP_HEIGHT;
		config.width = Globals.APP_WIDTH;
		new LwjglApplication(new HunterSeeker(), config);
	}
}
