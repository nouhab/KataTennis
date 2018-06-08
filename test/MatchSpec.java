import model.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;
@RunWith(Parameterized.class)
public class MatchSpec {

    static Player player1;
    static Player player2;
    static Match match;
   @Before
    public  void setup() {
        player1 = new Player("pp1", Score.ZERO);
        player2 = new Player("pp2", Score.ZERO);
        match=new Match();

    }


    // fields used together with @Parameter must be public
    @Parameterized.Parameter(0)
    public static Score score1;
    @Parameterized.Parameter(1)
    public static Score score2;
    @Parameterized.Parameter(2)
    public static int matchscore1;
    @Parameterized.Parameter(3)
    public static int matchscore2;


    // creates the test data
    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        //@before to this method didn't work , then i chooce to put this method here

        Object[][] data = new Object[][]{

                {Score.Win, Score.ZERO,1,0},
                {Score.Win, Score.ZERO,2,0 },
                {Score.Win, Score.ZERO,3,0}


        };

        return Arrays.asList(data);
    }


    @Test
    public void testMultiplyGame() throws Exception {

        player1.setScore(score1);
        player2.setScore(score2);
        System.out.println(player1+"****"+player2);
        match.addGame(new Game(player1, player2));
        assertEquals(player1.getPoints(),matchscore1);
        assertEquals(player2.getPoints(), matchscore2);

    }



















}


