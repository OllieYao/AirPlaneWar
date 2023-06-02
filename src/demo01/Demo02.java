package demo01;

public class Demo02 {

	public static void main(String[] args) {
		
		/*
		 * 測試 向下轉型
		 * 轉型有風,使用需謹慎
		 */
		FlyingObject obj = new Airplane();	//向上造型,小飛機賦值給FlyingObject
		//向下轉型:大類型FlyingObject賦值給Airplane
		Airplane a1 = (Airplane)obj;
		//轉型風險
		Bigplane b1 = (Bigplane)obj;
	}

}
