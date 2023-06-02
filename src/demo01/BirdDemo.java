package demo01;

public class BirdDemo {

	public static void main(String[] args) {
		/*
		 * 繼承父類, 實現接口以後, 父類和接口都可以作為Bird的父類型
		 */
		Bird bird = new Bird();
		//bird 屬於多個類型
		FlyingObject obj = bird; //bird屬於飛行物類型
		Award award = bird; //bird屬於獎品類型
		Enemy enemy = bird; //bird屬於敵人類型
		
		obj.move();
		System.out.println(award.getAward());
		System.out.println(enemy.getScore());
	}

}
