package com.blocparty.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.blocparty.game.utilities.GameClickListener;

import static com.badlogic.gdx.graphics.glutils.ShapeRenderer.*;

/**
 * Created by sfotm on 11/14/15.
 */
public class MenuScreen implements Screen {

    Stage stage;
    Skin skin;

    SpriteBatch batch;
    ShapeRenderer shapeBatch;

    private final static int BTN_PANEL_LEFT_MARGIN = 200;
    private final static int BTN_PANEL_BOTTOM = 200;


    public MenuScreen() {
        makeItFit();
    }

    @Override
    public void resize(int width, int height) {
        makeItFit();
    }

    @Override
    public void render(float arg0) {
        Gdx.gl.glClearColor(0.2f, 0.2f, 0.2f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);


        shapeBatch.begin(ShapeType.Filled);

        shapeBatch.setColor(Color.LIGHT_GRAY);
        shapeBatch.rect(0, 0, 100, 50);

        shapeBatch.end();



//		stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1 / 30f));
//		stage.draw();
    }

    private void makeItFit() {


        batch = new SpriteBatch();
        shapeBatch = new ShapeRenderer();

        //hud = GameScreenHUD.create(round);






        InputMultiplexer multiplexer = new InputMultiplexer();
        multiplexer.addProcessor(new GameClickListener());
        Gdx.input.setInputProcessor(multiplexer);



//		stage = new Stage();
//		Gdx.input.setInputProcessor(stage);
//		skin = new Skin(Gdx.files.internal("data/uiskin.json"));

    }



    //===========================================

    @Override
    public void dispose() {
    }
    @Override
    public void hide() {
    }
    @Override
    public void pause() {
    }
    @Override
    public void resume() {
    }
    @Override
    public void show() {
    }
}
