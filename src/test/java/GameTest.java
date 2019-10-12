import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class GameTest {


    @Test
    public void testGame() {
        Game game = new Game();

        Board board = new Board();


        GameBoard gameBoard1 = mock(GameBoard.class);

        Board boardmoc = new Board();

        List<Integer> playerShips = new ArrayList<>();
        playerShips.add(4);
        playerShips.add(3);
        playerShips.add(2);
        playerShips.add(1);

        boardmoc.boardPlayer = new char[][]{{'o', 'o', 'o', 'o', ' ', ' ', 'o', 'o', 'o', 'o'}, {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '}, {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '}, {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '}, {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '}, {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '}, {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '}, {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '}, {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '}, {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '}};
        boardmoc.playerShips = playerShips;

        when(gameBoard1.createComputerBoard(board)).thenReturn(boardmoc);
        game.createGame();
        System.out.println(game.gameBoard.boardPlayer.boardPlayer[0][0]);
        System.out.println(game.gameBoard.boardComputer.boardPlayer[0][0]);

        char shot = game.shot(0, 0, game.gameBoard.boardComputer.boardPlayer);
        game.shot(1, 0, gameBoard1.createComputerBoard(board).boardPlayer);
        game.shot(2, 0, gameBoard1.createComputerBoard(board).boardPlayer);
        boolean isSunk0=game.isSunk(2,0,gameBoard1.createComputerBoard(board).boardPlayer);
        game.shot(3, 0, gameBoard1.createComputerBoard(board).boardPlayer);
       boolean isSunk=game.isSunk(3,0,gameBoard1.createComputerBoard(board).boardPlayer);
        assertTrue(isSunk);

        Assert.assertEquals('x', shot);

    }


}