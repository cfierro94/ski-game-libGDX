package com.cfierro.ski.actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class BackgroundGameOver extends Actor {
	Texture texture;

	public BackgroundGameOver(){
		texture = new Texture(Gdx.files.internal("gameOver.jpg"));
	}
	
	@Override
    public void draw(Batch batch, float parentAlpha){
		batch.draw(texture,0,0,600,600);
	}
}
