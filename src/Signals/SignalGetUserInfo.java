package Signals;

import Client.*;

/**
 * Created by Alexqq11 on 15.11.2016.
 */
public class SignalGetUserInfo  extends Signal{
    int id;
    ClientInfo destination;
    boolean applied = false;
    boolean completed = false;
    public SignalGetUserInfo(int clientId){
        id = clientId;
    }
    public void apply(ClientInfo info){
        this.destination = info;
        this.applied = true;
    }

}
