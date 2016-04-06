package com.cfierro.ski.actors;

import net.objecthunter.exp4j.ExpressionBuilder;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class Mountain extends Actor {   
    private ShapeRenderer renderer;
    
    private double[] x;
    private static double[] y;
    
    int n;//largo "pelicula"
    double domI;
    double domF;
    double minY;
    double heigth;
    double punto;
    
    public Mountain(){
    	
    }
    
    public Mountain(String function, int domI, int domF) throws Exception{
    	renderer = new ShapeRenderer();
        n=2000;
        this.domI=domI;
        this.domF=domF;
        evaluateFunction(function);
    }

    @Override
    public void draw(Batch batch, float parentAlpha){
    	//System.out.println("origen x="+getOriginX()+" origen y="+getOriginY());
    	batch.end();
        renderer.setProjectionMatrix(batch.getProjectionMatrix());
        renderer.setTransformMatrix(batch.getTransformMatrix());
        renderer.translate(getX(), getY(), 0);
        renderer.begin(ShapeType.Filled);
        renderer.setColor(Color.WHITE);
        
        for(int i=0;i<n-1;i++){
        	renderer.line((float) i,
        			      (float) (y[i]),
        			      (float )i+1,
        			      (float) (y[i+1]));
        	
        	if ((float)(y[i]) > (float)(y[i+1]))punto=y[i+1];
        	else punto=y[i];
        	heigth=(punto-minY)*60+60;
        	renderer.rect(i, (float)(punto-heigth), 1, (float)heigth);
        }
        //renderer.rect(i, (float)(y[i+1]-150), 1, 150);
        //renderer.rect(i, (float)(y[i]-150), 1, 150);
        renderer.end();

        batch.begin();
        /*float[] posSkier = StageGame.getPositionPlayer();
        for(int i=0;i<n-1;i++){
        	batch.draw(textureWhite,posSkier[0]-50,posSkier[1]-50,1,(float)y[i]);
        }*/
        
    }
    public float[] getYies(){
    	float [] ans=new float[n];
    	for(int i=0;i<n;i++){
    		ans[i]=(float)y[i];
    	}
    	return ans;
    }
    public float[] getXies(){
    	float [] ans=new float[n];
    	for(int i=0;i<n;i++){
    		ans[i]=(float)x[i];
    	}
    	return ans;
    }
    public double getMinY(){
    	return minY;
    }
    public static float getY0(){
    	return (float) y[0];
    }
    private void evaluateFunction(String expr) throws Exception{
    	double d=(domF-domI);
        double delta=d/n;
        double u=domI;
        
    	x= new double[n];
    	y= new double[n];
    	minY=Integer.MAX_VALUE;
    	
    	for(int index=0;index<n;index++){
    		x[index]=u;
    		y[index]= new ExpressionBuilder(expr)
            		.variables("pi", "e", "rtwo", "phi","x")
            		.build()
		            .setVariable("pi",Math.PI)
		            .setVariable("e",Math.E)
		            .setVariable("rtwo",Math.sqrt(2))
		            .setVariable("phi",(1+Math.sqrt(5))/2)
		            .setVariable("x",u)
		            .evaluate();    		
    		u+=delta;
    		if(y[index]<minY) minY=y[index];
    	}
    }
    
}
