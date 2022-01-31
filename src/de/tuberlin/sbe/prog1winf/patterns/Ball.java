package de.tuberlin.sbe.prog1winf.patterns;

import java.util.HashMap;
import java.util.Map;

public class Ball {
    private static Ball ball;
//    private static Map<String, Ball> toybox = new HashMap<>();
    private String color;
    private Ball(String color) { this.color = color; }
    public void bounce() { System.out.println("Ball of color " + this.color + ": boing!"); }
    public static Ball getInstance(String color) {
        if (ball == null) { ball = new Ball(color); }
//        Ball ball = toybox.get(color);
//        if (ball == null) {
//            ball = new Ball(color);
//            toybox.put(color, ball);
//        }
        return ball;
    }

    public static void main(String[] args) {
        Ball b1 = Ball.getInstance("red");
        b1.bounce();
        Ball b2 = Ball.getInstance("red");
        b2.bounce();
        b2 = Ball.getInstance("green");
        b2.bounce();
    }
}

