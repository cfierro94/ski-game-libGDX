package com.cfierro.ski.actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class Skier extends Actor {

    private Sprite skiing;
    private Sprite wining;
    private int sideImage;
    
    private float y[];
    private float x[];
    
    private float deltaT;
    private double g;
    double x1;
    double y1;
    double v1;
    double v1x;
    double v1y;
    double x2;
    double y2;
    double v2;
    double v2x;
    double v2y;
    
    private boolean isFlying;
    private boolean startPlaying;
    private boolean won;
    public boolean lose;
    
    private Rectangle boundingRectangle;
    
    public Skier(float[] x,float []y){
    	this.x=x;
    	this.y=y;
    	boundingRectangle= new Rectangle();
    	this.sideImage=10;
    	initializeTextures();
       
        deltaT=0;
        isFlying=false;
        
        g=200;
        
        x1=0;
        y1=y[0];
        v1=60;
        v1x=v1;
        v1y=0;
        startPlaying=false;
        won=false;//fin pista
        lose=false;//velocidad 0
    }

    @Override
    public void draw(Batch batch, float parentAlpha){
    	if(startPlaying && !won){
	    	deltaT=Gdx.graphics.getDeltaTime();
	    	if (!won && !isFlying){//i+1<400 for the grades calculus 
	    		x2=x1+v1*deltaT;
	    		int xMenor=(int)Math.ceil(x2);
	    		int xMayor=(int)Math.floor(x2);
	    		if(xMenor>=1980) {
	    			skiing.set(wining);
	    			won=true;
	    		}
	    		if(!won){
		    		y2=yInter(xMenor,xMayor,x2);
		    		if((2*g*(y1-y2)+Math.pow(v1,2))<0)lose=true;
		    		if(!lose){
			    		v2=Math.sqrt(2*g*(y1-y2)+Math.pow(v1,2));
			    		double teta=elevation(x2,y2);
			    		v2x=v2*Math.cos(teta);
			    		v2y=v2*Math.sin(teta);
				    	batch.draw(skiing,(float)x2,(float)(y2-3),0,0,sideImage-1,sideImage+2,getScaleX(),getScaleY(),0);
				    	boundingRectangle.set((float)x2, (float)(y2-3), sideImage-1,sideImage+2);
		    		}
		    	}
	    		x1=x2;
	    		y1=y2;
	    		v1=v2;
	    		v1x=v2x;
	    		v1y=v2y;
	    	}
	    	else if(isFlying){
	    		v1y+=-g*deltaT;
	    		y1+=v1y*deltaT;
	    		x1+=v1x*deltaT;
	    		v1=Math.sqrt(Math.pow(v1x,2)+Math.pow(v1y, 2));
	    		double yInter=yInter((int)Math.floor(x1), (int)Math.ceil(x1), x1);
	    		if(y1<yInter){
	    			isFlying=false;
	    		}
	    		batch.draw(skiing,(float)x1,(float)(y1-3),0,0,sideImage-1,sideImage+2,getScaleX(),getScaleY(),0);
				boundingRectangle.set((float)x1, (float)(y1-3), sideImage-1,sideImage+2);
	    	}
    	}
    	else if(won){
    		batch.draw(skiing,1980,(float)(y[1980]-3),0,0,sideImage-1,sideImage+2,getScaleX(),getScaleY(),0);
    	}
    }
   
    public void jump() {
    	if(isFlying) return;
    	if(v1x<60)v1x=60;
    	double h;
    	if(elevation(x1,y1)>0 && elevation(x1,y1)<Math.PI/6) {
    		h=29+20*elevation(x1,y1);
    		System.out.println("e1");
    	}
    	else if(elevation(x1,y1)>Math.PI/6 && elevation(x1,y1)<Math.PI/3){
    		h=29+10;
    		System.out.println("e2");
    	}
    	else if(elevation(x1,y1)>Math.PI/3 && elevation(x1,y1)<Math.PI){
    		h=29+10;
    		System.out.println("e3");
    	}
    	else h=29;
    	double v02=2*h*g/Math.sin(Math.PI*33/64);
    	v1y=Math.sqrt(v02-Math.pow(60,2));
		isFlying=true;
	}    
    
    private double elevation(double posX,double posY){
    	if(Math.ceil(posX)==Math.floor(posX)){
    		return Math.atan((y[(int)posX+1]-y[(int)posX])/(x[(int)posX+1]-x[(int)posX]));
    	}
    	else{
    		int xMenor=(int)Math.floor(posX);
    		int xMayor=(int)Math.ceil(posX);
    		double xInter=xInter(xMenor,xMayor,posX);
    		return Math.atan((y[xMayor]-posY)/(x[xMayor]-xInter));
    	}
    }
    
    private double xInter(int x1,int x2, double x12){
    	return (x12-x1)*(x[x2]-x[x1])/(x2-x1) + x[x1];
    }
    
    private double yInter(int x1, int x2, double x12){//x12 perteneciente al eje x no al dominio!!
    	return (x12-x1)*(y[x2]-y[x1])/(x2-x1) + y[x1];
    }
    
    private void initializeTextures(){
    	Texture textureSkier=new Texture(Gdx.files.internal("skiing.png"));
        skiing=new Sprite(textureSkier);
        Texture textureWin=new Texture(Gdx.files.internal("wining.png"));
        wining=new Sprite(textureWin);
    }
    
    
    public float getXPos(){
    	if(x1<0) return 0;
    	return (float)x1;
    }
    public float getYPos(){
    	if(x1<0) return y[0];
    	return (float)y1;
    }
    public Rectangle getBounds(){
    	return boundingRectangle;
    }
    public void setStartPaying(){
    	this.startPlaying=true;
    }
    public boolean getStartPlaying(){
    	return this.startPlaying;
    }
}

