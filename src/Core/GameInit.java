package Core;

import Client.*;
import Signals.*;
import java.util.LinkedList;

public class GameInit {
    public  GameEngine engine;
    public  GameWorld  gameWorld;
    public  GameInit(GameType type){
        if (GameType.TEST1 == type){
            testConfiguration();
        }
        if (GameType.USER == type){
            applyGameConfiguration(40, 30);
        }
    }
    public void loadGameConfiguration(){
        // load from file format

    }
    public void applyGameConfiguration(int mapWidth,int  mapHeight){
        // make with user args
        LinkedList<PlayerClient> clients = new LinkedList<>();
        clients.add(new PlayerClient(10,10, 1)); // add one obstacle and bonus
        this.gameWorld = new GameWorld(mapWidth, mapHeight, clients);
        this.engine = new GameEngine(this.gameWorld);
    }
    public void testConfiguration(){
        int mapWidth = 20;
        int mapHeight = 20;
        LinkedList<PlayerClient> clients = new LinkedList<>();
        clients.add(new PlayerClient(10,10, 1)); // add one obstacle and bonus
        this.gameWorld = new GameWorld(mapWidth, mapHeight, clients);
        this.engine = new GameEngine(this.gameWorld);
    }
    public void SignalHandler(ClientDirectionSignal signal){
        //System.out.print("blya");
        engine.handlClientMovement(signal);
        /*if (signal.getType() == SignalType.CDRS){
            System.out.println("huya");
            engine.handlClientMovement((ClientDirectionSignal)signal); // think with it
        }
        else if (signal.getType() == SignalType.CGS){
            engine.handlClientGameSignal((ClientGameSignal) signal);
        }*/

    }
}
