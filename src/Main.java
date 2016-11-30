import Core.*;
import  Signals.*;
import  Entities.*;

public class Main {
    /* СЕРИАЛИЗАЦИЯ
    * Работа с файлами и чтение конфигоы из ФАЙЛА
    * МЕХАНИЗМ АПИ  - ПЕРЕСПАТЬ С НИМ ,  ДОБИТЬ оставшиеся сигналы, подумать над connection
    * разработать конфиги
    * */
    public static void main(String[] args) {
        // write your code here
        GameInit game = new GameInit(GameType.TEST1);
        game.testConfiguration();
        GameEngine engine = game.engine;
        ConsoleOutputMode com = new ConsoleOutputMode(engine.gameWorld);

        ClientDirectionSignal signal = new ClientDirectionSignal(1,1001, SnakeDirections.DOWN);
        for (int i = 0; i < 20; i++) {
            engine.handleClientMovement(signal);
            engine.gameWorld.updateMapObjects();
            com.updateMap(engine.gameWorld);
            com.drawWorldState();
        }
    }
}
