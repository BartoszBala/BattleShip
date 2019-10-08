import java.util.*;

public class Game {

    GameBoard gameBoard = new GameBoard();
    String currentPlayer = "computer";
    int playerShips = 20;
    int computerShips = 20;
    Board boardComputerWhichSeeUser = new Board();
    List<List<Integer>> listofShot = new ArrayList<>();
    char[][] computerBoardwhichSeeUser = new char[10][10];

    int counterOfPlayershots = 0;
    int counterOfComputershots = 0;

    public Board getBoardComputerWhichSeeUser() {
        return boardComputerWhichSeeUser;
    }

    public void createGame() {
        gameBoard.createComputerBoard();
        gameBoard.createUserBoard();

    }

    public void initComputerBoardwhichSeeUSer() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {

                computerBoardwhichSeeUser[i][j] = ' ';

            }


        }


    }


    public List<List<Integer>> getListofShot() {
        return listofShot;
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
            if (board[x][y] == ' ' || board[x][y] == '*' || board[x][y] == 'x') {
                if (board[x][y] == 'x') {
                    xchar = 'y';
                } else {
                    board[x][y] = '*';
                    xchar = '*';
                }
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

    public boolean isEmptyPole(char[][] board, int xPosition, int yPosition) {
        if (board[xPosition][yPosition] == ' ' || board[xPosition][yPosition] == 'o')
            return true;

        return false;


    }


    public char smartShot(char[][] userBoard, int xPosition, int yPosition) {
        char shot = ' ';
        if (xPosition + 1 != 10 && userBoard[xPosition + 1][yPosition] == ' ') {
            shot = shot(xPosition + 1, yPosition, userBoard);

        } else if (yPosition + 1 != 10 && userBoard[xPosition][yPosition + 1] == ' ') {
            shot = shot(xPosition, yPosition + 1, userBoard);
        } else if (xPosition - 1 != -1 && userBoard[xPosition - 1][yPosition] == ' ') {
            shot = shot(xPosition - 1, yPosition, userBoard);
        } else if (yPosition - 1 != -1 && userBoard[xPosition][yPosition - 1] == ' ') {
            shot = shot(xPosition, yPosition - 1, userBoard);
        }

        return shot;
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
        } else {


            for (int i = 0; i < positionOfSunkShip[1] + 2; i++) {
                if (positionOfSunkShip[3] - 1 + i != -1 && positionOfSunkShip[3] - 1 + i != 10) {
                    {
                        if ((positionOfSunkShip[2] - 1) != -1)
                            playerboard[positionOfSunkShip[2] - 1][positionOfSunkShip[3] - 1 + i] = '*';
                        if ((positionOfSunkShip[2] + 1) != 10)
                            playerboard[positionOfSunkShip[2] + 1][positionOfSunkShip[3] - 1 + i] = '*';

                        if (playerboard[positionOfSunkShip[2]][positionOfSunkShip[3] - 1 + i] != 'x') {
                            playerboard[positionOfSunkShip[2]][positionOfSunkShip[3] - 1 + i] = '*';
                        }


                    }

                }
            }


        }


    }


    public void printBoardUser() {

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

    public void printBoardComputerwhichSeeUser() {

        System.out.println("*********COMPUTER BOARD*************");
        System.out.println("   1 2 3 4 5 6 7 8 9 10");
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (j == 0) {
                    System.out.printf("%2d|", (i + 1));
                }
                System.out.print(computerBoardwhichSeeUser[j][i] + "|");


            }
            System.out.println();
        }
    }

    private void printBoardComputer() {

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

    public void setComputerBoardWhichSeeUser(int xPosition, int yPosition, char x) {


        if (x != ' ') {
            if (x == 'y') {
                computerBoardwhichSeeUser[xPosition][yPosition] = 'x';
            } else {
                computerBoardwhichSeeUser[xPosition][yPosition] = x;
            }

        }


    }


    public static void main(String[] args) {
        Game game = new Game();

        game.createGame();
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int x = -1;
        int y = -1;
        char shot = ' ';
        boolean isWin =true;
        game.boardComputerWhichSeeUser.boardInit();
        game.initComputerBoardwhichSeeUSer();
        game.printBoardComputerwhichSeeUser();
        game.printBoardUser();
        game.printBoardComputer();


        while (isWin) {
            x = -1;
            y = -1;


            if (game.currentPlayer.equals("computer")) {
                do {
                    x = random.nextInt(10);
                    y = random.nextInt(10);
                }

                while ((!game.isEmptyPole(game.gameBoard.boardPlayer.boardPlayer, x, y)));
                shot = game.shot(x, y, game.gameBoard.boardPlayer.boardPlayer);
                if(game.isWin())
                {
                    game.currentPlayer="computer";
                    isWin =false;
                break;
                }
                game.counterOfComputershots++;

                while (shot == 'x') {


                    if (game.isSunk(x, y, game.gameBoard.boardPlayer.boardPlayer)) {
                        game.ifShipIsSunkMarkPoleWhereThereAreNotOtherShip(game.gameBoard.boardPlayer.boardPlayer, game.returnPositionOfSunkShip(game.gameBoard.boardPlayer.boardPlayer, x, y));

                        do {
                            x = random.nextInt(10);
                            y = random.nextInt(10);
                        }

                        while ((!game.isEmptyPole(game.gameBoard.boardPlayer.boardPlayer, x, y)));
                        shot = game.shot(x, y, game.gameBoard.boardPlayer.boardPlayer);
                        if(game.isWin())
                        {
                            game.currentPlayer="computer";
                            isWin =false;
                            break;}
                        game.counterOfComputershots++;
                    } else {

                        shot = game.smartShot(game.gameBoard.boardPlayer.boardPlayer, x, y);
                        if(game.isWin())
                        {
                            game.currentPlayer="computer";
                            isWin =false;
                            break;}
                        game.counterOfComputershots++;
                    }
                }



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
                if(game.isWin())
                {
                    game.currentPlayer="user";
                    isWin =false;
                    break;}
                game.counterOfPlayershots++;
                game.setComputerBoardWhichSeeUser(x, y, shot);

                while (shot == 'x') {


                    if (game.isSunk(x, y, game.gameBoard.boardComputer.boardPlayer)) {
                        game.ifShipIsSunkMarkPoleWhereThereAreNotOtherShip(game.computerBoardwhichSeeUser, game.returnPositionOfSunkShip(game.gameBoard.boardComputer.boardPlayer, x, y));
                    }
                    game.printBoardComputerwhichSeeUser();
                    game.printBoardUser();
                    x=-1;
                    y=-1;

                    while (x < 0 || x >= 10) {
                        System.out.println("podaj wspolrzedna x");
                        x = scanner.nextInt() - 1;
                    }
                    while (y < 0 || y >= 10) {
                        System.out.println("podaj wspolrzedna y");
                        y = scanner.nextInt() - 1;
                    }

                    shot = game.shot(x, y, game.gameBoard.boardComputer.boardPlayer);
                    if(game.isWin())
                    {
                        game.currentPlayer="user";
                        isWin =false;
                        break;}

                    game.counterOfPlayershots++;
                    game.setComputerBoardWhichSeeUser(x, y, shot);
                    game.printBoardComputerwhichSeeUser();
                    game.printBoardUser();
                }
                game.setComputerBoardWhichSeeUser(x, y, shot);
                game.printBoardComputerwhichSeeUser();
                game.printBoardUser();
                System.out.println("CPU: " + game.counterOfComputershots);
                System.out.println("PLAYER: " + game.counterOfPlayershots);
            }



        }




        System.out.println(game.currentPlayer.equals("computer")?"SORRY BUT COMPUTER WON":"YOU WIN");


    }
}
