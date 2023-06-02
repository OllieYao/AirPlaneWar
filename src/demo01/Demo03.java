package demo01;

public class Demo03 {

	public static void main(String[] args) {
		/**
		 * 測試instanceof運算符
		 * 變量 instanceof 類型:	檢測變量引用的對象是否為指定"類型"
		 */
		FlyingObject obj = new Airplane();
		boolean b = obj instanceof Airplane;	//true
		System.out.println(b);
		b = obj instanceof Bigplane;	//false
		System.out.println(b);
		
		b = obj instanceof Enemy;	//true
		System.out.println(b);
		b = obj instanceof Award;	//false
		System.out.println(b);
		
		//instanceof 經常和向下轉型搭配使用,避免異常
		if(obj instanceof Enemy) {
			Enemy enemy = (Enemy)obj;
			System.out.println(enemy.getScore());
		}
	}

}
