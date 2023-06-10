package abdn.scnu.ai;
import java.util.*;

public class GameGrid extends AbstractGameGrid {
    public int w,h,numberOfShips;
    public GameGrid(int w,int h, int numberOfShips) {

        this.w = w;
        this.h = h;
        this.numberOfShips = numberOfShips;

        this.ships= new BattleShip[numberOfShips];
        generateShips(numberOfShips);
        initializeGrid();

        for(int i=0;i<numberOfShips;i++){
            BattleShip ship = (BattleShip) ships[i];
            placeShip(ship);
        }
    }

    public void initializeGrid(){
        gameGrid = new String[h][w];//build the new array
        for (int i = 0; i < h; i++) {//traverse each row
            for (int j = 0; j< w; j++) {//traverse each position of one row
                gameGrid[i][j] = ".";//each position is "."
            }
        }
    }
    public void generateShips(int number){
        for (int i=0;i<number;i++) {//traverse the array to add the name
            int num = i+1;//to record the order of ship
            String nameNum = Integer.toString(num);//change the type
            String nameWithNum = "Ship"+" "+nameNum;//set the form of name
            BattleShip ship = new BattleShip(nameWithNum);//create new object
            ships[i] = ship;//put the value into the array
        }
    }
    public void placeShip (BattleShip ship) {
        //set the ship coordinate in random numbers
        Random ran = new Random();
        int h1 = ran.nextInt(h-2);//random column coordinate for vertical ship
        int w2 = ran.nextInt(w);//random row coordinate for vertical ship
        int h2 = ran.nextInt(h);//random column coordinate for horizontal ship
        int w1 = ran.nextInt(w-2);//random row coordinate for horizontal ship
        ship.shipCoordinates = new int[3][2];

        if(ship.shipOrientation.equals("vertical")){//when the ship orientation is vertical
            ship.shipCoordinates[0][0]=h1;//ship's first coordinate of column coordinate
            ship.shipCoordinates[0][1]=w2;//ship's first coordinate of row coordinate
            ship.shipCoordinates[1][0]=h1+1;//ship's second coordinate of column coordinate
            ship.shipCoordinates[1][1]=w2;//ship's second coordinate of row coordinate
            ship.shipCoordinates[2][0]=h1+2;//ship's third coordinate of row coordinate
            ship.shipCoordinates[2][1]=w2;//ship's third coordinate of row coordinate
            gameGrid[h1][w2]="*";//record the first coordinate of the ship
            gameGrid[h1+1][w2]="*";//record the second coordinate of the ship
            gameGrid[h1+2][w2]="*";//record the third coordinate of the ship

        }if(ship.shipOrientation.equals("horizontal")){//when the ship orientation is horizontal
            ship.shipCoordinates[0][0]=h2;//ship's first coordinate of column coordinate
            ship.shipCoordinates[0][1]=w1;//ship's first coordinate of row coordinate
            ship.shipCoordinates[1][0]=h2;//ship's second coordinate of column coordinate
            ship.shipCoordinates[1][1]=w1+1;//ship's second coordinate of row coordinate
            ship.shipCoordinates[2][0]=h2;//ship's third coordinate of row coordinate
            ship.shipCoordinates[2][1]=w1+2;//ship's third coordinate of row coordinate
            gameGrid[h2][w1]="*";//record the first coordinate of the ship
            gameGrid[h2][w1+1]="*";//record the second coordinate of the ship
            gameGrid[h2][w1+2]="*";//record the third coordinate of the ship
        }
    }

}

