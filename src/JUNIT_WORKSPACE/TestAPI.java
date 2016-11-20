package JUNIT_WORKSPACE;

import Client.ClientInfo;
import Client.PlayerClient;
import Core.*;
import org.junit.Test;

import static org.junit.Assert.*;

public class TestAPI {
    public boolean equlsInfo(ClientInfo info , ClientInfo it){
        return info.id == it.id && info.score == it.score && (info.isSnakeAlive == it.isSnakeAlive) && (info.isActive == it.isActive);
    }
    @Test
    public void testClientInfo() {
        API test = new API(GameType.TEST1);
        ClientInfo info = test.getClientInformation(1);
        PlayerClient client = new PlayerClient(10, 10 , 1);
        ClientInfo it = client.getClientInfo();
        assertTrue(equlsInfo(info, it));
    }
    public void testBonusesInfo(){

    }
}
