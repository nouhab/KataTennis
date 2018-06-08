package model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class Game {

    Player player1;
    Player player2;

    public List<Tour> tours = new ArrayList<Tour>();



    public Game(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    public void addTour(Tour t) throws Exception {

        if(t.winner.getScore()== Score.Win || t.loser.getScore()==Score.Win){
            throw new Exception("This game is finish");
        }
        if (t.winner.getScore().getValue() < 40 && t.loser.getScore().getValue() <= 40) {
            t.winner.increaseScore();
        } else {
            //one winner
            if ((t.winner.getScore() == Score.FORTY || t.winner.getScore() == Score.DEUCE) && t.winner.getScore() == t.loser.getScore()) {
                t.winner.setScore(Score.ADV);
                t.loser.setScore(Score.FORTY);
            } else if (t.winner.getScore() == Score.ADV || (t.winner.getScore() == Score.FORTY && t.loser.getScore() != Score.ADV)) {
                t.winner.setScore(Score.Win);
            } else if (t.loser.getScore() == Score.ADV) {
                t.winner.setScore(Score.DEUCE);
                t.loser.setScore(Score.DEUCE);
            }
        }

    }


    public Player getTheWinner() {
        if(player1.score==Score.Win){
            return player1;
        }else if(player2.getScore()==Score.Win) {
            return player2;
        }
        return null;

    }
    public Player getTheLoser() {
        if(player1.score==Score.Win){
            return player2;
        }else if(player2.getScore()==Score.Win) {
            return player1;
        }
        return null;

    }


}
