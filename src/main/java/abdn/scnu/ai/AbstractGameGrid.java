package abdn.scnu.ai;

public abstract class AbstractGameGrid{
	public String [][] gameGrid;
	public AbstractBattleShip [] ships;
		
    //populate the grid with "." characters
	public abstract void initializeGrid();

	//this should generate ships for both player and the opponent
	public abstract void generateShips(int numberOfShips);

	//this should place the ship on the grid using "*" symbol
	public abstract void placeShip (BattleShip ship) ;
}
