package com.me.mygdxgame.screen;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL10;

public class GameScreen extends GoombaLandScreen{
	//Map map;
	//MapRenderer renderer;

	
	public GameScreen (Game game) {
		super(game);
	}
	
	@Override
	public void show () {
		//map = new Map();
		//renderer = new MapRenderer(map);

	}
	
	@Override
	public void render (float delta) {
		delta = Math.min(0.06f, Gdx.graphics.getDeltaTime());
		//map.update(delta);
		Gdx.gl.glClearColor(0.1f, 0.1f, 0.1f, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		//renderer.render(delta);

		
		//if (map.bob.bounds.overlaps(map.endDoor.bounds)) {
			//game.setScreen(new GameOverScreen(game));
		//}
		
		//if (Gdx.input.isKeyPressed(Keys.B)) {
			game.setScreen(new MainMenu(game));
		//}
}


	@Override
	public void hide () {
		Gdx.app.debug("Cubocy", "dispose game screen");
		//renderer.dispose();

	}
}
