package demo01;

import java.util.Random;

//import javax.swing.ImageIcon;

public class Airplane extends Plane implements Enemy{
	/**
	 * 飛機從屏幕上方隨機出場
	 */
	public Airplane() {
		super(Images.airplane[0], Images.airplane, Images.bom);
		step = Math.random()*4+1.5;
	}
	/**
	 * 從自訂位置出場
	 */
	public Airplane(double x,double y,double step) {
		super(x,y,Images.airplane[0],Images.airplane,Images.bom);
		this.step = step;
	}
	@Override
	public int getScore() {
		// TODO Auto-generated method stub
		return 10;
	}
}
