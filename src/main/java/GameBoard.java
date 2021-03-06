import org.w3c.dom.ls.LSOutput;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class GameBoard {

    Board boardPlayer = new Board();
    Board boardComputer = new Board();


    public Board getBoardPlayer() {
        return boardPlayer;
    }

    public Board getBoardComputer() {
        return boardComputer;
    }

    public void setBoardComputer(Board boardComputer) {
        this.boardComputer = boardComputer;
    }

    public Board  createComputerBoard(Board boardComputer)  {
        int x;
        int y;
        int direction0 = 0;
        String direction = "horizontal";
        Random random = new Random();
        boardComputer.boardInit();
        x = random.nextInt(10);
        y = random.nextInt(10);
        direction0 = random.nextInt(2);

        direction = determineDirectionOfShips(direction0);


        for (int i = 0; i < 4; i++) {

            while (boardComputer.getPlayerShips().get(i) > 0) {


                boardComputer.addShip(x, y, i + 1, direction);


                x = random.nextInt(10);
                y = random.nextInt(10);
                 direction=determineDirectionOfShips(random.nextInt(2));

            }
        }


return this.boardComputer=boardComputer;

    }

 public void createUserBoard()
 {

     boardPlayer.boardInit();
     boardPlayer.addShip(0,0,4,"horizontal");
     boardPlayer.addShip(5,0,3,"horizontal");
     boardPlayer.addShip(0,2,3,"horizontal");
     boardPlayer.addShip(4,2,2,"horizontal");
     boardPlayer.addShip(7,2,2,"horizontal");
     boardPlayer.addShip(0,9,2,"horizontal");
     boardPlayer.addShip(9,0,1,"horizontal");
     boardPlayer.addShip(5,4,1,"horizontal");
     boardPlayer.addShip(3,7,1,"horizontal");
     boardPlayer.addShip(9,9,1,"horizontal");

 }


    public String determineDirectionOfShips(int direction0) {

        switch (direction0) {
            case 0:
                return "horizontal";
            case 1:
                return "vertical";
        }
        return null;
    }


}





