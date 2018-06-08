package model;


import java.util.Objects;

public class Player {

    String identity;
    Score score = Score.ZERO;
    int points=0;


    public Player(String identity, Score score) {
        this.identity = identity;
        this.score = score;
    }

    public void increaseScore() {
        switch (score) {
            case ZERO:
                score = Score.FIFTEEN;
                break;
            case FIFTEEN:
                score = Score.THIRTY;
                break;
            case THIRTY:
                score = Score.FORTY;
                break;

        }
    }
    public void winPoint(){
        points++;
    }


    public String getIdentity() {
        return identity;
    }


    public void setIdentity(String identity) {
        this.identity = identity;
    }

    public Score getScore() {
        return score;
    }

    public void setScore(Score score) {
        this.score = score;
    }

    public int getPoints() {
        return points;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Player)) return false;
        Player player = (Player) o;
        return Objects.equals(getIdentity(), player.getIdentity());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getIdentity());
    }

    @Override
    public String toString() {
        return "Player{" +
                "identity='" + identity + '\'' +
                ", score=" + score +
                ", points=" + points +
                '}';
    }
}
