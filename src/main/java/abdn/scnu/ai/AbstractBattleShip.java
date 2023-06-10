package abdn.scnu.ai;

public abstract class AbstractBattleShip {
    
	protected String name;
	protected String shipOrientation;
	protected int hits;
	protected int[][] shipCoordinates;
	
	
	public abstract boolean checkAttack (int row,int column);
	
	public abstract String getName();

	public abstract int getHits();
	
	public abstract String getShipOrientation();
	
	public abstract void setHits(int numberOfHits);
	
	public abstract int[][] getShipCoordinates();
	
	public abstract void setShipCoordinates(int [][] coordinates);

}
