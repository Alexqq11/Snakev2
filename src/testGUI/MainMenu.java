package testGUI;

import java.awt.*;

/**
 * Created by Alexqq11 on 01.12.2016.
 */
public class MainMenu {
    private Game.MouseAction mouseAction;
    private Graphics g;
    private int parentWidth;
    private int parentHeight;
    private MenuButton newGame;
    private MenuButton settings;
    private MenuButton help;
    private MenuButton exit;
    private Color backgroundColor;
    private String header;
    private Color headerColor;
    private Font headerFont;
    private boolean componentsAreEnabled = false;
    public void setBackgroundColor(Color color){
        this.backgroundColor = color;

    }
    public void setHeaderColor(Color color){
        this.headerColor = color;
    }
    public void setHeaderFont(Font font){
        this.headerFont = font;
    }
    private Point calculateButtonsPosition(){
        int x = (parentWidth  - 260) / 2 ;
        int y = parentHeight / 16;
        return new Point(x,y);

    }

    protected MainMenu(int parentWidth, int parentHeight, Game.MouseAction mouseAction){
        this.parentWidth = parentWidth;
        this.parentHeight = parentHeight;
        //this.g = drawer;
        this.mouseAction = mouseAction;

    }
    private void initMenuBody(){
        backgroundColor = Color.black;
        headerColor = new Color( 200, 250, 200);
        headerFont = new Font("arial",Font.BOLD, 14);
        header = "SNAKE GAME";
        drawMenuBody();
    }

    private void initButtons() {
        Point startPoint = calculateButtonsPosition();
        int OffsetOY = parentHeight / 16;
        newGame = new MenuButton(startPoint.x, startPoint.y, 200, OffsetOY * 2, " NEW GAME ",mouseAction);
        settings = new MenuButton(startPoint.x, startPoint.y + OffsetOY * 4, 200, OffsetOY * 2, " SETTINGS ",mouseAction);
        help = new MenuButton(startPoint.x, startPoint.y + OffsetOY * 8, 200, OffsetOY * 2, " HELP ",mouseAction);
        exit = new MenuButton(startPoint.x, startPoint.y + OffsetOY * 12, 200, OffsetOY * 2, " EXIT ",mouseAction);

    }
    private void drawMenuBody(){
        Point startPoint = calculateButtonsPosition();
        g.setColor(backgroundColor);
        g.fillRect(0,0,parentWidth,parentHeight);
        g.setColor(headerColor);
        g.setFont(headerFont);
        g.drawString(header, startPoint.x, 0);
    }
    public boolean getNewGameButtonClickedState(){
        return newGame.isClicked();
    }
    public boolean getSettingsButtonClickedState(){
        return settings.isClicked();
    }
    public boolean getHelpButtonClickedState(){
        return help.isClicked();
    }
    public boolean getExitButtonClicedState(){
        return exit.isClicked();
    }
    public void render(Graphics g){

        if (!componentsAreEnabled){
            this.g = g;
            initMenuBody();
            initButtons();
            componentsAreEnabled = true;
        }
        drawMenuBody();
        newGame.update(g);
        settings.update(g);
        help.update(g);
        exit.update(g);
    }

}
