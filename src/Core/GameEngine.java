package Core;

import java.util.LinkedList;
import java.util.Random;

import Client.PlayerClient;
import Signals.*;
import Entities.*;

/**
 * Created by Alexqq11 on 20.09.2016.
 */
public class GameEngine {
    public GameWorld gameWorld;
    public Random rnd;

    public GameEngine(GameWorld world) {
        this.gameWorld = world;
        rnd = new Random();

    }

    public void handlClientGameSignal(ClientGameSignal signal){
        // may be pause or disconect game start // game ower
    }

    public void handlClientMovement(ClientDirectionSignal signal){//LinkedList<ClientDirectionSignal> clientDirectionSignals) {
        for (Snake snake : gameWorld.snakes){
            if (snake.getId() == signal.getId() && snake.getKey() == signal.getKey()) {
                moveSnake(snake, signal.getDirection());
            }
        }
       
        checkCollisions();
        respawnBonus();
    }
    public void respawnBonus(){
        if (gameWorld.bonuses == null){
            gameWorld.bonuses = new LinkedList<>();
        }
        if (gameWorld.bonuses.isEmpty()){
            gameWorld.addBonus(rnd.nextInt(gameWorld.mapWidth - 1), rnd.nextInt(gameWorld.mapHeight - 1), BonusType.APPLE);
        }
    }
    private void moveSnake(Snake snake, SnakeDirections direction) {
        snake.move(direction);
    }

    private void checkCollisions() {
        checkCollisionsSnakesWithBonus();
        processingSnakesCollision();
    }


    private void checkCollisionsSnakesWithBonus() {
        for (Snake snake : gameWorld.snakes) {
            for (Bonus bonus : gameWorld.bonuses) {
                if (snake.positionEquals(bonus)) {
                    snake.applyEffects(bonus.getEffects());
                    clientUpdateScore(snake.getId());
                    gameWorld.bonuses.remove(bonus); // attention  wall can be removed
                }
            }
        }
    }

    private void clientGameLose(int id) {
        for (PlayerClient client : gameWorld.clients) {
            if (client.getId() == id) {
                client.lose();
            }
        }
    }


    private void clientUpdateScore(int id) {
        for (PlayerClient client : gameWorld.clients) {
            if (client.getId() == id) {
                client.updateScore();
            }
        }
    }


    private void processingSnakesCollision() {
        LinkedList<Snake> deadSnakes = getCollisionSnakesWithSnakes();
        for (Snake deadSnake : deadSnakes) {
            clientGameLose(deadSnake.getId());
        }

    }

    private LinkedList<Snake> getCollisionSnakesWithSnakes() {
        LinkedList<Snake> collisionSnakes = new LinkedList<Snake>();
        for (Snake snake : gameWorld.snakes) {
            for (Snake undercheck_snake : gameWorld.snakes) {
                if (snake != undercheck_snake) {
                    if (snake.positionEquals(undercheck_snake) || undercheck_snake.checkEntityForCollision(snake) || (!snake.isAlive())) {
                        collisionSnakes.add(snake);
                    }
                } else {
                    if (undercheck_snake.checkEntityForCollision(snake)) {
                        collisionSnakes.add(snake);
                    }

                }

            }
        }
        return collisionSnakes;

    }
    public void update_engine_state(){

    }

    /*public void addClient(PlayerClient client) {
        this.clients.add(client);
    }
*/
}

