package abdn.scnu.ai;
import java.util.*;

class BattleShip extends AbstractBattleShip {

    BattleShip(String name) {
        this.name = name;

        Random r = new Random();
        int n = r.nextInt(10);//select random number in the range of (0,10)
        int[] array = {0, 2, 4, 6, 8};
        int l = array.length;
        int start = 0, end, middle;
        end = l;
        middle = (start + end) / 2;
        int count = 0;
        while (n != array[middle]) {
            if (n > array[middle]) {
                start = middle;
            } else {
                end = middle;
            }
            middle = (start + end) / 2;
            count++;
            if (count > array.length / 2) {
                break;
            }
        }
        if (count > array.length / 2) {//if the number is not in range, it would be vertical
            this.shipOrientation = "vertical";
        } else {//if the number is in range, it would be horizontal
            this.shipOrientation = "horizontal";
        }
    }
    public String getName(){
        return name;
    }
    public String getShipOrientation(){return shipOrientation;}
    public void setHits(int numberOfHits){
        this.hits = numberOfHits;
    }
    public int getHits(){
        return hits;
    }
    public void setShipCoordinates(int [][] coordinates){
        this.shipCoordinates = coordinates;
    }
    public int[][] getShipCoordinates(){
        return shipCoordinates;
    }
    public boolean checkAttack (int row,int column) {
        for (int i = 0; i < shipCoordinates.length; i++) {//traverse the array
            if (shipCoordinates[i][0] == row && shipCoordinates[i][1] == column) {//check the row coordinate and column coordinate
                if(getHits() >= 3) {//if the hits >=3
                    return false;}
                if(getHits()<3) {//if the hits<3
                    shipCoordinates[i][0] = -1;//record the ship coordinate in case that it would attack again
                    shipCoordinates[i][1] = -1;//record the ship coordinate in case that it would attack again
                    hits += 1;//to add a hit
                    return true;}
            }
        }
        return false;
    }

}