import model.Game;
import model.Player;
import model.Score;
import model.Tour;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;


@RunWith(Parameterized.class)
public class GameSpec {

    static Player player1;
    static Player player2;
    static Game game;

    public static void setup() {
        player1 = new Player("pp1", Score.ZERO);
        player2 = new Player("pp2", Score.ZERO);
        game = new Game(player1, player2);
    }

    // fields used together with @Parameter must be public
    @Parameter(0)
    public static Score score1;
    @Parameter(1)
    public static Score score2;
    @Parameter(2)
    public static Player winner;
    @Parameter(3)
    public static Player loser;
    @Parameter(4)
    public static Score score1Result;
    @Parameter(5)
    public static Score score2Result;


    // creates the test data
    @Parameters
    public static Collection<Object[]> data() {
        //@before to this method didn't work , then i chooce to put this method here
        setup();
        Object[][] data = new Object[][]{

                {Score.ZERO, Score.ZERO, player1, player2, Score.FIFTEEN, Score.ZERO},
                {Score.FIFTEEN, Score.ZERO, player1, player2, Score.THIRTY, Score.ZERO},
                {Score.THIRTY, Score.ZERO, player1, player2, Score.FORTY, Score.ZERO},
                {Score.FORTY, Score.ZERO, player1, player2, Score.Win, Score.ZERO},

                {Score.ZERO, Score.FIFTEEN, player1, player2, Score.FIFTEEN, Score.FIFTEEN},
                {Score.FIFTEEN, Score.FIFTEEN, player1, player2, Score.THIRTY, Score.FIFTEEN},
                {Score.THIRTY, Score.FIFTEEN, player1, player2, Score.FORTY, Score.FIFTEEN},
                {Score.FORTY, Score.FIFTEEN, player1, player2, Score.Win, Score.FIFTEEN},

                {Score.ZERO, Score.THIRTY, player1, player2, Score.FIFTEEN, Score.THIRTY},
                {Score.FIFTEEN, Score.THIRTY, player1, player2, Score.THIRTY, Score.THIRTY},
                {Score.THIRTY, Score.THIRTY, player1, player2, Score.FORTY, Score.THIRTY},
                {Score.FORTY, Score.THIRTY, player1, player2, Score.Win, Score.THIRTY},

                {Score.ZERO, Score.FORTY, player1, player2, Score.FIFTEEN, Score.FORTY},
                {Score.FIFTEEN, Score.FORTY, player1, player2, Score.THIRTY, Score.FORTY},
                {Score.THIRTY, Score.FORTY, player1, player2, Score.FORTY, Score.FORTY},
                {Score.FORTY, Score.FORTY, player1, player2, Score.ADV, Score.FORTY},

                {Score.ADV, Score.FORTY, player1, player2, Score.Win, Score.FORTY},
                {Score.FORTY, Score.ADV, player1, player2, Score.DEUCE, Score.DEUCE},
                {Score.DEUCE, Score.DEUCE, player1, player2, Score.ADV, Score.FORTY},


        };

        return Arrays.asList(data);
    }


    @Test
    public void testMultiplyTour() throws Exception {

        winner.setScore(score1);
        loser.setScore(score2);
        game.addTour(new Tour(winner, loser));
        assertEquals(winner.getScore(), score1Result);
        assertEquals(loser.getScore(), score2Result);

    }

    @Test
    public void addTourshouldThrowException() {
        winner.setScore(Score.Win);
        loser.setScore(score2);
        try {
            game.addTour(new Tour(winner, loser));
        } catch (Exception e) {
            assertEquals("This game is finish", e.getMessage());
        }

    }

}

