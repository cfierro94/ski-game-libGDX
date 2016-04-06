package com.cfierro.ski.views;

import com.cfierro.ski.actors.BackgroundGameOver;
import com.cfierro.ski.actors.MessagePlayAgain;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.utils.viewport.StretchViewport;

import com.cfierro.ski.controllers.StageFinal;

public class GameOver implements Screen{
	private Actor gameOver=new BackgroundGameOver();
    private StageFinal stage = new StageFinal(new StretchViewport(600,600));
    private Actor message=new MessagePlayAgain();
	
	@Override
	public void show() {
		stage.addActor(gameOver);
		stage.addActor(message);
		Gdx.input.setInputProcessor(stage);
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act();
        stage.draw();
	}

	@Override
	public void resize(int width, int height) {
	}

	@Override
	public void pause() {
	}

	@Override
	public void resume() {
	}

	@Override
	public void hide() {
	}

	@Override
	public void dispose() {
	}
	
}
