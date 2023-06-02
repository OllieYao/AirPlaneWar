package demo01;

/**
 * 石頭,實現兩個接口: Award Enemy
 * 使用 implements 關鍵字實現接口
 * 實現接口,要實現接口中全部的方法, 就是重寫全部的抽象方法
 */
public class Stone implements Award, Enemy{

	@Override
	public int getScore() {
		return 10;
	}

	@Override
	public int getAward() {
		return DOUBLE_FIRE;
	}
	
	
}
