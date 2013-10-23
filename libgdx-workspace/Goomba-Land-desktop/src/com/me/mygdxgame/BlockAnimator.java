package com.me.mygdxgame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class BlockAnimator implements Screen{
	
	private static final int FRAME_COLS = 6;
	private static final int FRAME_ROWS = 4;
	
	Animation walkAnimation;
	Texture  walkSheet;
	TextureRegion[] walkFrames;
	SpriteBatch spriteBatch;
	TextureRegion currentFrame;
	
	float stateTime;
	
	@Override
	public void resize(int width, int height) {
				
	}

	@Override
	public void pause() {
				
	}

	@Override
	public void resume() {
				
	}

	@Override
	public void dispose() {
				
	}


	@Override
	public void render(float delta) {  
			Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT | GL10.GL_DEPTH_BUFFER_BIT);                                            // #14
	        stateTime += Gdx.graphics.getDeltaTime();  
	        currentFrame = walkAnimation.getKeyFrame(stateTime, true); 
			
	        spriteBatch.begin();
	        spriteBatch.draw(currentFrame, 50, 50);                         
	        spriteBatch.end();	
	        
	}


	@Override
	public void show() {
		
		walkSheet = new Texture(Gdx.files.internal("res/Block.png"));
		TextureRegion[][] tmp = TextureRegion.split(walkSheet, walkSheet.getWidth() / 
				FRAME_COLS, walkSheet.getHeight() / FRAME_ROWS);
		 walkFrames = new TextureRegion[FRAME_COLS * FRAME_ROWS];
         int index = 0;
         for (int i = 0; i < FRAME_ROWS; i++) {
                 for (int j = 0; j < FRAME_COLS; j++) {
                         walkFrames[index++] = tmp[i][j];
                 }
         }
         walkAnimation = new Animation(0.025f, walkFrames);              
         spriteBatch = new SpriteBatch();                                
         stateTime = 0f; 
			
	}


	@Override
	public void hide() {
		
	}
}
