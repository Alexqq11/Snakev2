package Client;

/**
 * Created by Alexqq11 on 15.11.2016.
 */
public class ClientInfo {
   public  int id;
   public  boolean isSnakeAlive;
   public  boolean isActive;
   public  int score;
   public  ClientInfo(int score, boolean isActive, boolean isSnakeAlive, int id){
        this.id = id;
        this.score = score;
        this.isActive = isActive;
        this.isSnakeAlive = isSnakeAlive;
    }
}

