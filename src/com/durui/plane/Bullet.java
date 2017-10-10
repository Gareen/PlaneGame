package com.durui.plane;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import com.durui.util.Constant;
import com.durui.util.GameUtil;
/**
 * 子弹轨迹
 * @author Administrator
 *
 */
public class Bullet extends GameObject{

	
	double degree;
	
	public static double speed = 10;
	
	Image img;
	
	public Bullet() {
		degree = Math.random()*Math.PI*2;
		x = Constant.GAME_WIDTH/2;
		y = Constant.GAME_HEIGHT/2;
		width = 10;
		height = 10;

	}
	
	public Bullet(String imgpath,double x,double y) {
		degree = Math.random()*Math.PI*2;
		this.img = GameUtil.getImage(imgpath);
		this.width = img.getWidth(null);
		this.height = img.getHeight(null);
		this.x = x;
		this.y = y;
	}
	
	
	public void drawImage(Graphics g) {
		g.drawImage(img, (int)x, (int)y, null);
		x += speed*Math.cos(degree);
		y += speed*Math.sin(degree);
		
		if(y > Constant.GAME_HEIGHT - height-10|| y < 30){
			degree = -degree;
		}
	
		if(x < 10 || x > Constant.GAME_WIDTH - width-10){
			degree = Math.PI-degree;
		}
	}

	
	
	public void draw(Graphics g) {
		Color c = g.getColor();
		g.setColor(Color.yellow);
		g.fillOval((int)x, (int)y, width, height);
		
		x += speed*Math.cos(degree);
		y += speed*Math.sin(degree);
		
		if(y > Constant.GAME_HEIGHT - height|| y < 30){
			degree = -degree;
		}
	
		if(x < 0 || x > Constant.GAME_WIDTH - width){
			degree = Math.PI-degree;
		
		g.setColor(c);
		}
	}
}
