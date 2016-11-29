package Entities;

/**
 * Created by Alexqq11 on 16.11.2016.
 */
public class BonusInfo {
    public int x;
    public int y;
    public BonusType bonusType;
    BonusInfo(int x, int y , BonusType type){
        this.x = x;
        this.y = y;
        this.bonusType = type;

    }
}
