package com.cfierro.ski.controllers;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.Viewport;

import com.cfierro.ski.views.SkierGame;

public class StageInitial extends Stage implements InputProcessor {
	private boolean isInput;
	private String text;
	
	public StageInitial(Viewport v) {
		super(v);
		isInput=false;
		openWindowFunction();
	}

	@Override
    public boolean keyDown(int key) {
		if(key!=19){
			SkierGame skierGame=new SkierGame();
			skierGame.setInput(text);
			((Game)Gdx.app.getApplicationListener()).setScreen(skierGame);
		}
    	return true;
    }
	
	private void openWindowFunction(){
		Gdx.input.getTextInput(new Input.TextInputListener() {
            @Override
            public void input(String text) {
                setText(text);    
            }
			@Override
            public void canceled(){
                setIsInput(true);
            }
        },"Ingresar Funcion","","ejemplo:sin(x)/0/20 para elegir y=sin(x) en el dominio desde 0 a 20");	
	}
	public void setText(String string){
		this.text=string;
	}
	public void setIsInput(boolean b){
		this.isInput=b;
	}
}

