package testGUI;

import java.awt.*;
import java.util.LinkedList;

/**
 * Created by Alexqq11 on 02.12.2016.
 */
public class UniversalMenu {

    private Game.MouseAction mouseAction;
    private Graphics g;
    private int parentWidth;
    private int parentHeight;
    private LinkedList<MenuButton> menuButtons;
    private LinkedList<String> buttonsNames;
    private Color backgroundColor;
    private String header;
    private Color headerColor;
    private Font headerFont;
    private double widthPersentage = 0.4;
    private boolean componentsAreEnabled = false;

    public void setBackgroundColor(Color color) {this.backgroundColor = color;}

    public void setHeaderColor(Color color) {
        this.headerColor = color;
    }

    public void setHeaderFont(Font font) {
        this.headerFont = font;
    }
    public void setWidthPersentage(int persent){
        this.widthPersentage = persent / 100.0;
    }
    private Point calculateButtonsPosition() {
        int x = (parentWidth - 260) / 2;
        int y = parentHeight / 16;
        return new Point(x, y);

    }

    public UniversalMenu(int parentWidth, int parentHeight, LinkedList<String> buttonsNames, Game.MouseAction mouseAction) {
        this.parentWidth = parentWidth;
        this.parentHeight = parentHeight;
        //this.g = drawer;
        this.mouseAction = mouseAction;
        this.buttonsNames = buttonsNames;

    }

    private void initMenuBody() {
        backgroundColor = Color.black;
        headerColor = new Color(200, 250, 200);
        headerFont = new Font("arial", Font.BOLD, 14);
        header = "SNAKE GAME";
        drawMenuBody();
    }

    private void initButtons() {
        Point startPoint = calculateButtonsPosition();
        int OffsetOY = parentHeight / (4 * buttonsNames.size());
        menuButtons = new LinkedList<>();
        int startOffset = 0;
        for (int i = 0; i < buttonsNames.size(); i++){
            menuButtons.add(new MenuButton(startPoint.x, startPoint.y + OffsetOY * startOffset , (int)(widthPersentage*parentWidth), OffsetOY * 2 , buttonsNames.get(i), mouseAction));
            startOffset += 4;
        }
        /*
        singleGame = new MenuButton(   startPoint.x,   startPoint.y + OffsetOY * 0,  200, OffsetOY * 2, " Single Game",   mouseAction);
        gameWithBot = new MenuButton(  startPoint.x,   startPoint.y + OffsetOY * 4,  200, OffsetOY * 2, " Game with Bot", mouseAction);
        another = new MenuButton(      startPoint.x,   startPoint.y + OffsetOY * 8,  200, OffsetOY * 2, " Another ",      mouseAction);
        returnToMain = new MenuButton( startPoint.x,   startPoint.y + OffsetOY * 12, 200, OffsetOY * 2, " main Menu ",    mouseAction);
        */
    }

    private void drawMenuBody() {
        Point startPoint = calculateButtonsPosition();
        g.setColor(backgroundColor);
        g.fillRect(0, 0, parentWidth, parentHeight);
        g.setColor(headerColor);
        g.setFont(headerFont);
        g.drawString(header, startPoint.x, 0);
    }

    public boolean getButtonState(int index) {
        return menuButtons.get(index).isClicked();
    }
    public int getButtonsAmount(){
        return  menuButtons.size();
    }
    public String getButtonContent(int index){
        return buttonsNames.get(index);
    }
    public void updateComponents(Graphics g){
        for (MenuButton button : menuButtons){
            button.update(g);
        }
    }
    public void render(Graphics g) {

        if (!componentsAreEnabled) {
            this.g = g;
            initMenuBody();
            initButtons();
            componentsAreEnabled = true;
        }
        drawMenuBody();
        updateComponents(g);
    }


}
