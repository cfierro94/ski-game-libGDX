package com.cfierro.ski.actors;

import java.util.ArrayList;

import com.cfierro.ski.views.SkierGame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class Snow extends Actor{
	ArrayList<Coordinates> snowFlakes;
	Texture textureSnow;
	int lastSnowDropedFrame;
	
	public Snow(){
		textureSnow= new Texture(Gdx.files.internal("snow1.png"));
		snowFlakes=new ArrayList<Coordinates>();
		lastSnowDropedFrame=20;
	}
	
	@Override
    public void draw(Batch batch, float parentAlpha){
		lastSnowDropedFrame++;
		float[] posSkier = SkierGame.getPositionPlayer();
		if(lastSnowDropedFrame>5){
			int x = MathUtils.random(0,1999);
			if(x>posSkier[0]) snowFlakes.add(new Coordinates(x,200-7));
			lastSnowDropedFrame=0;
		}
		for(int i=0;i<snowFlakes.size();i++){
			snowFlakes.set(i, snowFlakes.get(i).moveDownY(30*Gdx.graphics.getDeltaTime()));
			Coordinates coordinates=snowFlakes.get(i);
			if(coordinates.y<posSkier[1]-60) snowFlakes.remove(i);
			batch.draw(textureSnow,
					coordinates.x,
					coordinates.y,
					7,7);
		}
	}
}
