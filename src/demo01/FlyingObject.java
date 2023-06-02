package demo01;

import java.awt.Graphics;

import javax.swing.ImageIcon;

/*
 * 父類中定義從子類抽取的屬性何方法
 * 這種抽取方式稱為"泛化"
 */
public abstract class FlyingObject {
	
	public static final int LIVING = 1;
	public static final int DEAD = 0;
	public static final int ZOMBIE = -1;
	
	protected int state  = LIVING;
	
	protected int life = 1;
	
	protected double x,y,width,height,step;
	protected ImageIcon image;

	/*
	 * 當前對象動畫幀，如果沒有動畫幀如: 子彈、 天空， 則此屬性保持null
	 */
	protected ImageIcon[] images;
	
	/*
	 * 爆炸效果動畫幀，如果沒有保持null
	 */
	protected ImageIcon[] bom;
	
	/*
	 * 動畫幀播放計數器, %數組長度得到播放動畫幀的位置
	 */
	protected int index = 0;
//	public FlyingObject(double x,double y,
//			double width,double height){
//		this.x = x;
//		this.y = y;
//		this.width = width;
//		this.height = height;
//	}
	/**
	 * 無參數構造器，減少子類的編譯錯誤
	 */
	public FlyingObject() {		
	}
	/**
	 * 根據位置初始化
	 * @param x
	 * @param y
	 * @param image
	 * @param images
	 * @param bom
	 */
	public FlyingObject(double x,double y,
			ImageIcon image,ImageIcon[] images,ImageIcon[] bom) {
		this.x = x;
		this.y = y;
		this.image = image;
		this.images = images;
		this.bom = bom;
		width = image.getIconWidth();
		height = image.getIconHeight();
	}
	
	public abstract void move();
	
	/**
	 * 被打擊方法,每打擊一次加少命
	 * @return 如果打擊成功,減命則返回true,否則false 
	 */
	public boolean hit() {
		if(life>0) {
			life--;
			if(life == 0) {
				state =DEAD;
			}
			return true;
		}else{
			return false;
		}
	}
	
	public boolean goDead() {
		if(state==LIVING) {
			life = 0;
			state =DEAD;
			return true;
		}else {
			return false;
		}
		
	}
	
	/**
	 * 動畫幀播放方法
	 */
	private int i = 0;
	public void nextImage() {
		switch(state) {
		case LIVING:
			//沒有動畫幀時候，不播放動畫幀圖片
			if(images == null) {
				return;
			}
			image = images[(index++/30) % images.length];
			break;
		case DEAD:
			int index = i++/30;
			if(bom == null) {
				return;
			}
			if(index == bom.length) {
				state = ZOMBIE;
				return;
			}
			image = bom[index];
		}
	}
	public void paint(Graphics g) {
		nextImage();	//換動畫幀，然後在繪製
		image.paintIcon(null, g, (int)x, (int)y);
	}
	@Override
	public String toString() {
		String className = getClass().getName();
		return className + "[x=" + x + ", y=" + y + ", width=" + 
				width + ", height=" + height + "]";
	}


	/*
	 *碰撞檢測方法
	 * 1. 在父類型中定義的duang方法可以被任何子類型繼承, 所有子類都獲得了碰撞檢測功能
	 * 2. 將方法中的數據類型定義為FlyingObject, 就可以處理各種多太參數 
	 */
	public boolean duang(FlyingObject bu) {
		FlyingObject p = this;
		//計算小飛機的內切圓數據
		double r1 = Math.min(p.width, p.height)/2;
		double x1 = p.x + p.width/2;
		double y1 = p.y + p.height/2;
		//計算子彈的內切圓數據
		double r2 = Math.min(bu.width, bu.height)/2;
		double x2 = bu.x + bu.width/2;
		double y2 = bu.y + bu.height/2;
		//利用勾股定理計算圓心間距離
		double a = y2-y1;
		double b = x2-x1;
		double c = Math.sqrt(a*a + b*b);
		//如果圓心距離小於半徑和就表示兩個圓形相交 就是發生了"碰撞"
		//System.out.println(c+","+(r1+r2));
		return c < r1 + r2;
	}
	
	public boolean isLiving() {
		return state == LIVING;
	}
	
	public boolean isDead() {
		return state == DEAD;
	}
	
	public boolean isZombie() {
		return state == ZOMBIE;
	}
	
	public boolean outOfBounds() {
//		if(y < -hieght-50) {
//			return true;
//		}else if( y > 700+50) {
//			return true;
//		}else {
//			return false;
//		}
		
		return (y<-height-50 || y>700+50);
	}
}
