package Signals;

/**
 * Created by Alexqq11 on 19.10.2016.
 */
import Entities.SnakeDirections;
public class ClientDirectionSignal  extends Signal{
    private int snakeID;
    private int key;
    private SnakeDirections direction;

    public ClientDirectionSignal(int clientID, int key ,SnakeDirections direction) {
        this.direction = direction;
        this.snakeID = clientID;
        this.key = key;

    }

    public int getId() {
        return this.snakeID;
    }
    public int getKey(){ return this.key;}

    public SnakeDirections getDirection() {
        return this.direction;
    }
}
