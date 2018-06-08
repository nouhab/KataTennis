package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * A match is a list of game between two palyers
 */
public class Match {
    /**
     * the state of the match
     */
    public static enum State {
        START, PLAYING, END
    }

    State state = State.START;
    List<Game> games=new ArrayList<Game>();

    /**
     * @param game
     * @return
     * @throws Exception
     */
    public State addGame(Game game) throws Exception {
       //the match reach the end and the program try to add a new game
        if (this.state == state.END) {
            throw new Exception("The game is already  finish");
        } else if (game.getTheWinner() == null) {
            throw new Exception("The game is not finish, You can't add the game to the match");
        }

        if ((game.getTheWinner().points == 6 && game.getTheLoser().points <= 4) || game.getTheWinner().points == 6) {
            game.getTheWinner().winPoint();
            games.add(game);
            this.state = State.END;
        } else {
            game.getTheWinner().winPoint();
            games.add(game);
            this.state = State.PLAYING;
        }

        return state;
    }


}





