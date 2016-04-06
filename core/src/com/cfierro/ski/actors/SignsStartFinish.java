package com.cfierro.ski.actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class SignsStartFinish extends Actor{
	private Texture textureStart;
	private Texture textureFinish;
	private float y0;
	private float yf;
	
	public SignsStartFinish(float y0, float yf){
        textureStart = new Texture(Gdx.files.internal("start.png"));
        textureFinish=new Texture(Gdx.files.internal("finish.png"));
        this.y0=y0;
        this.yf=yf;
	}
	
	@Override
    public void draw(Batch batch, float parentAlpha){
		batch.draw(textureStart,0,y0-2,13,13);
		batch.draw(textureFinish,2000-20,yf-1,15,12);//-15 para que quede en el cerro
	}
}
