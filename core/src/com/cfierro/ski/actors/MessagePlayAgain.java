package com.cfierro.ski.actors;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class MessagePlayAgain extends Actor{
    private BitmapFont font;
    
    public MessagePlayAgain(){
    	font=new BitmapFont();
    }
    
    @Override
    public void draw(Batch batch, float parentAlpha){
    	font.draw(batch, "TOUCH ENTER TO PLAY AGAIN", 175, 150);
    }
}
