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
        board.addShip(0, 0, 2, "vertical");
        board.addShip(9, 9, 3, "vertical");
        board.addShip(5, 5, 1, "vertical");
        List<Integer> expectedListOfNumberShips = new ArrayList<>();
        expectedListOfNumberShips.add(3);
        expectedListOfNumberShips.add(3);
        expectedListOfNumberShips.add(2);
        expectedListOfNumberShips.add(0);

        //then
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (i == 0 && (j < 4) || (i == 5 && j == 5))
                    assertEquals('o', board.boardPlayer[j][i]);
                else {

                    assertEquals(' ', board.boardPlayer[j][i]);
                }


            }


        }

        Assert.assertEquals(expectedListOfNumberShips, board.playerShips);

    }

    @Test
    public void shouldReturnAmountOfPoleToEndOfBoard() {

        //given
        String direction = "horizontal";
        int x = 5;
        int y = 4;
        int sizeOfShip = 2;

        //when
        int emptyPole = board.returnVolumeOfPlaceToEndOfBoard(direction, x, y, sizeOfShip);

        //then

        Assert.assertEquals(3, emptyPole);

    }
@Test
  public void  shouldReturnTrueIfShipExists()

    {//given

        board.boardInit();
        board.addShip(5,6,3,"horizontal");

        //when

        boolean isExist =board.isShipExists(3);

        //then

        Assert.assertTrue(isExist);

    }
@Test
    public void  shouldReturnFalseIfShipDoesntExist()

    {//given

        board.boardInit();
        board.addShip(5,6,3,"horizontal");
        board.addShip(5,8,3,"horizontal");


        //when

        boolean isExist =board.isShipExists(3);

        //then

        Assert.assertFalse(isExist);

    }

    @Test

    public void shouldReturnTrueIfIsEnoughPlacetoPutShip()
    {//given

  int sizeOfShip=4;
  String direction = "horizontal";
  int x=6;
  int y=6;
  //when

       boolean isEnoughPlace= board.isEnoughSpaceForShip(direction,x,y,sizeOfShip);

       //then

        Assert.assertTrue(isEnoughPlace);


    }
@Test
    public void shouldReturnFalsefIsNotEnoughPlaceToPutShip()
    {//given

        int sizeOfShip=4;
        String direction = "horizontal";
        int x=7;
        int y=7;
        //when

        boolean isEnoughPlace= board.isEnoughSpaceForShip(direction,x,y,sizeOfShip);

        //then

        Assert.assertFalse(isEnoughPlace);


    }
@Test
    public void shouldReturnTrueIfIsPossibleToAddShipOnThisPosition()

    {//given
        board.boardInit();
        board.addShip(2,2,4,"vertical");
        board.addShip(6,2,3,"vertical");

        //when

        boolean isPossibleToAddShip= board.isPossibleToPutShipOnthisPlace("vertical",4,2,3);

        //then

        Assert.assertTrue(isPossibleToAddShip);




    }

@Test
    public void shouldReturnFalseIfIsNotPossibleToAddShipOnThisPosition()

    {//given
        board.boardInit();
        board.addShip(2,2,4,"vertical");
        board.addShip(6,2,3,"vertical");


        //when

        boolean isPossibleToAddShip= board.isPossibleToPutShipOnthisPlace("horizontal",2,3,3);

        //then

        Assert.assertFalse(isPossibleToAddShip);




    }




}