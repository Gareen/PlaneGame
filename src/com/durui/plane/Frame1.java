package com.durui.plane;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

import com.durui.util.GameUtil;
public class Frame1 extends JFrame implements ActionListener{
    /**
     * @param args
     */

	JButton jbs[]=new JButton[3];
    
    public Frame1()
    {	
    	
        this.setSize(300, 200);
        this.setLocation(300, 400);
        jbs[0]=new JButton("Сլ");
        jbs[1]=new JButton("��լ");
        jbs[2]=new JButton("���ֿ�ħ");
        this.setLayout(new GridLayout(3,1,10,30)); 
        this.add(jbs[0]);
        jbs[0].addActionListener(this);//�����¼�����
        this.add(jbs[1]);
        jbs[1].addActionListener(this);//�����¼�����
        this.add(jbs[2]);
        jbs[2].addActionListener(this);//�����¼�����
        this.setVisible(true);        
    }
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
    	   new  Frame101();
           Frame1 frame=new Frame1();
           new  Frame102();
    	   new  Frame103();
           
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        if(e.getSource()==jbs[0])
        {
            this.dispose();//�����ťʱframe1����,newһ��frame2
            new Frame101().launchFrame();
        }
        
        if(e.getSource()==jbs[1])
        {
            this.dispose();//�����ťʱframe1����,newһ��frame2
            new Frame102().launchFrame();
        }
        
        if(e.getSource()==jbs[2])
        {
            this.dispose();//�����ťʱframe1����,newһ��frame2
            new Frame103().launchFrame();
        }
    }
}