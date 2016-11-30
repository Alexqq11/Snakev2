package Core;

import Client.ClientInfo;
import Client.PlayerClient;
import Entities.*;
import Signals.ClientDirectionSignal;

import java.util.LinkedList;

/**
 * Created by Alexqq11 on 16.11.2016.
 */
public class API {
    private GameInit pull;

    public API(GameType type){
        this.pull =  new GameInit(type);
    }

    /**
     * Функция возвращающая по переданному айдишнику
     * клиента его состояние в еще не оговоренном
     * формате данных
     * **/
    public Client.ClientInfo getClientInformation(int id){
        ClientInfo info = null;
        for (PlayerClient client : this.pull.gameWorld.clients){
            if (client.getId() == id){
                info = client.getClientInfo();
            }
        }
        return info; // doing something with this;
    }

    /**
     * функция возвращает состояние всех
     * клиентов находящихся в игре
     */
    public LinkedList<ClientInfo> getClientsInformation(){
        LinkedList<ClientInfo>  clientsInfo = new LinkedList<>();
        for (PlayerClient client : this.pull.gameWorld.clients){
            clientsInfo.add(client.getClientInfo());
        }
        return clientsInfo;
    }

    /**
     * Фукция возращает свойства всех  бонусов находящихся
     * на игровом поле
     */
    public LinkedList<BonusInfo> getBonusesInformation(){
        LinkedList<BonusInfo> bonusInfo = new LinkedList<>();
        for (Bonus bonus : this.pull.gameWorld.bonuses){
            bonusInfo.add(bonus.getBonusInfo());
        }
        return bonusInfo;
    }

    /**
     * Функция возвращает информацию о конкретной змее
     * по переданному ID
     */
    public SnakeInfo getSnakeInformation(int id){
        SnakeInfo info = null;
        for (Snake snake : pull.gameWorld.snakes){
            if (snake.getId() == id){
                info = snake.getSnakeInfo();
            }
        }
        return info; // do something with that;
    }

    /**
     * Возвращает иформацию о всех змеях
     */
    public LinkedList<SnakeInfo> getSnakesInformation(){    // TODO may be merged to one method
        LinkedList<SnakeInfo>  snakesInfo  = new LinkedList<>();
        for (Snake snake : pull.gameWorld.snakes){
            snakesInfo.add(snake.getSnakeInfo());
        }
        return  snakesInfo;
    }

    /**
     * отправить соответствующую команду на движение
     * соответствующей по id змеи и специальному ключу пользователя.
     */
    public void sendMoveSnakeEvent(int id , int key, SnakeDirections direction){
        pull.HandleSignal(new ClientDirectionSignal(id , key, direction));
    }
    /**
     *отправить движку операцию связанную с клиентом
     * (connect disconnect , stop game , start game , new game )
     */
    public void sendClientGameEvent(){}

}
