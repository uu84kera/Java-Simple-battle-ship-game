package abdn.scnu.ai;


public class PlayerGameGrid extends GameGrid{
    public PlayerGameGrid(int w,int h,int numberOfShips){
        super(w,h,numberOfShips);

    }
    public void printGrid(){
        for (int i=0;i<h;i++){//traverse gameGrid
            for(int j=0;j<w;j++){
                System.out.print(this.gameGrid[i][j]);
            }
            System.out.println();
        }
    }
}
