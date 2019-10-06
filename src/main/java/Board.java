import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.List;

public class Board {


    char[][] boardUser =new char[10][10];
    char[][] boardPlayer =new char[10][10];
List<Integer> playerShips = new ArrayList<>();


    public List<Integer> getPlayerShips() {
        return playerShips;
    }

    public char[][] getBoardUser() {
        return boardUser;
    }

    public char[][] getBoardPlayer() {
        return boardPlayer;
    }

    public void boardInit()

    {
        for(int i=0;i<10;i++)
        {for(int j=0;j<10;j++)
        {
        boardUser[i][j]=' ';
boardPlayer[i][j]=' ';

        }

        }
        playerShips.add(4);
        playerShips.add(3);
        playerShips.add(2);
        playerShips.add(1);

    }

    public void addShip(int positionX, int positionY, int sizeOfShip, String direction)

    {

     {if(isShipExists(sizeOfShip)&&isPossibleToPutShipOnthisPlace(direction,positionX,positionY,sizeOfShip))
     {boardPlayer[positionX][positionY]='o';
         playerShips.set(sizeOfShip-1,playerShips.get(sizeOfShip-1)-1);}

     }




    }

    public boolean isShipExists(int sizeOfShip)

    {
        if(playerShips.get(sizeOfShip-1)>0)
        return true;
        return false;

    }

    public boolean isPossibleToPutShipOnthisPlace(String direction, int positionX, int positionY, int sizeOfship)
    {
        int indicator=1;

        if(positionX==0||positionY==0||positionX==9||positionY==9)
        {indicator=0;}


        if(direction.equals("horizontal"))

        {
            for(int i=0;i<sizeOfship+1+indicator;i++)
            {     for(int j=0;j<3;j++)
            {
                if(boardPlayer[positionX-indicator+i][positionY-indicator+j]=='o')
                {
                return false;
                }
            }

            }

        }

        if(direction.equals("vertical"))
        {for(int i=0;i<3;i++)
        {     for(int j=0;j<sizeOfship+1+indicator;j++)
        {
            if(boardPlayer[positionX-indicator+i][positionY-indicator+j]=='o')
            {
                return false;
            }
        }

        }



        }


        return true;
    }


    public static void main(String[] args) {

        Board board = new Board();
        board.boardInit();

        System.out.println(board.getBoardPlayer()[9][9]);
        System.out.println(board.getPlayerShips().get(0));
        board.addShip(3,3,1,"vertical");
        board.addShip(5,3,1,"vertical");
        System.out.println(board.getPlayerShips().get(0));
        board.addShip(4,4,1,"vertical");
        System.out.println(board.getPlayerShips().get(0));
        board.addShip(7,7,1,"vertical");
        board.addShip(8,8,1,"vertical");
        board.addShip(0,0,1,"vertical");
     //   board.addShip(0,0,1,"vertical");
//        System.out.println(board.getPlayerShips().get(0));
//        System.out.println(board.getBoardPlayer()[3][3]);
//
//        System.out.println(board.getBoardPlayer()[4][4]);
//
//        System.out.println(board.getBoardPlayer()[8][8]);


        for(int i=0;i<10;i++)
        {
            for(int j=0;j<10;j++)

            {
                System.out.print(board.getBoardPlayer()[j][i]);

            }
            System.out.println();
        }
    }



}
