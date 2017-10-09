package com.durui.util;


import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

/**
 * 游戏开发中常用的工具类（如加载图片等）
 * @author Administrator
 *
 */
public class GameUtil {
	
	private GameUtil(){
		
	} //构造方法私有，无法创建类的对象或者子类；

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
