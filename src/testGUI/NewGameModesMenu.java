package testGUI;

import java.awt.*;

/**
 * Created by Alexqq11 on 02.12.2016.
 */
public class NewGameModesMenu {

    private Game.MouseAction mouseAction;
    private Graphics g;
    private int parentWidth;
    private int parentHeight;
    private MenuButton singleGame;
    private MenuButton gameWithBot;
    private MenuButton another;
    private MenuButton returnToMain;
    private Color backgroundColor;
    private String header;
    private Color headerColor;
    private Font headerFont;
    private boolean componentsAreEnabled = false;

    public void setBackgroundColor(Color color) {
        this.backgroundColor = color;

    }

    public void setHeaderColor(Color color) {
        this.headerColor = color;
    }

    public void setHeaderFont(Font font) {
        this.headerFont = font;
    }

    private Point calculateButtonsPosition() {
        int x = (parentWidth - 260) / 2;
        int y = parentHeight / 16;
        return new Point(x, y);

    }

    protected NewGameModesMenu (int parentWidth, int parentHeight, Game.MouseAction mouseAction) {
        this.parentWidth = parentWidth;
        this.parentHeight = parentHeight;
        //this.g = drawer;
        this.mouseAction = mouseAction;

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
        int OffsetOY = parentHeight / 16;
        singleGame = new MenuButton(startPoint.x, startPoint.y, 200, OffsetOY * 2, " Single Game", mouseAction);
        gameWithBot = new MenuButton(startPoint.x, startPoint.y + OffsetOY * 4, 200, OffsetOY * 2, " Game with Bot", mouseAction);
        another = new MenuButton(startPoint.x, startPoint.y + OffsetOY * 8, 200, OffsetOY * 2, " Another ", mouseAction);
        returnToMain = new MenuButton(startPoint.x, startPoint.y + OffsetOY * 12, 200, OffsetOY * 2, " main Menu ", mouseAction);

    }

    private void drawMenuBody() {
        Point startPoint = calculateButtonsPosition();
        g.setColor(backgroundColor);
        g.fillRect(0, 0, parentWidth, parentHeight);
        g.setColor(headerColor);
        g.setFont(headerFont);
        g.drawString(header, startPoint.x, 0);
    }

    public boolean getSingleGameButtonClickedState() {
        return singleGame.isClicked();
    }

    public boolean getGameWithBotButtonClickedState() {
        return gameWithBot.isClicked();
    }

    public boolean getAnotherButtonClickedState() {
        return another.isClicked();
    }

    public boolean getReturnToMainButtonClicedState() {
        return returnToMain.isClicked();
    }

    public void render(Graphics g) {

        if (!componentsAreEnabled) {
            this.g = g;
            initMenuBody();
            initButtons();
            componentsAreEnabled = true;
        }
        drawMenuBody();
        singleGame.update(g);
        gameWithBot.update(g);
        another.update(g);
        returnToMain.update(g);
    }

}


