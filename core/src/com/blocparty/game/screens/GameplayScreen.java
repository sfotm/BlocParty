package com.blocparty.game.screens;



import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.blocparty.game.utilities.GameClickListener;


public class GameplayScreen implements Screen {

    Stage stage;
    Skin skin;

    SpriteBatch batch;
    ShapeRenderer shapeBatch;

    private final static int BTN_PANEL_LEFT_MARGIN = 200;
    private final static int BTN_PANEL_BOTTOM = 200;

    private int width;
    private int height;
    public static int boxWidth;
    public static int boxHeight;
    
    //public static ArrayList<Box> boxes;
    //row, column
    public static Box[][] boxes;
    
    
    //boolean adjusting = false;
	//float skyTime = 0.0f;
	//float transparencyAchieved = 0.0f;
    float nextCircleTime;
    float timeSoFar;
    float speed;
    
    private static final int ROW_COUNT = 2;
    private static final int COLUMN_COUNT = 4;
    
    
    
    public class Box {
    	public int row;
    	public int column;
    	
    	public int circleRadius = 20;
    	public boolean hasCircle = false;
    }
    


    public GameplayScreen() {
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


        shapeBatch.begin(ShapeType.Line);

        shapeBatch.setColor(Color.BLACK);
        //shapeBatch.rect(0, 0, 100, 50);

        
        
        for (int i = 0; i < COLUMN_COUNT; i++) {
        	for (int j = 0; j < ROW_COUNT; j++) {
        		shapeBatch.rect(i * boxWidth, j * boxHeight, boxWidth, boxHeight);
        	}
        }
        
        shapeBatch.end();
        shapeBatch.begin(ShapeType.Filled);
        
        for (int c = 0; c < COLUMN_COUNT; c++) {
        	for (int r = 0; r < ROW_COUNT; r++) {
        		if (boxes[r][c].hasCircle) {
        			int x = c*boxWidth + boxWidth/2;
        			int y = r*boxHeight + boxHeight/2;
        			
        			shapeBatch.circle(x, y, boxes[r][c].circleRadius);
        		}
        	}
        }
        
        
        
        shapeBatch.end();
        
        
        
        timeSoFar += Gdx.graphics.getDeltaTime();
        if (timeSoFar > nextCircleTime) {
        	//spawn the new circle
        	//System.out.println("spawn");
        	spawnCircle();
        	
        	
        	
        	//reset timers
        	timeSoFar = 0;
        	//time is 1.0 -> 2.0s?
        	nextCircleTime = (float) Math.random() * 1.0f + 1.0f;
        }
        
        
        
//		stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1 / 30f));
//		stage.draw();
    }
    
    
    private void spawnCircle() {
    	int column = (int) (Math.random() * 4);
    	int row = (int) (Math.random() * 2);
    	
    	if (!boxes[row][column].hasCircle) {
    		boxes[row][column].hasCircle = true;
        	boxes[row][column].circleRadius = 60;
    	}
    }
    
    
    private void makeItFit() {


        batch = new SpriteBatch();
        shapeBatch = new ShapeRenderer();

        //hud = GameScreenHUD.create(round);


        width = Gdx.graphics.getWidth();
        height = Gdx.graphics.getHeight();

        boxWidth = width / COLUMN_COUNT;
        boxHeight = height / ROW_COUNT;
        
        
        
        
        //boxes = new ArrayList<Box>();
        boxes = new Box[2][4];
        for (int i = 0; i < COLUMN_COUNT; i++) {
        	for (int j = 0; j < ROW_COUNT; j++) {
        		Box b = new Box();
        		b.row = j;
        		b.column = i;
        		//boxes.add(b);
        		boxes[j][i] = b;
        	}
        }
        
        





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
