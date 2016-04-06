package com.cfierro.ski.actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class InitialAnimation extends Actor{
	Texture texture;
	TextureRegion[] monsters;
	TextureRegion currentFrame;
	Animation monsterEating;
	int changeImage;
	int waiting;
	boolean wait;
	int i;

	public InitialAnimation(){
		texture = new Texture(Gdx.files.internal("monsterEating.png"));
		monsters=new TextureRegion[5];
		monsters[0]=new TextureRegion(texture,0,0,33,42);
		monsters[1]=new TextureRegion(texture,33,0,33,42);
		monsters[2]=new TextureRegion(texture,64,0,33,42);
		monsters[3]=new TextureRegion(texture,95,0,27,42);
		monsters[4]=new TextureRegion(texture,122,0,33,42);
		changeImage=0;
		i=0;
		waiting=0;
		wait=false;
	}
	
	@Override
    public void draw(Batch batch, float parentAlpha){
		batch.draw(monsters[i],240,100,120,200);
		if(!wait) changeImage++;
		else waiting++;
		
		if(waiting>100){
			waiting=0;
			wait=false;
			i=1;
		}
		if(changeImage>18){
			if(i==4) wait=true;
			else i++;
			changeImage=0;
		}
        
	}
}
