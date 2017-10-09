package com.durui.plane;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Date;

import com.durui.util.Constant;
import com.durui.util.GameUtil;
import com.durui.util.MyFrame;



public class PlaneGameFrame extends MyFrame {
	
	Image bg = GameUtil.getImage("images/bg2.png");
	Plane p = new Plane("images/zhainan.png",50,50);	
	ArrayList bulletList = new ArrayList();//������ʱδѧ

	Date startTime;
	Date endTime;
	Explode bao;
	Date insistTime;
	public static boolean enter;
	
	public void paint(Graphics g) {
		
		g.drawImage(bg, 0, 0, null);
		p.draw(g);
				
		for(int i = 0;i < bulletList.size();i++) {
			Bullet b =(Bullet) bulletList.get(i);
			b.drawImage(g);
			//���ɻ�����ײ
			boolean peng = b.getRect().intersects(p.getRect());
			if(peng) {
				p.x += 1000;
				p.setLive(false);//�ɻ�����
				if(bao == null) {
					endTime = new Date();
					bao = new Explode(p.x,p.y);
				}
		//		bao.draw(g);
				break;		
			}
		}
				
		if(!p.isLive()) {
			printInfo(g,"GAME OVER",50,50,100,Color.black);
			double period = (endTime.getTime() - startTime.getTime())/1000.0;
			printInfo(g,"ʱ�䣺"+period+"��",30,50,200,Color.red);
			long p = (endTime.getTime() - startTime.getTime())/1000;
					
			switch((int)p/10) {
			case 0:
				printInfo(g,"�ȼ�������",30,50,150,Color.black);
				break;
			case 1:
				printInfo(g,"�ȼ���һ��",30,350,100,Color.YELLOW);
				break;
			case 2:
				printInfo(g,"�ȼ���ج��",50,350,100,Color.red);
				break;
			case 3:
				printInfo(g,"��ϲ��ֵ����������ջ�",50,350,100,Color.red);
				printInfo(g,"��Ϊһ�������լ�У�",50,350,150,Color.red);
				break;
			default:
				printInfo(g,"��ƾ��Key�� CDErsWEKDJ",50,350,100,Color.red);
				printInfo(g,"��������ȡ��Ʒ��",50,350,160,Color.red);
				break;
	//		default:
	//		printInfo(g,"��ϲͨ�أ����ס������ַ��www.luluhei.me",50,350,300,Color.red);
			}
		}
	}
			
	
	/**
	 * �ڴ����ϴ�ӡ��Ϣ
	 * @param g
	 * @param str
	 * @param size
	 */
	public static void printInfo(Graphics g,String str,int size,int x,int y,Color color) {
		Color c = g.getColor();
		g.setColor(color);
		Font f = new Font("����",Font.BOLD,size);
		g.setFont(f);
		g.drawString(str, x, y);
		g.setColor(c);
	}
	
	
	
	public void launchFrame() {
		
		super.launchFrame();
		addKeyListener(new KeyMonitor());
		
		//����һ���ӵ�
		for(int i = 0;i < 30;i++) {
			if(i < 9) {
				Bullet b = new Bullet("images/xin.png",Constant.GAME_WIDTH/2 ,Constant.GAME_HEIGHT/2);
				bulletList.add(b);
			}
			if(i <18 && i >= 9) {
				Bullet b = new Bullet("images/xin1.png",222,444);
				bulletList.add(b);
			}
			if(i <27 && i >= 18) {
				Bullet b = new Bullet("images/xin1.png",888,444);
				bulletList.add(b);
			}
		}
		startTime = new Date();
	}

	//����Ϊ�ڲ��࣬���Է����ʹ���ⲿ�������
	class KeyMonitor extends KeyAdapter{

		@Override
		public void keyPressed(KeyEvent e) {
			System.out.println("���£�" + e.getKeyCode());	
			p.addDirection(e);
		}

		
		
		@Override
		public void keyReleased(KeyEvent e) {
			System.out.println("�ͷţ�" + e.getKeyCode());
			p.miusDiection(e);
		}	
	}
}
