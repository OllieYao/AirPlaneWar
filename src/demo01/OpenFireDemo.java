package demo01;

public class OpenFireDemo {

	public static void main(String[] args) {
		/*
		 * 測試hero自動支持單槍和雙槍
		 */
		Hero hero = new Hero(200,500);
		//單槍測試
		Bullet[] bullets = hero.openFire();
		System.out.println(bullets.length);
		System.out.println(bullets[0]);
		//測試雙槍
		hero.doubleFire();
		for(int i = 0; i<20; i++) {
			bullets = hero.openFire();
			System.out.println(bullets.length);
			System.out.println(bullets[0]);
			System.out.println(bullets[1]);
		}
		//雙槍打完變成單槍
		bullets = hero.openFire();
		System.out.println(bullets.length);
		System.out.println(bullets[0]);
	}

}
