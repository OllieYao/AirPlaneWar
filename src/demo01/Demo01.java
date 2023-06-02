package demo01;

public class Demo01 {

	public static void main(String[] args) {
		/**
		 * 測試向上造型
		 * 將小類型變量賦值給大類型變量
		 */
		Airplane plane = new Airplane();
		//向上造型:小飛機賦值給飛行物
		FlyingObject obj = plane;
		//接口類型可以做為向上造型的目標類型
		Enemy enemy = plane;
		System.out.println(enemy.getScore());
		//向上造型的優點:多態
		Bigplane bigplane = new Bigplane();
		enemy = bigplane;
		System.out.println(enemy.getScore());
		//上述代碼優勢:使用一個enemy變量,
		//可以管理任何實現enemy接口的對象
		//既可以管理小飛機,也可以管理大飛機。
		//如果有其他類型的對象實現類Enemy接口
		//也可以被enemy變量管理。
		
		//按照Enemy類型寫的程序將可以適用任何子類型實例!
		
	}

}
