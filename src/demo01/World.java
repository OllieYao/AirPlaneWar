
package demo01;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Arrays;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class World extends JPanel{
	/*
	 * 添加飛機大戰世界中的物體
	 */
	//private Airplane[] airplanes;
	//private Bigplane[] bigplanes;
	private FlyingObject[] planes;	//所有的可以被打掉的敵機
	private Bullet[] bullets;
	private Sky sky;
	private Hero hero;
	
	/**
	 * 英雄的生命值
	 */
	private int life = 3;
	/*
	 * 利用構造器初始化世界中每個物體
	 */
	public World() {

//		airplanes = new Airplane[2];
//		airplanes[0] = new Airplane(10,10,1.5);
//		airplanes[1] = new Airplane(10,100,1.5);
//		
//		bigplanes = new Bigplane[2];
//		bigplanes[0] = new Bigplane(100,20,2);
//		bigplanes[1] = new Bigplane(100,220,2);

		//多態數組，數組中可以存儲多個類型對象，
		//好處是:	一個數組統一管理各種對象!
		planes = new FlyingObject[10];//創建數組對象!
		planes[0] = new Airplane(10,10,1.5);
		planes[1] = new Airplane(10,100,1.5);
		planes[2] = new Bigplane(100,20,2);
		planes[3] = new Bigplane(100,220,2);
		planes[4] = new Bee(200,200,1.5);
		planes[5] = new Bee(200,280,1.5);
		planes[6] = new Bee();
		planes[7] = new Airplane();
		planes[8] = new Airplane();
		planes[9] = new Bigplane();
		
		bullets = new Bullet[6];
		bullets[0] = new Bullet(200,400);
		bullets[1] = new Bullet(200,350);
		bullets[2] = new Bullet(200,300);
		bullets[3] = new Bullet(200,250);
		bullets[4] = new Bullet(200,200);
		bullets[5] = new Bullet(200,150);
		
		sky = new Sky();
		hero = new Hero(200,500);
	}
	
	public void paint(Graphics g) {
		sky.paint(g);
		hero.paint(g);
		
		for(int i = 0;i<bullets.length;i++) {
			//i=0 1 2 3 4
			bullets[i].paint(g);
		}
		//調用每個飛機的多態方法，實現多態的繪製
		for(int i = 0;i<planes.length;i++) {
			planes[i].paint(g);
		}
		g.setColor(Color.white);
		g.drawString("SCORE:" + score, 20, 40);
		g.drawString("LIFE:" + life, 20, 60);
	}
	
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		World world = new World();
		frame.add(world);
		frame.setSize(400,700);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		//調用action方法啟動定時器
		world.action();
	}
	

	private int index = 0; //計數器
	//index = 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16....
	//        *       *       *          *           *
	//        index % 4 == 0
	/*
	 * 創建一個飛機，進入到場地中 
	 */
	public void createPlane() {
		if(index % 16 == 0) {
			Random random = new Random();
			int n = random.nextInt(10);	//0~9
			Plane plane;
			switch(n) {
			case 7:
			case 8:
				plane = new Bigplane();
				break;
			case 9:
				plane = new Bee();
				break;
			default:
				plane = new Airplane();
			}
			//數組擴容
			planes = Arrays.copyOf(planes, planes.length+1);
			//將新飛機添加到新數組到最後位置
			planes[planes.length-1] = plane;
		}
	}
	/*
	 * 添加內部類，實現定時計畫任務
	 * 為何使用內部類實現定時任務
	 * 1. 隱藏定時任務到World類中
	 * 2. 可以訪問外部類中的數據，飛機、子彈等
	 */
	private class LoopTask extends TimerTask{
		public void run() {
			index++;
			fireAction();			
			createPlane();
			objectMove();
			hitDetection();
			clean();
			sky.move();
			//調用重寫繪製方法，這個方法會自動執行paint
			repaint();
		}

	}
	private void objectMove() {
		//執行飛機移動方法: 是多態的移動方法，每個飛機都不同
		for(int i=0;i<planes.length;i++) {
			if(planes[i].isLiving()) {
				planes[i].move();
			}
		}			
		for(int i=0;i<bullets.length;i++) {
			if(bullets[i].isLiving()) {
				bullets[i].move(); 
			}
		}
	}

	public void action() {
		Timer timer = new Timer();
		LoopTask task = new LoopTask();
		timer.schedule(task, 1000,1000/100);
		
		//軟件啟動後立即掛載鼠標事件
		//MouseAction action = new MouseAction();
		//將鼠標事件處理對象(鼠標監聽器對象)掛載到當前面板上
		//Motion 動
		//this.addMouseMotionListener(action);
		
		//Adapter 適配器
		
		this.addMouseMotionListener(new MouseAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				//鼠標事件發生時後，e對象中包含著鼠標相關的數據
				//如:x y等
				int x = e.getX();	//獲取發生鼠標事件時候，鼠標x座標
				int y = e.getY();	//獲取發生鼠標事件時候，鼠標y座標			
				//System.out.println("鼠標移動OK"+x+","+y);
				hero.move(x,y);
			}
		});
	}

	private int score = 0;
	/**
	 * 分數統計方法
	 * @param obj 是被統計對象
	 */
	public void scores(FlyingObject obj) {
		if(obj.isDead()) {
			if(obj instanceof Enemy) {
				Enemy enemy = (Enemy) obj;
				score += enemy.getScore();
				System.out.println("score:" + score);
			}
			//處理獎勵規則
			if(obj instanceof Award) {
				Award award = (Award)obj;
				int type = award.getAward();
				if(type == Award.DOUBLE_FIRE) {
					hero.doubleFire();
				}else if(type == Award.LIFE){
					life++;
				}
			}
		}
	}
	
	public void hitDetection() {
		//拿到每一個子彈
		for(int i=0; i<bullets.length; i++) {
			if(!bullets[i].isLiving()) {
				continue;
			}
			for(int j=0; j<planes.length; j++) {
				if(!planes[j].isLiving()) {
					continue;
				}
				if(planes[j].duang(bullets[i])) {
					bullets[i].goDead();
					planes[j].hit();
					scores(planes[j]);
				}
			}
		}
	}
	
	private void fireAction() {
		if(index % 15 == 0) {
			//在定時任務中執行英雄機開火方法
			//Bullet bullet = hero.fire();
			Bullet[] bubu = hero.openFire();
			int len = bullets.length;
			//子彈數組擴容
			Bullet[] arr = Arrays.copyOf(bullets, len + bubu.length);
			//將子彈添加到新數組到最後位置
			//bullets[bullets.length-1] = bullet;
			System.arraycopy(bubu, 0, arr, len, bubu.length);
			bullets = arr;
		}
	}

	public void clean() {
		FlyingObject[] living = new FlyingObject[planes.length];
		int index = 0;
		for(int i = 0;i<planes.length;i++) {
			if(planes[i].isZombie() || planes[i].outOfBounds()) {
				continue;
			}
			living[index++] = planes[i];
		}
		planes = Arrays.copyOf(living, index);
		
		Bullet[] arr = new Bullet[bullets.length];
		index = 0;
		for(int i=0;i<bullets.length;i++) {
			if(bullets[i].isDead() || bullets[i].outOfBounds() ) {
				continue;
			}
			arr[index++] = bullets[i]; 
		}
		bullets = Arrays.copyOf(arr, index);
//		System.out.println(planes.length + "," + bullets.length);
	}
	
	public void testClane() {
		System.out.println(planes.length);
		planes[0].state = FlyingObject.ZOMBIE;
		planes[3].state = FlyingObject.ZOMBIE;
		clean();
		System.out.println(planes.length);
	}
	
}
