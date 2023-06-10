package abdn.scnu.ai;
import java.util.*;

public class Game implements GameControls {
    public int w,h,numberOfShips;
    public PlayerGameGrid playerGrid;
    public OpponentGameGrid opponentGrid;
    public Game(int w,int h,int numberOfShips){
        this.w=w;
        this.h=h;
        this.numberOfShips=numberOfShips;
        this.playerGrid= new PlayerGameGrid(w,h,numberOfShips);
        this.opponentGrid=new OpponentGameGrid(w,h,numberOfShips);
    }
    public GameGrid getPlayersGrid (){return playerGrid;}

    public GameGrid getOpponentssGrid (){return opponentGrid;}

    public void exitGame (String input){
            System.out.println("Exiting game – thank you for playing");
            System.exit(0);//exit the program
        //the website I referred
        //https://blog.csdn.net/weixin_46411355/article/details/125986949?ops_request_misc=%257B%2522request%255Fid%2522%253A%2522166734891216782425674322%2522%252C%2522scm%2522%253A%252220140713.130102334.pc%255Fall.%2522%257D&request_id=166734891216782425674322&biz_id=0&utm_medium=distribute.pc_search_result.none-task-blog-2~all~first_rank_ecpm_v1~rank_v31_ecpm-4-125986949-null-null.142^v62^pc_search_tree,201^v3^add_ask,213^v1^control&utm_term=java%20exit&spm=1018.2226.3001.4187
    }

    public boolean checkVictory () {
        int v1=0;//to record the number of opponent's ships have been hit
        int v2=0;//to record the number of player's ships have been hit
        for (int i = 0; i < opponentGrid.numberOfShips; i++) {//traverse the opponent's ships
            if (opponentGrid.ships[i].getHits()==3){//if the hits is equal to 3, then the ship is hit
                v1+=1;//record
            }
        }
        for (int j=0;j< playerGrid.numberOfShips;j++){//traverse the player's ships
            if(playerGrid.ships[j].getHits()==3){//if the hits is equal to 3, then the ship is hit
                v2 +=1;//record
            }
        }
        if(v1==opponentGrid.numberOfShips){//if the number of ships hit by player is equal to the number of opponent's ships
            System.out.println("You have won!");//win
            return true;
        }if(v2==playerGrid.numberOfShips){//if the number of ships hit by opponent is equal to the number of player's ships
            System.out.println("You have lost!");//lose
            return true;
        }else {return false;}
    }

    public void playRound (String input){

        String[] s=input.split(",");//split the string
        String r=s[0];//row coordinate
        String c=s[1];//column coordinate
        int row=Integer.parseInt(r);//transform the string to integer
        int column=Integer.parseInt(c);
        System.out.println("Player is attacking");

        for(int i=0;i<opponentGrid.numberOfShips;i++){//traverse the ships of opponent

            if(opponentGrid.ships[i].checkAttack(row,column)){//to check whether it is attacked
                opponentGrid.gameGrid[row][column]="X";//if attacked then record as "X"
                System.out.println("HIT "+opponentGrid.ships[i].name+"!!!");//show the hit information

            }else{//not attack
                if(opponentGrid.gameGrid[row][column].equals("X")){//to avoid changing the remark
                    System.out.println("MISS!!!");//show the miss information
                }else{
                    opponentGrid.gameGrid[row][column]="%";//if not attacked then record as "%"
                    System.out.println("MISS!!!");//show the miss information
                }
            }
        }

        //simulate an attack on player's grid
        Random ran=new Random();
        int r1=ran.nextInt(h);
        int c1=ran.nextInt(w);
        System.out.println("Opponent is attacking");

        for(int j=0;j< playerGrid.numberOfShips;j++){//traverse the player's ships

            if(playerGrid.ships[j].checkAttack(r1,c1)){//to check whether it is attacked
                playerGrid.gameGrid[r1][c1]="X";//if attacked then record as "X"
                System.out.println("HIT "+playerGrid.ships[j].name+"!!!");//show the hit information

            }else{//not attack
                if(playerGrid.gameGrid[r1][c1].equals("X")){
                    System.out.println("MISS!!!");//show the miss information
                }else{
                    playerGrid.gameGrid[r1][c1]="%";//if not attacked then record as "%"
                    System.out.println("MISS!!!");//show the miss information
                }
            }
        }

        System.out.println("Player's grid");
        playerGrid.printGrid();
        System.out.println("Opponent's grid");
        opponentGrid.printGrid();
    }
}
