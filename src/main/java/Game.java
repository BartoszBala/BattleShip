import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Game {

    GameBoard gameBoard = new GameBoard();
    String currentPlayer = "computer";
    int playerShips = 20;
    int computerShips = 20;
    Board boardComputerWhichSeeUser = new Board();


    public void createGame() {
        gameBoard.createComputerBoard();
        gameBoard.createUserBoard();

    }


    public char shot(int x, int y, char[][] board) {
        char xchar = ' ';
        if (board[x][y] == 'o') {
            board[x][y] = 'x';
            xchar = 'x';
            if (currentPlayer.equals("computer")) {
                playerShips = playerShips - 1;

            } else {
                computerShips = computerShips - 1;

            }

        } else {
            if (board[x][y] == ' '||board[x][y]=='*') {
                board[x][y] = '*';
                xchar = '*';
            }
            if (currentPlayer.equals("computer"))
                currentPlayer = "user";
            else {
                currentPlayer = "computer";
            }

        }


        return xchar;
    }

    public boolean isWin() {
        if (computerShips == 0 || playerShips == 0) {
            return true;
        }

        return false;
    }

    public boolean isSunk(int x, int y, char[][] playerboard) {
        boolean isSunk = true;
        int sizeOfShip = 1;
        int numberOfSunkPole = 1;
        int numberOfSolidPole = 0;
        int i = 1;

        while ((x - i) != -1 && (playerboard[x - i][y] == 'o' || playerboard[x - i][y] == 'x')) {
            sizeOfShip = sizeOfShip + 1;
            if (playerboard[x - i][y] == 'o') {
                numberOfSolidPole = numberOfSolidPole + 1;
            } else {
                numberOfSunkPole = numberOfSunkPole + 1;
            }
            i++;
        }
        i = 1;
        while ((x + i) != 10 && (playerboard[x + i][y] == 'o' || playerboard[x + i][y] == 'x')) {
            sizeOfShip = sizeOfShip + 1;
            if (playerboard[x + i][y] == 'o') {
                numberOfSolidPole = numberOfSolidPole + 1;
            } else {
                numberOfSunkPole = numberOfSunkPole + 1;
            }
            i++;
        }
        if (numberOfSolidPole > 0)
            isSunk = false;

        numberOfSolidPole = 0;
        i = 1;
        sizeOfShip = 1;
        numberOfSunkPole = 1;

        while ((y - i) != -1 && (playerboard[x][y - i] == 'o' || playerboard[x][y - i] == 'x')) {
            sizeOfShip = sizeOfShip + 1;
            if (playerboard[x][y - i] == 'o') {
                numberOfSolidPole = numberOfSolidPole + 1;
            } else {
                numberOfSunkPole = numberOfSunkPole + 1;
            }
            i++;
        }
        i = 1;

        while ((y + i) != 10 && (playerboard[x][y + i] == 'o' || playerboard[x][y + i] == 'x')) {
            sizeOfShip = sizeOfShip + 1;
            if (playerboard[x][y + i] == 'o') {
                numberOfSolidPole = numberOfSolidPole + 1;
            } else {
                numberOfSunkPole = numberOfSunkPole + 1;
            }
            i++;
        }
        if (numberOfSolidPole > 0)
            isSunk = false;


        System.out.println("TRAFIONY ZATOPIONY");
        return isSunk;
    }

    public int[] returnPositionOfSunkShip(char[][] playerBoard, int positionX, int positionY) {
        int[] positionOfSunkShip = new int[4];
        int direction = 0;
        int x;
        int y;
        int size = 1;
        int i = 1;
        x = positionX;
        y = positionY;
        while ((positionX - i) != -1 && playerBoard[positionX - i][positionY] == 'x') {
            x = x - 1;

            i++;
            size++;
        }
        i = 1;
        while ((positionX + i) != 10 && playerBoard[positionX + i][positionY] == 'x') {

            i++;
            size++;
        }
        if (size > 1) {
            positionOfSunkShip[0] = direction;
            positionOfSunkShip[1] = size;
            positionOfSunkShip[2] = x;
            positionOfSunkShip[3] = y;
        } else {
            x = positionX;
            y = positionY;
            i = 1;
            size = 1;
            while ((positionY - i) != -1 && playerBoard[positionX][positionY - i] == 'x') {
                y = y - 1;

                i++;
                size++;
            }
            i = 1;
            while ((positionY + i) != 10 && playerBoard[positionX][positionY + i] == 'x') {

                i++;
                size++;
            }

            direction = 1;
            positionOfSunkShip[0] = direction;
            positionOfSunkShip[1] = size;
            positionOfSunkShip[2] = x;
            positionOfSunkShip[3] = y;
        }


        return positionOfSunkShip;

    }

    public void ifShipIsSunkMarkPoleWhereThereAreNotOtherShip(char[][] playerboard, int[] positionOfSunkShip) {
        if (positionOfSunkShip[0] == 0) {
            for (int i = 0; i < positionOfSunkShip[1] + 2; i++) {
                if (positionOfSunkShip[2] - 1 + i != -1 && positionOfSunkShip[2] - 1 + i != 10) {
                    {
                        if ((positionOfSunkShip[3] - 1) != -1)
                            playerboard[positionOfSunkShip[2] - 1 + i][positionOfSunkShip[3] - 1] = '*';
                        if ((positionOfSunkShip[3] + 1) != 10)
                            playerboard[positionOfSunkShip[2] - 1 + i][positionOfSunkShip[3] + 1] = '*';

                        if (playerboard[positionOfSunkShip[2] - 1 + i][positionOfSunkShip[3]] != 'x') {
                            playerboard[positionOfSunkShip[2] - 1 + i][positionOfSunkShip[3]] = '*';
                        }


                    }

                }
            }
        }

        else
        {


            for (int i = 0; i < positionOfSunkShip[1] + 2; i++) {
                if (positionOfSunkShip[3] - 1 + i != -1 && positionOfSunkShip[3] - 1 + i != 10) {
                    {
                        if ((positionOfSunkShip[2] - 1) != -1)
                            playerboard[positionOfSunkShip[2] - 1][positionOfSunkShip[3] - 1+i] = '*';
                        if ((positionOfSunkShip[2] + 1) != 10)
                            playerboard[positionOfSunkShip[2] +1][positionOfSunkShip[3] - 1+i] = '*';

                        if (playerboard[positionOfSunkShip[2]][positionOfSunkShip[3]-1+i] != 'x') {
                            playerboard[positionOfSunkShip[2]][positionOfSunkShip[3]-1+i] = '*';
                        }


                    }

                }
            }





                }



            }



        public void printBoardUser () {

            System.out.println("*********USER BOARD*************");
            System.out.println("   1 2 3 4 5 6 7 8 9 10");
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 10; j++) {
                    if (j == 0) {
                        System.out.printf("%2d|", (i + 1));
                    }
                    System.out.print(gameBoard.getBoardPlayer().getBoardPlayer()[j][i] + "|");


                }
                System.out.println();
            }
        }

        public void printBoardComputer () {

            System.out.println("*********COMPUTER**********");
            System.out.println("   1 2 3 4 5 6 7 8 9 10");
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 10; j++) {
                    if (j == 0) {
                        System.out.printf("%2d|", (i + 1));
                    }
                    System.out.print(gameBoard.getBoardComputer().getBoardPlayer()[j][i] + "|");


                }
                System.out.println();
            }


        }

        public void printComputerBoardWhichSeeUser ( int xPosition, int yPosition, char x){
            if (x != ' ') {
                boardComputerWhichSeeUser.getBoardPlayer()[xPosition][yPosition] = x;
            }

            

            System.out.println("*********COMPUTER**********");
            System.out.println("   1 2 3 4 5 6 7 8 9 10");
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 10; j++) {
                    if (j == 0) {
                        System.out.printf("%2d|", (i + 1));
                    }
                    System.out.print(boardComputerWhichSeeUser.getBoardPlayer()[j][i] + "|");


                }
                System.out.println();
            }


        }


        public static void main (String[]args){
            Game game = new Game();
            SmartComputer smartComputer = new SmartComputer();
            game.createGame();
            Scanner scanner = new Scanner(System.in);
            Random random = new Random();
            int x = -1;
            int y = -1;
            char shot = ' ';
            game.boardComputerWhichSeeUser.boardInit();
            while (!game.isWin()) {
                x = -1;
                y = -1;


                if (game.currentPlayer.equals("computer")) {
                    x = random.nextInt(10);
                    y = random.nextInt(10);
                    shot = game.shot(x, y, game.gameBoard.boardPlayer.boardPlayer);

                    smartComputer.updateBoardAfterShot(x, y, shot);

                    game.printBoardUser();
                   // game.printBoardComputer();

                   // game.printComputerBoardWhichSeeUser(x,y,shot);

                } else {
                    while (x < 0 || x >= 10) {
                        System.out.println("podaj wspolrzedna x");
                        x = scanner.nextInt() - 1;
                    }
                    while (y < 0 || y >= 10) {
                        System.out.println("podaj wspolrzedna y");
                        y = scanner.nextInt() - 1;
                    }

                    shot = game.shot(x, y, game.gameBoard.boardComputer.boardPlayer);

                    if (shot == 'x') {
                        if (game.isSunk(x, y, game.gameBoard.boardComputer.boardPlayer)) {
                            game.ifShipIsSunkMarkPoleWhereThereAreNotOtherShip(game.gameBoard.boardComputer.boardPlayer, game.returnPositionOfSunkShip(game.gameBoard.boardComputer.boardPlayer, x, y));
                        }
                    }

                    game.printComputerBoardWhichSeeUser(x, y, shot);
                  game.printBoardComputer();
                }


            }


        }
    }
