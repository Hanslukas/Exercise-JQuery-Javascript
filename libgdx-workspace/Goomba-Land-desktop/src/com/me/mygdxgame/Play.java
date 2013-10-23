package com.me.mygdxgame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;


public class Play implements Screen {

    private TiledMap map;
    private OrthogonalTiledMapRenderer renderer;
    private OrthographicCamera camera;
    private Player player;
	
    @Override
	public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        
        renderer.setView(camera);
        renderer.render();
        

          camera.position.set(player.getX() + player.getWidth() / 2, player.getY() + player.getHeight() / 2, 0);
          camera.update();
        
        renderer.getSpriteBatch().begin();
        player.draw(renderer.getSpriteBatch());
        renderer.getSpriteBatch().end();
         // player.setPosition(300, 160);

        

    }
    
	@Override
	public void resize(int width, int height) {
		camera.viewportWidth = width;
        camera.viewportHeight = height;
       // camera.position.set(width / 2, height / 2, 0);
       
        
	}
	@Override
	public void show() {
		 map = new TmxMapLoader().load("res/maps.tmx");

         renderer = new OrthogonalTiledMapRenderer(map);
         camera = new OrthographicCamera();
         player = new Player(new Sprite(new Texture("res/Goomba.png")), (TiledMapTileLayer) map.getLayers().get(0));         
     //   player.setPosition(11 * player.getCollisionLayer().getTileWidth(), (player.getCollisionLayer().getHeight() -2) * player.getCollisionLayer().getTileHeight());
        player.setPosition(220, 920);
         Gdx.input.setInputProcessor(player);
	}
	@Override
	public void hide() {
		dispose();
	}
	@Override
	public void pause() {
				
	}
	@Override
	public void resume() {
				
	}
	@Override
	public void dispose() {
		map.dispose();
        renderer.dispose();
        player.getTexture().dispose();
				
	}
    
}