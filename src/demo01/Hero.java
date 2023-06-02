package demo01;

import javax.swing.ImageIcon;

public class Hero extends FlyingObject{
	public Hero(double x,double y) {
		super(x,y,Images.hero[0], Images.hero,Images.bom);
	}
	
	/*
	 * 重寫move方法，空方法，目的是不動
	 * 修改超類中規定的向下飛，改成不動
	 */
	public void move() {
	}
	
	/**
	 * 將英雄機移動到鼠標位址x,y
	 * @param x 鼠標位址X
	 * @param y 鼠標位址y
	 */
	public void move(int x,int y) {
		this.x = x-width/2;
		this.y = y-height/2;
	}
	
	/**
	 * 開火方法
	 */
	public Bullet fire() {
		double x = this.x + width/2 - 5;
		double y = this.y - 20;
		Bullet bullet = new Bullet(x,y);
		return bullet;
	}

	private int doubleFire = 0;
	public void doubleFire() {
		doubleFire = 20;
	}
	
	public Bullet[] openFire() {
		if(doubleFire > 0) {
			doubleFire--;
			double x = this.x + width/2 - 5;
			double y = this.y - 20;
			Bullet b1 = new Bullet(x+15,y);
			Bullet b2 = new Bullet(x-15,y);
			return new Bullet[] {b1,b2};
		}else{
			Bullet b = fire();
			return new Bullet[] {b};
		}
		
	}
	
}
