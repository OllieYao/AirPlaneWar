package demo01;

import javax.swing.ImageIcon;

public class Bullet extends FlyingObject{
	public Bullet(double x,double y) {
		super(x,y,Images.bullet, null, null);
		this.step = 4;
	}
		
	/*
	 * 重寫繼承與超類的 move方法，作用就是收改了超類move的行為
	 * 超類是向下移動，修改為向上移動。
	 */
	public void move() {
		y -= step;
	}
}
