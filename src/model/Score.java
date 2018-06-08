package model;

public enum Score {


    ZERO(0),
    FIFTEEN(15),
    THIRTY(30),
    FORTY(40),
    DEUCE(100),
    ADV(100),
    Win(100);


    private int value;

    Score(int value) {
        this.value = value;
    }


    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }


}
