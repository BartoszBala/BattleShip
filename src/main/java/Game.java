import java.util.Random;
import java.util.Scanner;

public class Game {

    GameBoard gameBoard = new GameBoard();
    String currentPlayer= "computer";
    int playerShips =20;
    int computerShips =20;


    public void createGame()

    {
        gameBoard.createComputerBoard();
        gameBoard.createUserBoard();

    }



    public void shot(int x, int y,char[][] board) {

        if(board[x][y]=='o')
        {
board[x][y]='x';
if(currentPlayer.equals("computer"))
{
    playerShips=playerShips-1;

}
else
{
    computerShips=computerShips-1;

}

        }
        else
        {if(board[x][y]==' ')
        {board[x][y]='*';}
            if(currentPlayer.equals("computer"))
currentPlayer="user";
            else
            {currentPlayer="computer";}

        }




    }

    public boolean isWin()

    {if(computerShips==0||playerShips==0) {
        return true;
    }

        return false;
    }










    public static void main(String[] args) {
        Game game = new Game();
        game.createGame();
        Scanner scanner = new Scanner(System.in);
Random random = new Random();
int x=-1;
int y=-1;
while (!game.isWin())
{x=random.nextInt(10);
y=random.nextInt(10);
    System.out.println("P: "+game.playerShips);
    System.out.println("C: "+game.computerShips);
    System.out.println("*********COMPUTER**********");
    for (int i = 0; i < 10; i++) {
        for (int j = 0; j < 10; j++) {
            System.out.print(game.gameBoard.getBoardComputer().getBoardPlayer()[j][i]);


        }
        System.out.println();
    }

    System.out.println("*********USER BOARD*************");
    for (int i = 0; i < 10; i++) {
        for (int j = 0; j < 10; j++) {
            System.out.print(game.gameBoard.getBoardPlayer().getBoardPlayer()[j][i]);


        }
        System.out.println();
    }
    if(game.currentPlayer.equals("computer"))
    {game.shot(x,y,game.gameBoard.boardPlayer.boardPlayer);}
    else{
        System.out.println("podaj wspoldzedna x");
        x=scanner.nextInt();
        System.out.println("podaj wspoldzedna y");
        y=scanner.nextInt();

            game.shot(x,y,game.gameBoard.boardComputer.boardPlayer);}




}


    }
}
