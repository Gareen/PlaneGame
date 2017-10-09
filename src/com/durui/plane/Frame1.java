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
        jbs[0]=new JButton("小宅");
        jbs[1]=new JButton("死宅");
        jbs[2]=new JButton("右手狂魔");
        this.setLayout(new GridLayout(3,1,10,30)); 
        this.add(jbs[0]);
        jbs[0].addActionListener(this);//加入事件监听
        this.add(jbs[1]);
        jbs[1].addActionListener(this);//加入事件监听
        this.add(jbs[2]);
        jbs[2].addActionListener(this);//加入事件监听
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
            this.dispose();//点击按钮时frame1销毁,new一个frame2
            new Frame101().launchFrame();
        }
        
        if(e.getSource()==jbs[1])
        {
            this.dispose();//点击按钮时frame1销毁,new一个frame2
            new Frame102().launchFrame();
        }
        
        if(e.getSource()==jbs[2])
        {
            this.dispose();//点击按钮时frame1销毁,new一个frame2
            new Frame103().launchFrame();
        }
    }
}