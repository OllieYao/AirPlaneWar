package demo01;

import java.util.Random;

import javax.swing.ImageIcon;

public class Bigplane extends Plane implements Enemy{
	public Bigplane() {
		super(Images.bigplane[0], Images.bigplane, Images.bom);
		step = Math.random()*3+0.5;
		life = 5;
	}
	public Bigplane(double x,double y,double step) {
		super(x,y,Images.bigplane[0], Images.bigplane, Images.bom);
		this.step = step;
		life = 5;
	}
	@Override
	public int getScore() {
		// TODO Auto-generated method stub
		return 100;
	}
}
