/*******************************************************************************
 * Copyright (C) 2018-2019 Retopall Services
 * For more information please check www.retopall.com
 * RetopMathUtils can not be copied and/or distributed without the express
 * permission of dDev Tech
 ******************************************************************************/

package space;

public class Physics2DCollider {
	private double x;
	private double y;
	private int width;
	private int height;

	public Physics2DCollider(double x,double y,int width,int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height ;
		
	}
	public boolean isInside(double x2,double y2) {
		if(x2>x&&x2<x+width&&y2>y&&y2<y+height) {
			return true;
		}else {
			return false;
		}
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}
	
}
