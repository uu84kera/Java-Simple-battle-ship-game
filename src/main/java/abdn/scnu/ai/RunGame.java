package abdn.scnu.ai;
import java.util.*;

public class RunGame {
    public static void main(String[] args){
        Scanner sca = new Scanner(System.in);
        String width=args[0];
        String height=args[1];
        String numberOfShips=args[2];
        int w=Integer.parseInt(width);
        int h=Integer.parseInt(height);
        int num=Integer.parseInt(numberOfShips);

        Game game=new Game(w,h,num);//create a single instance of Game class

        System.out.println("Play's grid");
        game.playerGrid.printGrid();
        System.out.println("Opponent's grid");
        game.opponentGrid.printGrid();

        boolean start=true;
        while(start){//start playing until exit or gain the result of game
            System.out.println("Please enter the position you wish to attack:");
            String coordinate=sca.next();

            if(coordinate.contains("exit")){//if user input exit
                game.exitGame(coordinate);
                start=false;//then exit the program
            }
            else{try{
                game.playRound(coordinate);//start the game
                if(game.checkVictory()){//check whether play win
                    start=false;//if it comes the result, then stop the game
                }}
            catch(Exception e){//it the input is not in correct form, then throw exception
                System.out.println("Incorrect input");
            }
            }
        }
    }
}
