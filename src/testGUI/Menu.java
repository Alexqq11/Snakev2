package testGUI;

import java.awt.*;

/**
 * Created by Alexqq11 on 01.12.2016.
 */
public class Menu {
    //int parentWidth;
    //int parentHeght
    private Game.MouseAction mouseAction;
            ;
    public Rectangle rtc = new Rectangle(1,1,1,1);
    Graphics drawer;
    protected Menu(Graphics drawer, Game.MouseAction mouseAction){
        //this.parentWidth = parentWidth;
        //this.parentHeght = parentHeght;
        this.drawer = drawer;
        this.mouseAction = mouseAction;

    }

    private class MenuButton{
        int x;
        int y;
        int width;
        int height;
        Rectangle locationArea;
        String content;
        Color withOutSelect;
        Color underSelect;
        Font textContentFont;
        protected void setSelectColor(Color color){
            this.underSelect = color;
        }
        protected void setNotSelectColor(Color color){
         this.withOutSelect = color;
        }
        protected  void setContentFont(Font font){
            this.textContentFont = font;
        }

        MenuButton(int x, int  y, int  width, int height, String textContent){
            this.x = x;
            this.y = y;
            this.width =  width;
            this.height = height;
            this.locationArea = new Rectangle(x,y,width,height);
            this.content = textContent;
            this.underSelect = new Color(150, 80, 40);
            this.withOutSelect =  new Color(50,50,50);
            this.textContentFont = new Font("arial", Font.BOLD, 28);

        }
        protected void drawButton(Graphics g){
            

        }

    }
}
