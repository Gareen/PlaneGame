package com.durui.util;

/**
 * 游戏工具
 * 
 */
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

/**
 * ��Ϸ�����г��õĹ����ࣨ�����ͼƬ�ȣ�
 * @author Administrator
 *
 */
public class GameUtil {
	
	private GameUtil(){
		
	} //���췽��˽�У��޷�������Ķ���������ࣻ

	public	static Image getImage(String path){
		URL u = GameUtil.class.getClassLoader().getResource(path);
		BufferedImage imag = null;
		try {
			imag = ImageIO.read(u);
		} catch (IOException e) {
			e.printStackTrace();
		} 
		return 	imag;
	}	
}
