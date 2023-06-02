package demo01;

import java.awt.Graphics;

import javax.swing.ImageIcon;

public class Sky extends FlyingObject{
	private double y0;
	public Sky() {
		super(0,0,Images.sky,null,null);
		step = 0.8;
		y0 = -height;
	}
	public void move() {
		y += step;
		y0 += step;
		
		if(y>=height) {
			System.out.println("第一個照片返回: y="+y);
			y = -height;
			System.out.println("y=" + y +" y0="+y0+" width="+width+" height="+height);
		}
		if(y0>=height) {
			System.out.println("第二個照片返回: y0="+y0);
			y0 = -height;
			System.out.println("y=" + y +" y0="+y0+" width="+width+" height="+height);
		}
	}
	public void paint(Graphics g) {
		image.paintIcon(null, g, (int)x, (int)y);
		image.paintIcon(null, g, (int)x, (int)y0);
	}
}
