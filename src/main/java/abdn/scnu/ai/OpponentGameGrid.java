package abdn.scnu.ai;

public class OpponentGameGrid extends GameGrid{
    public OpponentGameGrid(int w,int h,int numberOfShips){
        super(w,h,numberOfShips);

    }
    public void printGrid() {
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (gameGrid[i][j].equals("*")) {
                    gameGrid[i][j] = ".";//to hide the ship coordinate
                }
            }
        }
        for (int i = 0; i < h; i++) {//traverse gameGrid
            for (int j = 0; j < w; j++) {
                System.out.print(gameGrid[i][j]);
            }
            System.out.println();
        }
    }
}
