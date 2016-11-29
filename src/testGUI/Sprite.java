package testGUI;

import java.awt.*;

public class Sprite {

    /*public Sprite(Image image) {
        this.image = image;
    }

    public int getWidth() {
        return image.getWidth(null);
    }

    public int getHeight() {
        return image.getHeight(null);
    }
*/
    public void draw(Graphics g,int x,int y) {
        g.setColor(Color.black);
        g.fillRect(x * 50, y * 50  , 50, 50);;
    }
}