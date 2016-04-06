package com.cfierro.ski.actors;

import com.cfierro.ski.views.SkierGame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class Monster extends Actor {
	Texture textureMonster;
	static int numberMonsters;
	static int[] posMonsters;
	private float[] y;
	Rectangle[] boundingRectangle;
	
	public Monster(float[] y){
		numberMonsters=6;
		boundingRectangle=new Rectangle[numberMonsters];
        textureMonster = new Texture(Gdx.files.internal("monster2.png"));
        posMonsters=new int[numberMonsters];
        int u=100;
        for(int i=0;i<numberMonsters;i++){
        	posMonsters[i]=MathUtils.random(u,u+308);
        	boundingRectangle[i]=new Rectangle();
        	u+=308;
	}
        this.y=y;
	}
	
	@Override
    public void draw(Batch batch, float parentAlpha){
		for(int i=0;i<numberMonsters;i++){
			batch.draw(textureMonster,posMonsters[i],y[posMonsters[i]]-3,12,16);
			boundingRectangle[i].set(posMonsters[i],y[posMonsters[i]]-3,12,16);
		}
	}
	
	public Rectangle[] getBounds(){
		return boundingRectangle;
	}
	public static int xNearestToPlayer(){
		float[] posPlayer=SkierGame.getPositionPlayer();
		int posxNearest=Integer.MAX_VALUE;
		for(int i=0;i<numberMonsters;i++){
			if((posMonsters[i]-posPlayer[0])>0 && (posMonsters[i]-posPlayer[0])<posxNearest) 
				posxNearest=posMonsters[i];
		}
		return posxNearest;
	}
	
}
