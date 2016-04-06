package com.cfierro.ski.actors;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class MessagePlay extends Actor{
    private BitmapFont font;
    
    public MessagePlay(){
    	font=new BitmapFont();
    }
    
    @Override
    public void draw(Batch batch, float parentAlpha){
    	font.getRegion().getTexture().setFilter(TextureFilter.Linear, TextureFilter.Linear);
    	font.setColor(Color.BLACK);
    	font.draw(batch, "TOUCH", 90, 270);
    	font.draw(batch, "ENTER", 91, 240);
    	font.draw(batch, "TO", 103, 210);
    	font.draw(batch, "PLAY", 97, 180);
    	font.setColor(Color.WHITE);
    	font.draw(batch, "To avoid the monsters press up!", 100, 50);
    }
}