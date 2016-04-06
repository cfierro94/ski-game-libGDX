package com.cfierro.ski.views;

import com.cfierro.ski.actors.InitialAnimation;

import com.cfierro.ski.actors.MessagePlay;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.cfierro.ski.controllers.StageInitial;

public class MainMenu implements Screen {
	private StageInitial stage = new StageInitial(new StretchViewport(400,400));
	
	@Override
	public void show() {
		InitialAnimation animation=new InitialAnimation();
		stage.addActor(animation);
		MessagePlay message=new MessagePlay();
		stage.addActor(message);
		Gdx.input.setInputProcessor(stage);
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act();
        stage.draw();
	}

	@Override
	public void resize(int width, int height) {
		stage.getViewport().update(width, height, true);
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
		stage.dispose();
	}

}
