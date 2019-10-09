import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class BoardTest {

    private Board board;


    @Before
    public void setUp() {
        board = new Board();

    }


    @Test
    public void shouldCreateBoardWithSize10WithEmptyValuesAndInitialValueOfShipNumber() {
        //given

        board.boardInit();

        //when

        int length = board.getBoardPlayer().length;
        List<Integer> listOfNumberShips = new ArrayList<>();
        listOfNumberShips.add(4);
        listOfNumberShips.add(3);
        listOfNumberShips.add(2);
        listOfNumberShips.add(1);
        //then

        Assert.assertEquals(10, length);

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                Assert.assertEquals(' ', board.boardPlayer[i][j]);

            }


        }
        assertEquals(listOfNumberShips, board.playerShips);
    }

    @Test
    public void shouldAddShipsWhenStartPositionIsCorrectAndDeductNumberOfShipsIfShipAdded() {
        //given
        board.boardInit();


        //when

        board.addShip(0, 0, 4, "horizontal");
        board.addShip(0,0,2,"vertical");
        board.addShip(9,9,3,"vertical");
        board.addShip(5,5,1,"vertical");
        List<Integer> listOfNumberShips = new ArrayList<>();
        listOfNumberShips.add(3);
        listOfNumberShips.add(3);
        listOfNumberShips.add(2);
        listOfNumberShips.add(0);

        //then
        for(int i=0; i<10;i++)
        {
            for(int j=0;j<10;j++)
            {   if(i==0&&(j<4)||(i==5&&j==5))
                assertEquals('o',board.boardPlayer[j][i]);
            else{

                assertEquals(' ',board.boardPlayer[j][i]);
            }


            }


        }

        Assert.assertEquals(listOfNumberShips,board.playerShips);

    }
}