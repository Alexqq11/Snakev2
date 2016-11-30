package Client;

/**
 * Created by Alexqq11 on 20.09.2016.
 */
public class PlayerClient {
    public int x;         // TODO define that it's snake's coordinate
    public int y;
    private int score;
    private boolean isActive;
    private boolean isSnakeAlive;
    private int id;
    private int key;

    public PlayerClient(int x, int y, int id) {
        this.x = x;
        this.y = y;
        this.score = 0;
        this.isActive = true;
        this.id = id;                           //this.hashCode();
        this.key = 1000 + id;
    }
    public ClientInfo getClientInfo(){
        return new ClientInfo(score, isActive, isSnakeAlive, id);

    }
    public int getKey(){return this.key;}
    public void lose() {
        this.isActive = false;
    }

    public boolean getStatus() {
        return this.isActive;
    }

    public int getId() {
        return this.id;
    }

    public void updateScore() {
        this.score += 1;
    }

}

