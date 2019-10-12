import java.util.Random;
import java.util.Scanner;

public class GameApp {

    public static void main(String[] args) {
        Game game = new Game();

        game.createGame();
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int x = -1;
        int y = -1;
        char shot = ' ';
        boolean isWin =true;
        game.initComputerBoardwhichSeeUSer();
        game.printBoardComputerwhichSeeUser();
        game.printBoardUser();


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

            }

        }

        System.out.println(game.currentPlayer.equals("computer")?"SORRY BUT COMPUTER WON":"YOU WIN");


    }
}
