import org.w3c.dom.ls.LSOutput;

import java.util.Random;

public class GameBoard {

    Board boardPlayer = new Board();
    Board boardComputer = new Board();


    public Board getBoardPlayer() {
        return boardPlayer;
    }

    public Board getBoardComputer() {
        return boardComputer;
    }

    public void createComputerBoard()  {
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
            System.out.println(boardComputer.getPlayerShips().get(i));
            while (boardComputer.getPlayerShips().get(i) > 0) {

                System.out.println(i);
                boardComputer.addShip(x, y, i + 1, direction);

                x = random.nextInt(10);
                y = random.nextInt(10);
                 direction=determineDirectionOfShips(random.nextInt(2));

            }
        }


    }


    private String determineDirectionOfShips(int direction0) {

        switch (direction0) {
            case 0:
                return "horizontal";
            case 1:
                return "vertical";
        }
        return null;
    }

    public static void main(String[] args)  {
        GameBoard gameBoard = new GameBoard();

        gameBoard.createComputerBoard();
        System.out.println("test");
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.print(gameBoard.getBoardComputer().getBoardPlayer()[j][i]);

            }
            System.out.println();
        }
    }
}





