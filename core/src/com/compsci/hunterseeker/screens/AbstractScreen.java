package com.compsci.hunterseeker.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.compsci.hunterseeker.util.Globals;

/**
 * Created by jameslennon on 3/21/15.
 */
public abstract class AbstractScreen implements Screen {

    protected final SpriteBatch batch;
    protected final Skin skin;
    protected Stage stage;
    protected float xscale, yscale;

    public AbstractScreen() {
//		if (Gdx.graphics.getWidth() >= Rayless.APP_WIDTH
//				&& Gdx.graphics.getHeight() >= Rayless.APP_HEIGHT) {
//			stage = new Stage(new ExtendViewport(Rayless.APP_WIDTH,
//					Rayless.APP_HEIGHT));
//		} else {
//			float h = Gdx.graphics.getHeight();
//			float w = h * Rayless.APP_WIDTH / Rayless.APP_HEIGHT;
//			stage = new Stage(new ExtendViewport(w, h));
//		}
        stage = new Stage(new ExtendViewport(Globals.APP_WIDTH, Globals.APP_HEIGHT));
        batch = new SpriteBatch();
        skin = Globals.skin;
    }

    public static void addBack(final AbstractScreen screen, Stage s) {
        Label back = new Label("Back", Globals.skin);
        back.addListener(new ClickListener() {

            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                screen.back();
            }

        });
//		back.setFontScale(2);
//		back.setSize(75, 50);
        back.setPosition(5, s.getHeight() - back.getHeight() - 5);
        s.addActor(back);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0.2f, 0.2f, 0.2f, 1f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act(delta);
        stage.draw();
    }

    @Override
    public void resize(int width, int height) {
        stage.getViewport().update(width, height, true);

        // stage.getCamera().position.set(width/2, height/2, 0);
        // if (width >= Nebulous.APP_WIDTH && height >= Nebulous.APP_HEIGHT) {
        // stage.getViewport().update(width, height, true);
        // } else {
        // // width = (int) (height * 16f/10f);
        // stage.getViewport().update(width, height, true);
        // }
    }

    @Override
    public void show() {
        Gdx.input.setOnscreenKeyboardVisible(false);
        InputAdapter backAdapter = new InputAdapter() {

            @Override
            public boolean keyDown(int keycode) {
                if (keycode == Input.Keys.BACK) {
                    back();
                    return true;
                }
                return false;
            }

        };
        InputMultiplexer im = new InputMultiplexer(backAdapter, stage);
        Gdx.input.setInputProcessor(im);
        Gdx.input.setCatchBackKey(true);
        // Gdx.app.log(Nebulous.log, "showing screen "
        // + this.getClass().getSimpleName());
    }

    public abstract void back();

    @Override
    public void hide() {
        // Gdx.app.log(Nebulous.log, "hiding screen "
        // + this.getClass().getSimpleName());
        Gdx.input.setOnscreenKeyboardVisible(false);
        // stage.addAction(Actions.sequence(Actions.fadeOut(.5f),
        // Actions.run(new Runnable() {
        //
        // @Override
        // public void run() {
        // Gdx.app.postRunnable(new Runnable() {
        //
        // @Override
        // public void run() {
        // stage.clear();
        // }
        // });
        // }
        // })));
        stage.clear();
    }

    @Override
    public void pause() {
    }

    @Override
    public void resume() {
    }

    @Override
    public void dispose() {
        skin.dispose();
        batch.dispose();
        stage.dispose();
    }

    public void next(Runnable r) {
        stage.addAction(Actions.sequence(Actions.fadeOut(.25f), Actions.run(r)));
    }

}
