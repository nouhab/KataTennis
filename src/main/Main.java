package main;

import model.*;

public class Main {
    public static void main(String[] args) {


        Player p1 = new Player("nouha", Score.ZERO);
        Player p2 = new Player("souk", Score.ZERO);
        Match m1=new Match();
        Game game = new Game(p1,p2);
        try {

            game.addTour(new Tour(p1, p2));
            game.addTour(new Tour(p1, p2));
            game.addTour(new Tour(p2, p1));
            game.addTour(new Tour(p1, p2));
            game.addTour(new Tour(p2, p1));
            game.addTour(new Tour(p2, p1));
            game.addTour(new Tour(p2, p1));
            game.addTour(new Tour(p1, p2));
            game.addTour(new Tour(p1, p2));
            game.addTour(new Tour(p2, p1));
            game.addTour(new Tour(p2, p1));
            game.addTour(new Tour(p2, p1));
            System.out.println(p1+"***"+p2);

        }catch (Exception e){
           System.out.println("game is over");
        }

        try {
            System.out.println(m1.addGame(game));
            System.out.println(m1.addGame(game));
            System.out.println(m1.addGame(game));
            System.out.println(m1.addGame(game));
            System.out.println(m1.addGame(game));
            System.out.println(m1.addGame(game));
            System.out.println(m1.addGame(game));
            System.out.println(p1+"***"+p2);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
