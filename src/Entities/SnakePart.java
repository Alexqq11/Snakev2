package Entities;

/**
 * Created by Alexqq11 on 21.09.2016.
 */
public class SnakePart extends Entity {

    public SnakePart(Snake snake) {
        this.x = snake.x;
        this.y = snake.y;

    }

    public SnakePart(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
