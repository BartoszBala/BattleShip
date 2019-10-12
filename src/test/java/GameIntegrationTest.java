
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;
import static org.junit.Assert.*;
import static org.mockito.Mockito.doAnswer;

@RunWith(MockitoJUnitRunner.class)
public class GameIntegrationTest {

    @Spy
    Game game;


    @Test
    public void whenCreateGameCalledAnswered() {


        doAnswer((Answer) invocation ->
        { game.gameBoard.boardComputer.boardPlayer = new char[][]{{'o', 'o', 'o', 'o', ' ', 'o', 'o', 'o', ' ', 'o'}, {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '}, {'o', 'o', 'o', ' ', 'o', 'o', ' ', 'o', 'o', ' '}, {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '}, {'o', 'o', ' ', 'o', ' ', 'o', ' ', 'o', ' ', ' '}, {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '}, {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '}, {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '}, {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '}, {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '}};
            game.gameBoard.boardPlayer.boardPlayer = new char[][]{{'o', 'o', 'o', 'o', ' ', 'o', 'o', 'o', ' ', 'o'}, {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '}, {'o', 'o', 'o', ' ', 'o', 'o', ' ', 'o', 'o', ' '}, {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '}, {'o', 'o', ' ', 'o', ' ', 'o', ' ', 'o', ' ', ' '}, {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '}, {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '}, {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '}, {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '}, {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '}};
            return null;
        }).when(game).createGame();
        game.createGame();
        assertEquals(20, game.computerShips);
        assertEquals(20, game.playerShips);
        char shot = game.shot(0, 0, game.gameBoard.boardPlayer.boardPlayer);
        assertEquals('x', shot);
        assertTrue(game.currentPlayer.equals("computer"));
        shot = game.shot(9, 9, game.gameBoard.boardPlayer.boardPlayer);
        assertEquals('*', shot);
        assertTrue(game.currentPlayer.equals("user"));
        shot = game.shot(0, 0, game.gameBoard.boardComputer.boardPlayer);
        shot = game.shot(0, 1, game.gameBoard.boardComputer.boardPlayer);
        assertFalse(game.isSunk(0, 2, game.gameBoard.boardComputer.boardPlayer));

        shot = game.shot(0, 2, game.gameBoard.boardComputer.boardPlayer);
        assertEquals('x', shot);
        shot = game.shot(0, 3, game.gameBoard.boardComputer.boardPlayer);
        assertEquals('x', shot);
        assertTrue(game.isSunk(0, 3, game.gameBoard.boardComputer.boardPlayer));


        assertTrue(game.isSunk(0, 3, game.gameBoard.boardComputer.boardPlayer));

        shot = game.shot(0, 4, game.gameBoard.boardComputer.boardPlayer);
        assertEquals('*', shot);

        assertEquals(16, game.computerShips);
        assertTrue(game.currentPlayer.equals("computer"));
        shot = game.shot(7, 7, game.gameBoard.boardPlayer.boardPlayer);
        assertEquals('*', shot);

        assertTrue(game.currentPlayer.equals("user"));

        game.shot(0, 5, game.gameBoard.boardComputer.boardPlayer);
        assertFalse(game.isSunk(0, 5, game.gameBoard.boardComputer.boardPlayer));
        game.shot(0, 6, game.gameBoard.boardComputer.boardPlayer);
        game.shot(0, 7, game.gameBoard.boardComputer.boardPlayer);


        assertTrue(game.isSunk(0, 7, game.gameBoard.boardComputer.boardPlayer));


        assertFalse(game.isWin());

        game.shot(0, 9, game.gameBoard.boardComputer.boardPlayer);
        game.shot(0, 9, game.gameBoard.boardComputer.boardPlayer);
        assertTrue(game.currentPlayer.equals("computer"));

        game.shot(8, 8, game.gameBoard.boardPlayer.boardPlayer);

        assertTrue(game.currentPlayer.equals("user"));

        game.shot(2, 0, game.gameBoard.boardComputer.boardPlayer);
        game.shot(2, 1, game.gameBoard.boardComputer.boardPlayer);
        game.shot(2, 2, game.gameBoard.boardComputer.boardPlayer);
        game.shot(2, 4, game.gameBoard.boardComputer.boardPlayer);
        game.shot(2, 5, game.gameBoard.boardComputer.boardPlayer);
        game.shot(2, 7, game.gameBoard.boardComputer.boardPlayer);
        game.shot(2, 8, game.gameBoard.boardComputer.boardPlayer);

        assertEquals(5, game.computerShips);

        shot = game.shot(2, 8, game.gameBoard.boardComputer.boardPlayer);
        assertEquals('y', shot);
        assertTrue(game.currentPlayer.equals("computer"));
        shot = game.shot(0, 1, game.gameBoard.boardPlayer.boardPlayer);
        assertEquals('x', shot);
        shot = game.shot(0, 0, game.gameBoard.boardPlayer.boardPlayer);
        assertEquals('y', shot);
        assertEquals(18, game.playerShips);
        assertTrue(game.currentPlayer.equals("user"));
        game.shot(4, 0, game.gameBoard.boardComputer.boardPlayer);
        game.shot(4, 1, game.gameBoard.boardComputer.boardPlayer);
        game.shot(4, 3, game.gameBoard.boardComputer.boardPlayer);

        assertEquals(2, game.computerShips);
        game.shot(4, 5, game.gameBoard.boardComputer.boardPlayer);
        assertEquals(1, game.computerShips);
        assertFalse(game.isWin());
        assertTrue(game.currentPlayer.equals("user"));
        game.shot(4, 7, game.gameBoard.boardComputer.boardPlayer);
        assertTrue(game.isWin());


    }


}
