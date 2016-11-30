package Core;

import java.util.LinkedList;
import  Entities.*;
import Client.*;

/**
 * Created by Alexqq11 on 05.10.2016.
 */
public class GameWorld {
    public LinkedList<Snake> snakes = new LinkedList<>();
    public LinkedList<Bonus> bonuses = new LinkedList<>();
    public LinkedList<PlayerClient> clients = new LinkedList<>();
    public char[][] map;
    public int mapWidth;
    public int mapHeight;

    public GameWorld(int mapWidth, int mapHeight, LinkedList<PlayerClient> clients) {//todo ahctung achtung clients link;
        this.map = new char[mapHeight][mapWidth];
        this.mapWidth = mapWidth;
        this.mapHeight = mapHeight;
        this.snakes = new LinkedList<>();
        this.bonuses = new LinkedList<>();
        this.clients = new LinkedList<>();
        this.clients = clients;
        initSnakesForPlayerClients();
        updateMapObjects();
        initStaticWall();
    }

    public void updateMapObjects() {
        this.map = new char[mapHeight][mapWidth];
        for (Snake snake : this.snakes) {
            setEntity(snake.snakeParts, '*');
            map[snake.y][snake.x] = '@'; // todo make non static textures//
        }
        setEntity(this.bonuses, '$');
    }

    private void setEntity(LinkedList<? extends Entity> entities, char marking) {
        for (Entity entity : entities) {
            this.map[entity.y][entity.x] = marking;
        }
    }

    private void initSnakesForPlayerClients() {
        for (int i = 0; i < clients.size(); i++) {
            PlayerClient processingClient = clients.get(i);
            Snake snake = new Snake(this.mapWidth, this.mapHeight, processingClient.x, processingClient.y, processingClient.getId(), processingClient.getKey());
            snakes.add(snake);
        }

    }
    private void initStaticWall(){
        addBonus(2,2,BonusType.WALL);
        addBonus(3,2, BonusType.WALL);
    }

    protected void addBonus(int x , int y , BonusType type) {
        //if (this.bonuses  != null && this.bonuses.isEmpty())
        bonuses.add(new Bonus( x, y, type ));
    }
    protected void addClient(PlayerClient client){
        clients.add(client);
        Snake snake = new Snake(this.mapWidth, this.mapHeight, client.x, client.y, client.getId(), client.getKey());
        snakes.add(snake);

    }


}
