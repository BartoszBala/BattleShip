import java.util.Random;
import java.util.Scanner;

public class Game {

    GameBoard gameBoard = new GameBoard();
    String currentPlayer= "computer";
    int playerShips =20;
    int computerShips =20;
    Board boardComputerWhichSeeUser = new Board();



    public void createGame()

    {
        gameBoard.createComputerBoard();
        gameBoard.createUserBoard();

    }



    public char shot(int x, int y,char[][] board) {
char xchar =' ';
        if(board[x][y]=='o')
        {
board[x][y]='x';
xchar='x';
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
        {board[x][y]='*';
            xchar='*';
        }
            if(currentPlayer.equals("computer"))
currentPlayer="user";
            else
            {currentPlayer="computer";}

        }



return xchar;
    }

    public boolean isWin()

    {if(computerShips==0||playerShips==0) {
        return true;
    }

        return false;
    }


    public void printBoardUser()
    {

        System.out.println("*********USER BOARD*************");
        System.out.println("   1 2 3 4 5 6 7 8 9 10");
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if(j==0)
                {
                    System.out.printf("%2d|",(i+1));
                }
                System.out.print(gameBoard.getBoardPlayer().getBoardPlayer()[j][i]+"|");


            }
            System.out.println();
        }
    }

    public void printBoardComputer()

    {

        System.out.println("*********COMPUTER**********");
        System.out.println("   1 2 3 4 5 6 7 8 9 10");
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if(j==0)
                {
                    System.out.printf("%2d|",(i+1));
                }
                System.out.print(gameBoard.getBoardComputer().getBoardPlayer()[j][i]+"|");


            }
            System.out.println();
        }


    }

    public void printComputerBoardWhichSeeUser(int xPosition, int yPosition, char x)

    {if(x!=' ')
    { boardComputerWhichSeeUser.getBoardPlayer()[xPosition][yPosition]=x;}

        System.out.println("*********COMPUTER**********");
        System.out.println("   1 2 3 4 5 6 7 8 9 10");
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if(j==0)
                {
                    System.out.printf("%2d|",(i+1));
                }
                System.out.print(boardComputerWhichSeeUser.getBoardPlayer()[j][i]+"|");


            }
            System.out.println();
        }


    }










    public static void main(String[] args) {
        Game game = new Game();
        SmartComputer smartComputer = new SmartComputer();
        game.createGame();
        Scanner scanner = new Scanner(System.in);
Random random = new Random();
int x=-1;
int y=-1;
char shot=' ';
game.boardComputerWhichSeeUser.boardInit();
while (!game.isWin())
{x=-1;
    y=-1;





    if(game.currentPlayer.equals("computer"))
    {    x=random.nextInt(10);
        y=random.nextInt(10);
        shot=game.shot(x,y,game.gameBoard.boardPlayer.boardPlayer);

        smartComputer.updateBoardAfterShot(x,y,shot);

        game.printBoardUser();

       // game.printComputerBoardWhichSeeUser(x,y,char x);

   }
    else{
     while(x<0||x>=10)
        { System.out.println("podaj wspoldzedna x");
        x=scanner.nextInt()-1;}
        while(y<0||y>=10)
        { System.out.println("podaj wspoldzedna y");
        y=scanner.nextInt()-1;}
        System.out.println(x);
        System.out.println(y);
           shot= game.shot(x,y,game.gameBoard.boardComputer.boardPlayer);
        game.printBoardUser();

game.printComputerBoardWhichSeeUser(x,y,shot);
      }




}


    }
}
