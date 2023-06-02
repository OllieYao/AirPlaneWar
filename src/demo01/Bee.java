
package demo01;

import javax.swing.ImageIcon;

public class Bee extends Plane implements Award{
	
	private int direction;
	
	public Bee() {
		super(Images.bee[0], Images.bee, Images.bom);
		step = Math.random()*3+1;
		direction = Math.random()> 0.5 ? 1 : -1;
	}
	public Bee(double x,double y,double step) {
		super(x,y,Images.bee[0], Images.bee, Images.bom);
		this.step = step;
		direction = Math.random()> 0.5 ? 1 : -1;
	}
	/**
	 * 重寫父類型move方法修改為斜向飛行
	 */
	public void move() {
		//調用父類型方法，複用類父類型定義的算法
		super.move();//向下飛行
		//x++;
		x+=direction;
		if(x<0) {
			direction = 1;
		}else if(x+width > 400){
			direction = -1;
		}
	}
	@Override
	public int getAward() {
		return Math.random() > 0.5 ? DOUBLE_FIRE : LIFE;
	}
}
