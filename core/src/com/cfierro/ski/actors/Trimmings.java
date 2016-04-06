package com.cfierro.ski.actors;

import com.cfierro.ski.views.SkierGame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.Actor;
//agregar que para que se ubiquen en el pto deseado se debe poner el centro en ese punto!!
public class Trimmings extends Actor{
	Texture[] trimmings;
	Texture texture;
	int[] posTrimmings;
	float[] y;
	int i;
	int u;
	
	public Trimmings(float[] y){
		this.y=y;
		trimmings=new Texture[3];
		trimmings[0]=new Texture(Gdx.files.internal("tree1.png"));
		trimmings[1]=new Texture(Gdx.files.internal("tree2.png"));
		trimmings[2]=new Texture(Gdx.files.internal("arrow.png"));
		posTrimmings=new int[20];
		for(i=0;i<20;i++)
			posTrimmings[i]=MathUtils.random(20,1999-8);
	}
	@Override
    public void draw(Batch batch, float parentAlpha){
		//-2 para que queden dentro del cerro
		//+8/5 para tomar la altura del centro de la imagen
		float[] posSkier = SkierGame.getPositionPlayer();
		for(i=0;i<10;i++){// 10 arboles 
			if(posTrimmings[i]>posSkier[0]-35 || posTrimmings[i]>1800-15){// 35 pues 20 por la pantalla 15 por el ancho
				batch.draw(trimmings[0],posTrimmings[i],y[posTrimmings[i]+8]-2,15,30);
			}
		}
		for(i=10;i<16;i++){//2 arbustos
			if(posTrimmings[i]>posSkier[0]-35 || posTrimmings[i]>1800-15){// 20 pues 10 por la pantalla 10 por el ancho
				batch.draw(trimmings[1],posTrimmings[i],y[posTrimmings[i]+8]-2,15,22);
			}
		}
		//4 flecha
		for(i=16;i<20;i++){
			if(posTrimmings[i]>posSkier[0]-30 || posTrimmings[i]>1800-10){
				batch.draw(trimmings[2],posTrimmings[i],y[posTrimmings[i]+5]-2,10,16);
			}
		}
	}
}
