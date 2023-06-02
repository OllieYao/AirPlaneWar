package demo01;

/**
 * Bird類繼承一個父類FlyingObject, 同時實現類兩個接口
 * 
 * 先繼承父類, 再實現街口, 順序不能變
 */
public class Bird extends FlyingObject implements Award,Enemy{

	@Override
	public int getScore() {
		// TODO Auto-generated method stub
		return 100;
	}

	@Override
	public int getAward() {
		// TODO Auto-generated method stub
		return LIFE;
	}

	@Override
	public void move() {
		y+=step;
	}
	
}
