/**
 * Created by Alexqq11 on 20.09.2016.
 */
import Core.*;
public class ConsoleOutputMode {
    private GameWorld world;
    private char[][] map;

    public ConsoleOutputMode(GameWorld world) {
        this.world = world;
        this.map = world.map;
    }

    public void updateMap(GameWorld world) {
        this.map = world.map;
    }

    public void drawWorldState() {
        for (int i = 0; i < world.mapHeight; i++) {
            for (int j = 0; j < world.mapHeight; j++) {
                System.out.print(this.map[i][j]);
            }
            System.out.print('\n');
        }
        for (int j = 0; j < world.mapHeight; j++) {
            System.out.print('_');
        }

    }

}
