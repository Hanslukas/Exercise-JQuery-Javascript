package com.me.mygdxgame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer.Cell;
import com.badlogic.gdx.math.Vector2;

public class Player extends Sprite implements InputProcessor{

		  
		  private Vector2 velocity = new Vector2();
	      private TiledMapTileLayer collisionLayer;
	      private String blockedKey = "blocked";
	      private boolean canJump;
	      
	      private float speed = 60 *2, gravity = 70 * 0.7f;
	      
	      public Player(Sprite sprite, TiledMapTileLayer collisionLayer){
	    	  super(sprite);
	    	  this.collisionLayer = collisionLayer;
	      }
	      
	      @Override
	      public void draw(SpriteBatch spriteBatch) {
	              update(Gdx.graphics.getDeltaTime());
	              super.draw(spriteBatch);
	      }
	      
	      public void update(float delta) {
              // apply gravity
              velocity.y -= gravity * delta;

              // clamp velocity
              if(velocity.y > speed)
                      velocity.y = speed;
              else if(velocity.y < -speed)
                      velocity.y = -speed;

              // save old position
              float oldX = getX(), oldY = getY();
              boolean collisionX = false, collisionY = false;

              // move on x
              setX(getX() + velocity.x * delta);

              if(velocity.x < 0)  // going left
                       collisionX = collidesLeft();
               else if(velocity.x > 0) //going right
            	   collisionX = collidesRight();

              // react to x collision
              if(collisionX) {
                      setX(oldX);
                      velocity.x = 0;
                      
              }

              // move on y
            setY(getY() + velocity.y * delta);

           if(velocity.y < 0) // going down
                    canJump = collisionY = collidesBottom();
               else if(velocity.y > 0) // going up
            	   collisionY = collidesTop();
              
              // react to y collision
              if(collisionY) {
                      setY(oldY);
                      velocity.y = 0;
              }
	      }
	      
	      private boolean isCellBlocked(float x, float y){
              Cell cell = collisionLayer.getCell((int) (x / collisionLayer.getTileWidth()), (int) (y / collisionLayer.getTileHeight()));
              return cell != null && cell.getTile() != null && cell.getTile().getProperties().containsKey(blockedKey);

	      }
	      
	      public boolean collidesRight() {
	    	  boolean collides = false;
	    	  for(float step = 0; step <= getHeight(); step +=collisionLayer.getTileHeight() / 2)
	              if(collides = isCellBlocked(getX() + getWidth(),  getY() + step))
	            	  break;
	    	  return collides;
      
      }

      public boolean collidesLeft() {
    	  boolean collides = false;
          for(float step = 0; step <= getHeight(); step +=collisionLayer.getTileHeight() / 2)
              if(collides = isCellBlocked(getX(),  getY() + step))
            	  break;
    	  return collides;

      }

      public boolean collidesTop() {
    	  boolean collides = false;
          for(float step = 0; step <= getWidth(); step +=collisionLayer.getTileWidth() / 2)
        	  if(collides = isCellBlocked(getX() + step, getY() + getHeight()))
        		  break;
    	  return collides;
        
      }

      public boolean collidesBottom() {
    	  boolean collides = false;
              for(float step = 0; step <= getWidth(); step +=collisionLayer.getTileWidth() / 2)
                      if(collides = isCellBlocked(getX() + step,  getY()))
                    	  break;
              
              return collides;
      }
      
		public Vector2 getVelocity() {
			return velocity;
		}

		public void setVelocity(Vector2 velocity) {
			this.velocity = velocity;
		}

		public TiledMapTileLayer getCollisionLayer() {
			return collisionLayer;
		}

		public void setCollisionLayer(TiledMapTileLayer collisionLayer) {
			this.collisionLayer = collisionLayer;
		}

		public float getSpeed() {
			return speed;
		}

		public void setSpeed(float speed) {
			this.speed = speed;
		}

		public float getGravity() {
			return gravity;
		}

		public void setGravity(float gravity) {
			this.gravity = gravity;
		}

		@Override
		public boolean keyDown(int keycode) {
			switch(keycode) {
            case Keys.W:
                    if(canJump) {
                    	
                            velocity.y = (speed) / 1.8f;
                            canJump = false;
                    }
                    break;
            case Keys.A:
                    velocity.x = -speed;
                    break;
            case Keys.D:
                velocity.x = speed;
			}
			return true;
		}
		

		@Override
		public boolean keyUp(int keycode) {
			switch(keycode) {
            case Keys.A:
            case Keys.D:
                    velocity.x = 0;
            }
            return true;
		}

		@Override
		public boolean keyTyped(char character) {
						return false;
		}

		@Override
		public boolean touchDown(int screenX, int screenY, int pointer,
				int button) {
						return false;
		}

		@Override
		public boolean touchUp(int screenX, int screenY, int pointer, int button) {
						return false;
		}

		@Override
		public boolean touchDragged(int screenX, int screenY, int pointer) {
						return false;
		}

		@Override
		public boolean mouseMoved(int screenX, int screenY) {
						return false;
		}

		@Override
		public boolean scrolled(int amount) {
						return false;
		}
	      
	      
}