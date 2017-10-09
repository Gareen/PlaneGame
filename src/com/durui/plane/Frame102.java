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



public class Frame102 extends MyFrame {
	
	Image bg = GameUtil.getImage("images/bg2.png");
	Plane p = new Plane("images/zhainan.png",500,444);	
	ArrayList bulletList = new ArrayList();//������ʱδѧ

	Date startTime;
	Date endTime;
	Explode bao;
	Date insistTime;
	public static boolean enter;
	
	public void paint(Graphics g) {
		
		g.drawImage(bg, 0, 0, null);
		p.draw(g);
		p.speed = 14;
				
		for(int i = 0;i < bulletList.size();i++) {
			Bullet b =(Bullet) bulletList.get(i);
			b.speed = 13;
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
					
			
			switch((int)p) {
			case 0:
			case 1:
			case 2:
			case 3:
				printInfo(g,"�ȼ�������",30,50,150,Color.black);
				break;
			case 4:
			case 5:
			case 6:	
			case 7:
			case 8:	
			case 9:
				
			case 10:
			case 11:		
			case 12:
				printInfo(g,"�ȼ���һ��",30,50,150,Color.YELLOW);
				break;
			case 13:	
			case 14:
			case 15:
				
			case 16:
			case 17:
			
			case 18:
			case 19:
			case 20:
			case 21:
			case 22:
			case 23:
				printInfo(g,"�ȼ���ج��",50,50,150,Color.red);
				break;
			case 24:
			case 25:
			case 26:
			case 27:
			case 28:
			case 29:
			case 30:
			case 31:
			case 32:
			case 33:
			case 34:
			case 35:
			case 36:
			case 37:
			case 38:
			case 39:
			case 40:
				printInfo(g,"��ϲ��ֵ����������ջ�",50,350,100,Color.red);
				printInfo(g,"��Ϊһ�������լ�У�",50,350,150,Color.red);
				break;			
			default:
				printInfo(g,"��ƾ��Key�� CDErssszWEKDJ",50,350,100,Color.red);
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
		for(int i = 0;i < 17;i++) {
			if(i < 8) {
				Bullet b = new Bullet("images/xin.png",200 ,200);
				bulletList.add(b);
			}
			if(i <17 && i >= 8) {
				Bullet b = new Bullet("images/xin1.png",700,200);
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