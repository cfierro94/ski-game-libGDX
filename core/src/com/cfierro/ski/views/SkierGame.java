package com.cfierro.ski.views;

import com.cfierro.ski.actors.Monster;
import com.cfierro.ski.actors.Mountain;
import com.cfierro.ski.actors.SignsStartFinish;
import com.cfierro.ski.actors.Skier;
import com.cfierro.ski.actors.Sky;
import com.cfierro.ski.actors.Snow;
import com.cfierro.ski.actors.Trimmings;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.utils.viewport.StretchViewport;

import com.cfierro.ski.controllers.StageGame;

public class SkierGame implements Screen {
	private StageGame stageGame;
    private Camera camera;
    private static Skier skier;
    private int framesToStart;
    private String[] text;
    
    @Override
    public void render(float delta) {
    		framesToStart+=1;
    		if(framesToStart>10)skier.setStartPaying();
			Gdx.gl.glClearColor(1, 1, 1, 1);
			Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
			stageGame.act(Gdx.graphics.getDeltaTime());//This causes the act method on every actor in the scene to be called
	        stageGame.draw();//When draw is called on the stage, it calls draw on every actor in the stage
	        float [] posPlayer={skier.getXPos(),skier.getYPos()};
	        if((posPlayer[0]+180)<2000 && posPlayer[0]>=20) {
	        	camera.position.set(posPlayer[0]+80, posPlayer[1]+40, 0);
	        }
	        else if(posPlayer[0]<20)camera.position.set(100,posPlayer[1]+40, 0);
    }

    @Override
    public void resize(int width, int height) {     
    }

    @Override
    public void show() {
    	try {
			stageGame = new StageGame(new StretchViewport(200,200),this);
	        Sky sky=new Sky();
	        stageGame.addActor(sky);
	        
	        Mountain mountain = new Mountain(text[0],Integer.parseInt(text[1]),Integer.parseInt(text[2]));
	        stageGame.addActor(mountain);
	        
	        float[] y=mountain.getYies();
	        float[] x=mountain.getXies();
	        
	        SignsStartFinish sign=new SignsStartFinish(y[13],y[1995]);
	        stageGame.addActor(sign);
	        
	        Trimmings trimmings=new Trimmings(y);
	        stageGame.addActor(trimmings);
	        
	        Monster monster= new Monster(y);
	        stageGame.addActor(monster);
	        stageGame.setMonsters(monster);
	        
	        skier=new Skier(x,y);
	        stageGame.addActor(skier);
	        stageGame.setSkier(skier);
	        
	        Snow snow=new Snow();
	        stageGame.addActor(snow);
	        
			Gdx.input.setInputProcessor(stageGame);
			framesToStart=0;
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		camera=stageGame.getCamera();
    }

    @Override
    public void hide() {
        dispose();
    }

    @Override
    public void pause() {       
    }

    @Override
    public void resume() {      
    }

    @Override
    public void dispose() {
        stageGame.dispose();
    }
    public static float[] getPositionPlayer(){
    	float[] ans={skier.getXPos(),skier.getYPos()};
    	return ans;
    }

	public void setInput(String text) {
			System.out.println("aqui");
			this.text=text.split("/");
	}
}
