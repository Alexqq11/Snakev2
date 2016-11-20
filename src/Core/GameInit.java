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
    }

    public void testConfiguration(){
        int mapWidth = 20;
        int mapHeight = 20;
        LinkedList<PlayerClient> clients = new LinkedList<>();
        clients.add(new PlayerClient(10,10, 1)); // add one obstacle and bonus
        this.gameWorld = new GameWorld(mapWidth, mapHeight, clients);
        this.engine = new GameEngine(this.gameWorld);
    }
    public void SignalHandler(Signal signal){
        if (signal.getType() == SignalType.CDRS){
            engine.handlClientMovement((ClientDirectionSignal)signal); // think with it
        }
        else if (signal.getType() == SignalType.CGS){
            engine.handlClientGameSignal((ClientGameSignal) signal);
        }

    }
}
