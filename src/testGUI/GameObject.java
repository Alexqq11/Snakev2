package testGUI;

import Entities.BonusType;

import java.awt.*;

/**
 * Created by Alexqq11 on 14.12.2016.
 */
/*
interface  Visitor{
    public void visit(DrawerSnakePart gameoObject);
    public void visit(DrawerGameObjectApple gameObject);
    public void visit(DrawerGameObjectWall gameObject);
    public void visit(DrawerGameObjectPech gameObject);
    public void visit(DrawerGameObjectMushroom gameObject);
    public void visit(DrawerGameObjectSweet gameObject);


    //#public void visit(Object obj);



}
public abstract class GameObject implements Visitor{
    public Point position;
    public BonusType finalType;
    public abstract void accept ( Visitor v );
    public void draw(){};
}

public class DrawerSnakePart extends GameObject {
    public void accept(Visitor v) {
        v.visit(this);
    }

    public void draw(Graphics g, Point entity, Color color) {
        int width = 10;
        int height = 10;
        g.setColor(color.BLACK);
        g.fillRect(entity.x * width, entity.y * height, width, height);
        g.setColor(color.CYAN);
        g.fillRect(entity.x * width + 2, entity.y * height + 2, width - 4, height - 4);
}
public class DrawerGameObjectApple extends GameObject {
    public void accept ( Visitor v ) {
        v.visit( this );
    }
    public void draw(Graphics g, Point entity, Color color) {
        int width = 10;
        int height = 10;
        g.setColor(color.GREEN);
        g.fillRect(entity.x * width, entity.y * height, width, height);
        g.setColor(color.YELLOW);
        g.fillRect(entity.x * width + 2, entity.y * height + 2, width - 4, height - 4);
    }
}
public class DrawerGameObjectWall extends GameObject {
    public void accept ( Visitor v ) {
        v.visit( this );
    }
    public void draw(Graphics g, Point entity, Color color) {
        int width = 10;
        int height = 10;
        g.setColor(color.DARK_GRAY);
        g.fillRect(entity.x * width, entity.y * height, width, height);
        g.setColor(color.GRAY);
        g.fillRect(entity.x * width + 2, entity.y * height + 2, width - 4, height - 4);
    }
}
public class DrawerGameObjectPech extends GameObject {
    public void accept(Visitor v) {
        v.visit(this);
    }

    public void draw(Graphics g, Point entity, Color color) {
        int width = 10;
        int height = 10;
        g.setColor(color.ORANGE);
        g.fillRect(entity.x * width, entity.y * height, width, height);
        g.setColor(color.RED);
        g.fillRect(entity.x * width + 2, entity.y * height + 2, width - 4, height - 4);
    }
}
public class DrawerGameObjectMushroom extends GameObject {
    public void accept ( Visitor v ) {
        v.visit( this );
    }
    public void draw(Graphics g, Point entity, Color color) {
        int width = 10;
        int height = 10;
        g.setColor(color.RED);
        g.fillRect(entity.x * width, entity.y * height, width, height);
        g.setColor(color.white);
        g.fillRect(entity.x * width + 2, entity.y * height + 2, width - 4, height - 4);
    }
}
public class DrawerGameObjectSweet extends GameObject {
    public void accept ( Visitor v ) {
        v.visit( this );
    }
    public void draw(Graphics g, Point entity, Color color) {
        int width = 10;
        int height = 10;
        g.setColor(color.black);
        g.fillRect(entity.x * width, entity.y * height, width, height);
        g.setColor(color.WHITE);
        g.fillRect(entity.x * width + 2, entity.y * height + 2, width - 4, height - 4);
    }

}

*/
