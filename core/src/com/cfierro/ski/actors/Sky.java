package com.cfierro.ski.actors;

import com.cfierro.ski.views.SkierGame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class Sky extends Actor {
    private Texture textureSky;
    private float[] lastPosition;
    float[] firstPosition;
    boolean firstTime;
	
	public Sky(){
        textureSky = new Texture(Gdx.files.internal("sky.png"));
        firstTime=true;
	}
	
	@Override
    public void draw(Batch batch, float parentAlpha){
		float[] posSkier = SkierGame.getPositionPlayer();
		/*if(firstTime) {
			firstPosition=posSkier;
			firstTime=false;
		}*/
		
		if(posSkier[0]+180<2000 && posSkier[0]>=20){
			//System.out.println("h");
			lastPosition=posSkier;
			batch.draw(textureSky,posSkier[0]-20,posSkier[1]-60,200,200);
		}
		else if(posSkier[0]<20){
			batch.draw(textureSky,0,posSkier[1]-60,200,200);
		}
		/*else if((posSkier[0]-10<0)){
			batch.draw(textureSky,firstPosition[0]-10,firstPosition[1]-30,100,100);
		}*/
		else {
			//System.out.println("o");
			if(lastPosition==null) batch.draw(textureSky,0,Mountain.getY0()-30,200,200);
			else batch.draw(textureSky,lastPosition[0]-20,lastPosition[1]-60,200,200);
		}
	}
}
