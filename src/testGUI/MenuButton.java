package testGUI;

import java.awt.*;

/**
 * Created by Alexqq11 on 01.12.2016.
 */
public  class MenuButton{
    private int x;
    private int y;
    private int width;
    private int height;
    private Rectangle locationArea;
    private String content;
    private Color buttonStaticBackgroundColor;
    private Color buttonTriggeredBackgroundColor;
    private Color buttonContentStaticColor;
    private Color buttonContentTriggeredColor;
    private Font textContentFont;
    private boolean isSelected;
    private boolean isClicked;
    private Graphics g;
    private Game.MouseAction mouseAction;

    public MenuButton(int x, int  y, int  width, int height, String textContent,Game.MouseAction mouseAction){
       // this.g = g;
        this.mouseAction = mouseAction;
        this.x = x;
        this.y = y;
        this.width =  width;
        this.height = height;
        this.locationArea = new Rectangle(x,y,width,height);
        this.content = textContent;
        this.buttonTriggeredBackgroundColor = new Color(150, 80, 40);
        this.buttonStaticBackgroundColor =  new Color(50,50,50);
        this.buttonContentStaticColor = new Color(180,180,180);
        this.buttonContentTriggeredColor = new Color(60,60,60);
        this.textContentFont = new Font("arial", Font.BOLD, 28);
        this.isSelected = false;
        this.isClicked = false;

    }
    protected void setButtonTriggeredBackgroundColor(Color color){
        this.buttonTriggeredBackgroundColor = color;
    }

    protected void setButtonStaticBackgroundColor(Color color){
        this.buttonStaticBackgroundColor = color;
    }

    protected void setContentFont(Font font){
        this.textContentFont = font;
    }

    protected void setButtonContentStaticColor(Color color){
        this.buttonContentStaticColor = color;
    }

    protected void setButtonContentTriggeredColor(Color color){
        this.buttonContentTriggeredColor = color;
    }

    private  Color determineBackgroundColor(){
        if(isSelected){
            return this.buttonTriggeredBackgroundColor;

        }
        else{
            return  this.buttonStaticBackgroundColor;
        }

    }

    private Color determineContentColor(){
        if(isSelected){
            return this.buttonContentTriggeredColor;
        }
        else
        {
            return this.buttonContentStaticColor;
        }
    }

    private Point calculateTextPosition(){
        int ty  = height / 2 ;
        int tx =  10; // think about symbol size
        return  new Point(x + tx, y + ty);
    }

    private void drawButton(Graphics g){
        g.setColor(determineBackgroundColor());
        g.fillRect(x,y,width,height);
        Point textPosition = calculateTextPosition();
        g.setColor(determineContentColor());
        g.drawString(content, textPosition.x, textPosition.y);

    }
    private void checkInsideState(){
        if (this.locationArea.contains(mouseAction.location)){
            this.isSelected = true;
            this.isClicked = mouseAction.click;
        }
        else{
            this.isSelected = false;
            this.isClicked = false;
        }
    }
    protected void update(Graphics g){
        this.g = g;
        checkInsideState();
        drawButton(g);
    }
    public boolean isClicked(){
        return isClicked;
    }

}