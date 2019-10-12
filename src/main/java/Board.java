import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.List;

public class Board {



    char[][] boardPlayer = new char[10][10];
    List<Integer> playerShips = new ArrayList<>();

    public void setPlayerShips(List<Integer> playerShips) {
        this.playerShips = playerShips;
    }

    public List<Integer> getPlayerShips() {
        return playerShips;
    }


    public char[][] getBoardPlayer() {
        return boardPlayer;
    }

    public void boardInit() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {

                boardPlayer[i][j] = ' ';

            }

        }
        playerShips.add(4);
        playerShips.add(3);
        playerShips.add(2);
        playerShips.add(1);

    }

    public boolean addShip(int positionX, int positionY, int sizeOfShip, String direction) {

        {
            if (isShipExists(sizeOfShip) && isEnoughSpaceForShip(direction, positionX, positionY, sizeOfShip)&&
                    isPossibleToPutShipOnthisPlace(direction, positionX, positionY, sizeOfShip)
                    ) {
                if (direction.equals("horizontal")) {
                    for (int i = 0; i < sizeOfShip; i++) {
                        boardPlayer[positionX + i][positionY] = 'o';


                    }

                    playerShips.set(sizeOfShip - 1, playerShips.get(sizeOfShip - 1) - 1);
                    return true;
                }

                if (direction.equals("vertical")) {
                    for (int i = 0; i < sizeOfShip; i++) {
                        boardPlayer[positionX][positionY + i] = 'o';


                    }

                    playerShips.set(sizeOfShip - 1, playerShips.get(sizeOfShip - 1) - 1);
                    return true;
                }
            }


        }
return false;

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

        if (returnVolumeOfPlaceToEndOfBoard(direction, positionX, positionY, sizeOfship) >= 0) {
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

        if(returnVolumeOfPlaceToEndOfBoard(direction,positionX,positionY,sizeOfship)==0)
        {
            indicator=1;
        }


        if (direction.equals("horizontal")) {
            for (int i = 0; i < sizeOfship + indicatorLeft + indicatorRight-indicator; i++) {
                for (int j = 0; j < 1 + indicatorUp + indicatordown; j++) {
                    if (boardPlayer[positionX - indicatorLeft + i][positionY - indicatorUp + j] == 'o') {
                        return false;
                    }
                }

            }

        }

        if (direction.equals("vertical")) {
            for (int i = 0; i < 1 + indicatorLeft + indicatorRight; i++) {
                for (int j = 0; j < sizeOfship + indicatordown + indicatorUp-indicator; j++) {
                    if (boardPlayer[positionX - indicatorLeft + i][positionY - indicatorUp + j] == 'o') {
                        return false;
                    }
                }

            }


        }

        return true;
    }


}
