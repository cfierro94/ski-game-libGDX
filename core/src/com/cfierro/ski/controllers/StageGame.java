package com.cfierro.ski.controllers;

import com.cfierro.ski.views.GameOver;
import com.cfierro.ski.views.SkierGame;
import com.cfierro.ski.actors.Monster;
import com.cfierro.ski.actors.Mountain;
import com.cfierro.ski.actors.Skier;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.Viewport;

public class StageGame extends Stage implements InputProcessor {
	SkierGame game;
	Skier skier;
	Mountain mountain;
	Monster monsters;
	Rectangle[] monstersRectangle;
	Rectangle skierRectangle;
	int i;
	String function;
	int domI;
	int domF;

    public StageGame(Viewport v, SkierGame game) throws Exception{
        super(v);
        this.game=game;
    }
    
    @Override
    public void draw(){
    	super.draw();
    	monstersRectangle=monsters.getBounds();
    	skierRectangle=skier.getBounds();
        for(i=0;i<monstersRectangle.length;i++){
        	if(skierRectangle.overlaps(monstersRectangle[i])){
        		((Game)Gdx.app.getApplicationListener()).setScreen(new GameOver());
        		
        	}
        }
        if(skier.lose)((Game)Gdx.app.getApplicationListener()).setScreen(new GameOver());
    }
    @Override
    public boolean keyDown(int key) {
    	if(!skier.getStartPlaying());
    	else if(key==19)skier.jump();
    	return true;
    }
    
    public void setSkier(Skier skier){
    	this.skier=skier;
    }
    
    public void setMonsters(Monster monsters){
    	this.monsters=monsters;
    }

	public String getFunction() {
		return function;
	}

	public int getDomI() {
		return domI;
	}

	public int getDomF() {
		return domF;
	}
    

}
