package demo01;

import java.util.Random;

import javax.swing.ImageIcon;

public abstract class Plane extends FlyingObject{
	
	public Plane(){
	}
	/**
	 * 根據位置初始化對象數據
	 */
	public Plane(double x, double y, ImageIcon image,
			ImageIcon[] images, ImageIcon[] bom) {
		super(x, y, image, images, bom);
		// TODO Auto-generated constructor stub
	}
	/**
	 * 	利用算法實現飛機從屏幕上方出場
	 */
	public Plane(ImageIcon image,ImageIcon[] images, ImageIcon[] bom) {
		Random random = new Random();
		this.image = image;
		width = image.getIconWidth();
		height = image.getIconHeight();
		x = random.nextInt(400-(int)width);
		y = -height;
		this.images = images;
		this.bom = bom;	
	}
	
	
	public void move() {
		y += step;
	}
}
