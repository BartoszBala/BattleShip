public class SmartComputer {

    char[][] computerShots = new char[10][10];



    public void boardInit()

    {

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                computerShots[i][j] = ' ';
                computerShots[i][j] = ' ';

            }

        }

    }

    public void updateBoardAfterShot(int x, int y, char ch)

    {
        computerShots[x][y]=ch;

    }

}
