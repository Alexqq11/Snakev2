package JUNIT_WORKSPACE;

import Core.*;
import Signals.*;
import Entities.*;
import org.junit.Test;

import java.awt.*;
import java.util.ArrayList;
import java.util.LinkedList;

import static org.junit.Assert.*;


/**
 * Created by Arina Melnichuk on 10/11/2016.
 */

public class TestSnakeClass {
    @Test
    public void APItest() {
        //default snake position 10 10
        API api = new API(GameType.TEST1);



        for (int i = 0; i < 5; i++) {
            api.sendMoveSnakeEvent(1,1001,SnakeDirections.DOWN);
        }
        SnakeInfo snake = api.getSnakeInformation(1);//engine.gameWorld.snakes.getFirst();
        assertTrue(snake.snakePoints.getFirst().y == 15);//
    }

    @Test
    public void testCorrectSnakeMovementsDownInOneFrame() {
        //default snake position 10 10
        GameInit game = new GameInit(GameType.TEST1);
        game.testConfiguration();
        GameEngine engine = game.engine;
        ClientDirectionSignal  signal = new ClientDirectionSignal(1,1001, SnakeDirections.DOWN);
        for (int i = 0; i < 5; i++) {
            engine.handlClientMovement(signal);
        }
        Snake snake = engine.gameWorld.snakes.getFirst();
        assertTrue(snake.x == 10 && snake.y == 15);
    }

    @Test
    public void testCorrectSnakeMovementsDownInTwoFrames() {
        //default snake position 10 10
        GameInit game = new GameInit(GameType.TEST1);
        game.testConfiguration();
        GameEngine engine = game.engine;
        ClientDirectionSignal  signal = new ClientDirectionSignal(1,1001, SnakeDirections.DOWN);
        for (int i = 0; i < 20; i++) {
            engine.handlClientMovement(signal);
        }
        Snake snake = engine.gameWorld.snakes.getFirst();
        assertTrue(snake.x == 10 && snake.y == 10);
    }

    @Test
    public void testCorrectSnakeMovementsUpInOneFrames() {
        //default snake position 10 10
        GameInit game = new GameInit(GameType.TEST1);
        game.testConfiguration();
        GameEngine engine = game.engine;
        ClientDirectionSignal  signal = new ClientDirectionSignal(1,1001, SnakeDirections.UP);
        for (int i = 0; i < 5; i++) {
            engine.handlClientMovement(signal);
        }
        Snake snake = engine.gameWorld.snakes.getFirst();
        assertTrue(snake.x == 10 && snake.y == 5);
    }

    @Test
    public void testCorrectSnakeMovementsUpInTwoFrames() {
        //default snake position 10 10
        GameInit game = new GameInit(GameType.TEST1);
        game.testConfiguration();
        GameEngine engine = game.engine;
        ClientDirectionSignal  signal = new ClientDirectionSignal(1,1001, SnakeDirections.UP);
        for (int i = 0; i < 20; i++) {
            engine.handlClientMovement(signal);
        }
        Snake snake = engine.gameWorld.snakes.getFirst();
        assertTrue(snake.x == 10 && snake.y == 10);
    }

    @Test
    public void testCorrectSnakeMovementsLeftInOneFrames() {
        //default snake position 10 10
        GameInit game = new GameInit(GameType.TEST1);
        game.testConfiguration();
        GameEngine engine = game.engine;
        ClientDirectionSignal  signal = new ClientDirectionSignal(1,1001, SnakeDirections.LEFT);
        for (int i = 0; i < 5; i++) {
            engine.handlClientMovement(signal);
        }
        Snake snake = engine.gameWorld.snakes.getFirst();
        assertTrue(snake.x == 5 && snake.y == 10);
    }

    @Test
    public void testCorrectSnakeMovementsLeftInTwoFrames() {
        //default snake position 10 10
        GameInit game = new GameInit(GameType.TEST1);
        game.testConfiguration();
        GameEngine engine = game.engine;
        ClientDirectionSignal  signal = new ClientDirectionSignal(1,1001, SnakeDirections.LEFT);
        for (int i = 0; i < 20; i++) {
            engine.handlClientMovement(signal);
        }
        Snake snake = engine.gameWorld.snakes.getFirst();
        assertTrue(snake.x == 10 && snake.y == 10);
    }

    @Test
    public void testCorrectSnakeMovementBackRight() {
        //default snake position 10 10
        GameInit game = new GameInit(GameType.TEST1);
        game.testConfiguration();
        GameEngine engine = game.engine;
        ClientDirectionSignal  signal = new ClientDirectionSignal(1,1001, SnakeDirections.RIGHT);
        for (int i = 0; i < 11; i++) {
            engine.handlClientMovement(signal);
        }
        Snake snake = engine.gameWorld.snakes.getFirst();
        assertTrue(snake.x == 10 && snake.y == 10);
    }

    @Test
    public void testCorrectSnakeMovementHardtest() {
        //default snake position 10 10
        GameInit game = new GameInit(GameType.TEST1);
        game.testConfiguration();
        GameEngine engine = game.engine;
        ClientDirectionSignal  signal = new ClientDirectionSignal(1,1001, SnakeDirections.UP);
        for (int i = 0; i < 19; i++) {
            engine.handlClientMovement(signal);
        }
        signal = new ClientDirectionSignal(1, 1001, SnakeDirections.RIGHT);
        for (int i = 0; i < 8; i++) {
            engine.handlClientMovement(signal);
        }
        Snake snake = engine.gameWorld.snakes.getFirst();
        assertTrue(snake.x == 18 && snake.y == 11);
    }

    /////////////////////////////////////////////////////
    /*
    @Test
    public void testBonusEatingAndAnigilation() {
        //default snake position 10 10
        // bonus 10 13
        GameInit game = new GameInit(GameType.TEST1);
        game.testConfiguration();
        GameEngine engine = game.engine;
        ClientDirectionSignal  signal = new ClientDirectionSignal(1,1001, SnakeDirections.DOWN);
        Snake snake = engine.gameWorld.snakes.getFirst();
        int amountOfBonuses = engine.gameWorld.bonuses.size();
        int startLength = snake.getLength();
        for (int i = 0; i < 5; i++) {
            engine.handlClientMovement(signal);
        }
        assertTrue(snake.getLength() != startLength && engine.gameWorld.bonuses.size() == amountOfBonuses - 1);
    }
    */
/*
    @Test
    public void testBonusEatingOnePointWeight() {
        //default snake position 10 10
        GameInit game = new GameInit(GameType.TEST1);
        game.testConfiguration();
        GameEngine engine = game.engine;
        ClientDirectionSignal  signal = new ClientDirectionSignal(1,1001, SnakeDirections.DOWN);
        Snake snake = engine.gameWorld.snakes.getFirst();
        int amountOfBonuses = engine.gameWorld.bonuses.size();
        int startLength = snake.getLength();
        for (int i = 0; i < 5; i++) {
            engine.handlClientMovement(signal);
        }
        assertTrue(snake.getLength() == startLength + 1 && engine.gameWorld.bonuses.size() == amountOfBonuses - 1);
    }
*/
    @Test
    public void DIETESTWOOOOO() {
        //default snake position 10 10
        GameInit game = new GameInit(GameType.TEST1);
        game.testConfiguration();
        GameEngine engine = game.engine;
        ClientDirectionSignal  signal = new ClientDirectionSignal(1,1001, SnakeDirections.DOWN);
        for (int i = 0; i < 3; i++) {
            engine.handlClientMovement(signal);
        }
        signal = new ClientDirectionSignal(1, 1001, SnakeDirections.RIGHT);
        for (int i = 0; i < 1; i++) {
            engine.handlClientMovement(signal);
        }
        signal = new ClientDirectionSignal(1, 1001, SnakeDirections.UP);
        for (int i = 0; i < 1; i++) {
            engine.handlClientMovement(signal);
        }
        signal = new ClientDirectionSignal(1, 1001, SnakeDirections.LEFT);
        for (int i = 0; i < 1; i++) {
            engine.handlClientMovement(signal);
        }
        Snake snake = engine.gameWorld.snakes.getFirst();
        assertFalse(game.gameWorld.clients.getFirst().getStatus());
    }
/*
    @Test
    public void testObstacleDie() {
        //default snake position 10 10
        GameInit game = new GameInit(GameType.TEST1);
        game.testConfiguration();
        GameEngine engine = game.engine;
        ClientDirectionSignal  signal = new ClientDirectionSignal(1,1001, SnakeDirections.UP);
        for (int i = 0; i < 9; i++) {
            engine.handlClientMovement(signal);
        }
        signal = new ClientDirectionSignal(1,1001, SnakeDirections.LEFT);
        for (int i = 0; i < 9; i++) {
            engine.handlClientMovement(signal);
        }
        Snake snake = engine.gameWorld.snakes.getFirst();
        assertFalse(snake.isSnakeAlive());
    }
    */

    @Test
    public void testObstacleCollisionClientDisable() {
        //default snake position 10 10
        GameInit game = new GameInit(GameType.TEST1);
        game.testConfiguration();
        GameEngine engine = game.engine;
        ClientDirectionSignal  signal = new ClientDirectionSignal(1,1001, SnakeDirections.UP);
        for (int i = 0; i < 9; i++) {
            engine.handlClientMovement(signal);
        }
        signal = new ClientDirectionSignal(1, 1001, SnakeDirections.LEFT);
        for (int i = 0; i < 9; i++) {
            engine.handlClientMovement(signal);
        }
        Snake snake = engine.gameWorld.snakes.getFirst();
        assertFalse(game.gameWorld.clients.getFirst().getStatus());
    }

}
