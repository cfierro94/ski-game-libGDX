package com.cfierro.ski.controllers;

import com.cfierro.ski.views.MainMenu;
import com.cfierro.ski.views.SkierGame;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.Viewport;

public class StageFinal extends Stage implements InputProcessor {
	
	public StageFinal(Viewport v) {
		super(v);
	}

	@Override
    public boolean keyDown(int key) {
		if(key!=19)((Game)Gdx.app.getApplicationListener()).setScreen(new MainMenu());
    	return true;
    }
}
