import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class GameBoardTest {
    GameBoard gameBoard;

    @Before
    public void setUp()

    {gameBoard = new GameBoard();}


    @Test
    public void shouldReturnDirectionOfShip()

    {
        //given
        int direction =0;
        //when
        String direction1 = gameBoard.determineDirectionOfShips(direction);
        //then

        Assert.assertEquals("horizontal",direction1);

    }


    @Test
    public void shouldCreateBoardComputerWhichHave20PolesBusy()
    {//given

        gameBoard.createComputerBoard();


//when
        int counterShipPole=0;
        int counterEmptyPole=0;

        for(int i=0;i<10;i++) {
            for (int j = 0; j < 10; j++) {
                if (gameBoard.boardComputer.boardPlayer[i][j] == 'o') {
                    counterShipPole++;
                }
                if (gameBoard.boardComputer.boardPlayer[i][j] == ' ') {
                    counterEmptyPole++;
                }
            }
        }
        //then
        assertEquals(20,counterShipPole);
        assertEquals(80,counterEmptyPole);







    }


    @Test
    public void shouldCreateBoardUserWhichHave20PolesBusy()
    {//given

        gameBoard.createUserBoard();


//when
        int counterShipPole=0;
        int counterEmptyPole=0;

        for(int i=0;i<10;i++) {
            for (int j = 0; j < 10; j++) {
                if (gameBoard.boardPlayer.boardPlayer[i][j] == 'o') {
                    counterShipPole++;
                }
                if (gameBoard.boardPlayer.boardPlayer[i][j] == ' ') {
                    counterEmptyPole++;
                }
            }
        }
        //then
        assertEquals(20,counterShipPole);
        assertEquals(80,counterEmptyPole);







    }






}