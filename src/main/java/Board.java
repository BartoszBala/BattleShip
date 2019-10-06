import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.List;

public class Board {


    char[][] boardUser = new char[10][10];
    char[][] boardPlayer = new char[10][10];
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

    public void boardInit() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                boardUser[i][j] = ' ';
                boardPlayer[i][j] = ' ';

            }

        }
        playerShips.add(4);
        playerShips.add(3);
        playerShips.add(2);
        playerShips.add(1);

    }

    public void addShip(int positionX, int positionY, int sizeOfShip, String direction) {

        {
            if (isShipExists(sizeOfShip) &&
                    isPossibleToPutShipOnthisPlace(direction, positionX, positionY, sizeOfShip)
                    && isEnoughSpaceForShip(direction, positionX, positionY, sizeOfShip)) {
                if (direction.equals("horizontal")) {
                    for (int i = 0; i < sizeOfShip; i++) {
                        boardPlayer[positionX + i][positionY] = 'o';


                    }

                    playerShips.set(sizeOfShip - 1, playerShips.get(sizeOfShip - 1) - 1);
                }

                if (direction.equals("vertical")) {
                    for (int i = 0; i < sizeOfShip; i++) {
                        boardPlayer[positionX][positionY + i] = 'o';


                    }

                    playerShips.set(sizeOfShip - 1, playerShips.get(sizeOfShip - 1) - 1);
                }
            }


        }


    }


    public boolean isShipExists(int sizeOfShip) {
        if (playerShips.get(sizeOfShip - 1) > 0)
            return true;
        return false;

    }

    public int returnVolumeOfPlaceToEndOfBoard(String direction, int positionX, int positionY, int sizeOfship) {

        switch (direction) {
            case "horizontal":
                return 10 - (positionX + sizeOfship);
            case "vertical":
                return 10 - (positionY + sizeOfship);


        }

return 0;
    }

    public boolean isEnoughSpaceForShip(String direction, int positionX, int positionY, int sizeOfship) {

        if (returnVolumeOfPlaceToEndOfBoard(direction, positionX, positionY, sizeOfship) >= sizeOfship) {
            return true;

        }


        return false;
    }

    public boolean isPossibleToPutShipOnthisPlace(String direction, int positionX, int positionY, int sizeOfship) {
        int indicatorLeft = 1;
        int indicatorRight = 1;
        int indicatorUp = 1;
        int indicatordown = 1;
        int indicator=0;


        if (positionX == 0) {
            indicatorLeft = 0;
        }
        if (positionY == 0) {
            indicatorUp = 0;
        }
        if (positionX == 9) {
            indicatorRight = 0;
        }
        if (positionY == 9) {
            indicatordown = 0;
        }


        if (direction.equals("horizontal")) {
            for (int i = 0; i < sizeOfship + indicatorLeft + indicatorRight; i++) {
                for (int j = 0; j < 1 + indicatorUp + indicatordown; j++) {
                    if (boardPlayer[positionX - indicatorLeft + i][positionY - indicatorUp + j] == 'o') {
                        return false;
                    }
                }

            }

        }

        if (direction.equals("vertical")) {
            for (int i = 0; i < 1 + indicatorLeft + indicatorRight; i++) {
                for (int j = 0; j < sizeOfship + indicatordown + indicatorUp; j++) {
                    if (boardPlayer[positionX - indicatorLeft + i][positionY - indicatorUp + j] == 'o') {
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

        System.out.println(board.getPlayerShips().get(0));

        System.out.println(board.getPlayerShips().get(0));


        board.addShip(5, 7, 3, "vertical");

//        board.addShip(5,5,1,"horizontal");

        //   board.addShip(0,0,1,"vertical");
//        System.out.println(board.getPlayerShips().get(0));
//        System.out.println(board.getBoardPlayer()[3][3]);
//
//        System.out.println(board.getBoardPlayer()[4][4]);
//
//        System.out.println(board.getBoardPlayer()[8][8]);


        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.print(board.getBoardPlayer()[j][i]);

            }
            System.out.println();
        }
    }


}
