package com.me.mygdxgame;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.me.mygdxgame.screen.GoombaLandScreen;




public class IntroScreenPress extends GoombaLandScreen{

	Sound sound;
	TextureRegion intro;
	SpriteBatch batch;
	boolean state;
	public IntroScreenPress(Game game) {
		super(game);
	}
	
	@Override
	public void show () {
		
		intro = new TextureRegion(new Texture(Gdx.files.internal("res/GoombaLand.png")));
		batch = new SpriteBatch();
		batch.getProjectionMatrix().setToOrtho2D(0, 0, 480, 320);
		sound = Gdx.audio.newSound(Gdx.files.internal("res/Via.mp3"));
		
	}
		
		@Override
		public void render (float delta) {
			Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
			batch.begin();
			batch.draw(intro, 0, 0);
			batch.end();
		
			sound.play();
			try {
				Thread.sleep(5500);
				
				} catch(InterruptedException ex) { }
			game.setScreen(new Play());
			

		
		}
		
		@Override
		public void hide () {
		Gdx.app.debug("Cubocy", "dispose intro");
		batch.dispose();
		intro.getTexture().dispose();
		sound.dispose();
		
		}
		
	
}
