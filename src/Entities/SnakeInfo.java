package Entities;

import java.awt.*;
import java.util.LinkedList;

/**
 * Created by Alexqq11 on 16.11.2016.
 */
public class SnakeInfo {
    public  int lives;
    public  int length;
    public  int id;
    public  boolean isAlive;
    public  boolean onPause;
    public  SnakeDirections previousDirection;
    public LinkedList<Point> snakePoints;

    SnakeInfo(int id, int lives, int  length, boolean isAlive, boolean onPause, SnakeDirections previousDirection, LinkedList<Point> snakePoints){
        this.id = id;
        this.isAlive = isAlive;
        this.onPause = onPause;
        this.length = length;
        this.lives = lives;
        this.previousDirection = previousDirection;
        this.snakePoints = snakePoints;
    }
}
