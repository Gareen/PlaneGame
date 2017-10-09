package com.durui.util;

import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


public class MyFrame extends Frame {
	
	public boolean enter;
	
	public void launchFrame(){
		
		setSize(Constant.GAME_WIDTH,Constant.GAME_HEIGHT);
		setLocation(100,100);
		setVisible(true);
		
		new PaintThread().start();//Æô¶¯Ïß³Ì
		
		
		addWindowListener(new WindowAdapter(){

			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}	
		});
	}
	

	
	//Ë«»º³åÏû³ýÉÁË¸
		private Image offScreenImage = null;
		public void update(Graphics g) {
			if(offScreenImage == null)
				offScreenImage = this.createImage(Constant.GAME_WIDTH,Constant.GAME_HEIGHT);
			Graphics goff = offScreenImage.getGraphics();
			
			paint(goff);
			g.drawImage(offScreenImage, 0, 0, null);
			
		}
	
	class PaintThread extends Thread{
		
		public void run(){
			while(true){
				repaint();
				try {
					Thread.sleep(50);//1s = 1000ms
				} catch (InterruptedException e) {
					e.printStackTrace();
				} 
			}
		}
	}
	
	

}
