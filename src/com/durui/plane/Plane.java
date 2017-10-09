package com.durui.plane;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

import com.durui.util.GameUtil;

public class Plane extends GameObject {
	
	private boolean right,left,up,down;
	private boolean live = true;
	Explode b = new Explode(0,0);
	
	public Rectangle getRect() {
		Rectangle r = new Rectangle((int)x,(int)y,width,height);
		return r;
	}
	
	public void draw(Graphics g) {
		if(live) {
			g.drawImage(img, (int)x,(int)y,null);
			//…Ë÷√∑…ª˙∑…––∑∂Œß
			
			if(y <= 30 ) {
				if(x >= 700 && x < 900) {
					if(y < 25) {
						PlaneGameFrame.printInfo(g,"≤ª“™◊ÍBUG£¨–ª–ª£°",20,600,100,Color.red);
					}
				}else {
					y = 30;
				}
			}
			if(y >= 888 - img.getHeight(null)) {
				y  = 888 - img.getHeight(null)-10;
			}
			if(x <= 10 ) {
				x = 10;
			}
			if(x > 1000-width) {
				x = 1000-width-10;
			}
			move();
		}else {
			g.drawImage(GameUtil.getImage("images/bg.jpg"), 0, 0, null);
		}
	}
	
	public Plane(String imgpath,double x,double y) {
		
		this.img = GameUtil.getImage(imgpath);
		this.width = img.getWidth(null);
		this.height = img.getHeight(null);
		this.x = x;
		this.y = y;
	}
	
	public Plane() {
		
	}
	
	public void move() {
		if(left) {
			x -= speed;
		}
		if(right) {
			x += speed;
		}
		if(up) {
			y -= speed;
		}
		if(down) {
			y += speed;
		}
	}
	
	public void addDirection(KeyEvent e) {
		switch(e.getKeyCode()) {
		case KeyEvent.VK_LEFT:
			left = true;
			break;
		case KeyEvent.VK_UP:
			up = true;
			break;
		case KeyEvent.VK_RIGHT:
			right = true;
			break;
		case KeyEvent.VK_DOWN:
			down = true;
			break;
		default: break;
		}
	}
	
	public void miusDiection(KeyEvent e) {
		switch(e.getKeyCode()) {
		case KeyEvent.VK_LEFT:
			left = false;
			break;
		case KeyEvent.VK_UP:
			up = false;
			break;
		case KeyEvent.VK_RIGHT:
			right = false;
			break;
		case KeyEvent.VK_DOWN:
			down = false;
			break;
		default: break;
		}
	}

	public boolean isLive() {
		return live;
	}

	public void setLive(boolean live) {
		this.live = live;
	}
	
	
}
