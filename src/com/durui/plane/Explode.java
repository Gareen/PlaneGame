package com.durui.plane;

import java.awt.Graphics;
import java.awt.Image;

import com.durui.util.GameUtil;

/*
 * ±¨’®¿‡
 */
public class Explode {
	 double x,y;
	static Image[] imgs = new Image[10];
	int count;
	
	public Explode(double x,double y){
		this.x = x;
		this.y = y;
		
	}
	
	public Explode(){}
	
	static {
		for(int i = 0;i < 9;i++) {
			 imgs[i] = GameUtil.getImage("images/aa.gif");
			 imgs[i].getWidth(null);
		}
	}
	
	public  void draw(Graphics g) {
		if(count <= 9) {
			g.drawImage(imgs[count],(int) x,(int) y, null);
			count++;	
		}
	}
}
