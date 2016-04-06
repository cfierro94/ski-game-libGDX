package com.cfierro.ski.actors;

public class Coordinates {
	protected int x;
	protected float y;
	public Coordinates(int x, float y){
		this.x=x;
		this.y=y;
	}
	public Coordinates moveDownY(float f) {
		this.y-=f;
		return this;
	}
}
