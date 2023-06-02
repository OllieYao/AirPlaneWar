package demo01;

import javax.swing.ImageIcon;

public class Images {
	public static ImageIcon[] airplane;
	public static ImageIcon[] bigplane;
	public static ImageIcon[] bee;
	public static ImageIcon bullet;
	public static ImageIcon[] hero;
	public static ImageIcon[] bom;
	public static ImageIcon sky;
	public static ImageIcon start;
	public static ImageIcon pause;
	public static ImageIcon gameover;
	static {
		airplane = new ImageIcon[2];
		airplane[0] = new ImageIcon("images/airplane0.png");
		airplane[1] = new ImageIcon("images/airplane1.png");
		bigplane = new ImageIcon[2];
		bigplane[0] = new ImageIcon("images/bigairplane0.png");
		bigplane[1] = new ImageIcon("images/bigairplane1.png");
		bee = new ImageIcon[2];
		bee[0] = new ImageIcon("images/bee0.png");
		bee[1] = new ImageIcon("images/bee1.png");
		bullet = new ImageIcon("images/bullet.png");
		hero = new ImageIcon[2];
		hero[0] = new ImageIcon("images/hero0.png");
		hero[1] = new ImageIcon("images/hero1.png");
		bom = new ImageIcon[4];
		bom[0] = new ImageIcon("images/bom1.png");
		bom[1] = new ImageIcon("images/bom2.png");
		bom[2] = new ImageIcon("images/bom3.png");
		bom[3] = new ImageIcon("images/bom4.png");
		sky = new ImageIcon("images/background.png");
		start = new ImageIcon("images/start.png");
		pause = new ImageIcon("images/pause.png");
		gameover = new ImageIcon("images/gameover.png");
	}
	public static void main(String[] args) {
		System.out.println(airplane[0].getImageLoadStatus());//8
		System.out.println(airplane[1].getImageLoadStatus());//8
		System.out.println(bigplane[0].getImageLoadStatus());//8
		System.out.println(bigplane[1].getImageLoadStatus());//8
		System.out.println(bee[0].getImageLoadStatus());//8
		System.out.println(bee[1].getImageLoadStatus());//8
		System.out.println(bullet.getImageLoadStatus());//8
		System.out.println(hero[0].getImageLoadStatus());//8
		System.out.println(hero[1].getImageLoadStatus());//8
		System.out.println(bom[0].getImageLoadStatus());//8
		System.out.println(bom[1].getImageLoadStatus());//8
		System.out.println(bom[2].getImageLoadStatus());//8
		System.out.println(bom[3].getImageLoadStatus());//8
		System.out.println(sky.getImageLoadStatus());//8
		System.out.println(start.getImageLoadStatus());//8
		System.out.println(pause.getImageLoadStatus());//8
		System.out.println(gameover.getImageLoadStatus());//8
	}
}
