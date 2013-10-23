package com.me.mygdxgame;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

public class Main {
        public static void main (String[] args) {
        	LwjglApplicationConfiguration cfg = new LwjglApplicationConfiguration();
            cfg.width = 1280; //480
            cfg.height = 720; //320
            cfg.resizable = false;
            cfg.title = "Goomba Land";
            cfg.useGL20 = true;
            cfg.vSyncEnabled = true; /*Evita errori di v-Sync*/

            new LwjglApplication(new GoombaLand(), cfg);
            }
}