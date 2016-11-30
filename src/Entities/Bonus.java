package Entities;

import java.util.HashMap;

public class Bonus extends Entity {
    public int liveTime = -1;
    public HashMap<Effects, Double> config;
    public BonusType bonusType;
    public Bonus(int x, int y, BonusType type) {
        this.x = x;
        this.y = y;
        bonusType = type;
        initBonusConfig(type);
        initConfig(type);
    }

    private void initBonusConfig(BonusType type) {
    }

    public HashMap<Effects, Double> getEffects() {
        return config;
    }

    private void initConfig(BonusType bonusType) {
        if (BonusType.APPLE == bonusType) {
            config = new HashMap<>();
            config.put(Effects.DEATH, 0.0);
            config.put(Effects.GROWTH, 1.0);
        }
        else{ //(BonusType.WALL == bonusType){
            config = new HashMap<>();
            config.put(Effects.DEATH, 1.0);
            config.put(Effects.GROWTH, 0.0);
        }

    }
    public BonusInfo getBonusInfo(){
        return new BonusInfo(x, y, bonusType);
    }
}

