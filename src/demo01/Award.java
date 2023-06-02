package demo01;
/*
 * 獎品
 */
public interface Award {
	/**
	 * 雙槍
	 */
	int DOUBLE_FIRE = 1;
	/**
	 * 命
	 */
	int LIFE = 2;
	/**
	 * 獲取將品
	 * @return 返回值是DOUBLE_FIRE和LIFE之一
	 */
	int getAward();
}
