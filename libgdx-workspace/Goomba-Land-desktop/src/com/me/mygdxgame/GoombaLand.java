package com.me.mygdxgame;


import com.me.mygdxgame.screen.GameScreen; //Mia classe
import com.badlogic.gdx.Game;

public class GoombaLand extends Game {
	@Override
	public void create () {
		setScreen(new GameScreen(this));
	}
}