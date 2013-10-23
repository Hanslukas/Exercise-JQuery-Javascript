package com.me.mygdxgame.screen;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.me.mygdxgame.IntroScreenPress;

public class IntroScreen extends GoombaLandScreen{

	TextureRegion intro;
	SpriteBatch batch;
	
	Music music;
	
	public IntroScreen(Game game) {
		super(game);
	}
	
	@Override
	public void show () {
		try {
			Thread.sleep(4000);
			} catch(InterruptedException ex) { }
		music = Gdx.audio.newMusic(Gdx.files.internal("res/Main.mp3"));
		
		music.setLooping(true); /*setta il loop della musica*/
		music.setVolume(0.7f); /* setta il volume. Range [0,1] */
		music.play(); /*Avvia la musica*/
		
		intro = new TextureRegion(new Texture(Gdx.files.internal("res/GoombaLand.png")));
		batch = new SpriteBatch();
		batch.getProjectionMatrix().setToOrtho2D(0, 0, 480, 320);
		
	}
		
		@Override
		public void render (float delta) {
			Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
			batch.begin();
			batch.draw(intro, 0, 0);
			batch.end();
			
			
			//Questo if mi permette il cambio di musica alla pressione del tasto
			if (Gdx.input.isKeyPressed(Keys.A)) {
				
				music.stop();
				game.setScreen(new IntroScreenPress(game));

			}
		
			
			
		
		}
		
		@Override
		public void hide () {
		Gdx.app.debug("Cubocy", "dispose intro");
		batch.dispose();
		intro.getTexture().dispose();
		music.dispose();
		}
	
	
}