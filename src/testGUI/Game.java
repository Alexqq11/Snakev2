package testGUI;

import  Core.API;
import Core.GameType;
import Entities.*;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferStrategy;
import java.util.LinkedList;

public class Game extends Canvas implements Runnable {
    private static final long serialVersionUID = 1L;

    private boolean running;

    public static int WIDTH = 400;
    public static int HEIGHT = 300;
    public static String NAME = "TUTORIAL 1";

    private boolean leftPressed = false;
    private boolean rightPressed = false;
    private boolean downPressed = false;
    private boolean upPressed = false;
    private boolean gameLose = false;
    private boolean gameRunned = false;

    private MouseAction mouseAction;

    private MainMenu mainMenu;

    private static int x = 0;
    private static int y = 0;
    private API api;
    LinkedList<SnakeInfo> snakes; //= api.getSnakesInformation();
    LinkedList<BonusInfo> bonuses; //= api.getBonusesInformation();
    private static int tick;
    public void start() {
        running = true;
        new Thread(this).start();
    }

    public void run() {

        init();

        while (running) {

            render();
            update();

            snakes = api.getSnakesInformation();
            bonuses = api.getBonusesInformation();
            for (SnakeInfo snake : snakes) {
                gameLose = !snake.isAlive;
            }
            if(gameLose){
                if (upPressed){
                    api = new API(GameType.USER);
                    snakes = api.getSnakesInformation();
                    bonuses = api.getBonusesInformation();
                    gameLose = false;
                }
            }
            tick++;

        }
    }

    public void init() {
        addKeyListener(new KeyInputHandler());
        addMouseMotionListener(new MouseMotionHandler());
        addMouseListener(new MouseInputHandler());
        mouseAction = new MouseAction(new Point(-1, -1), false);
        mainMenu = new MainMenu(getWidth(), getHeight(), this.mouseAction);
        api = new API(GameType.USER);
        snakes = api.getSnakesInformation();
        bonuses = api.getBonusesInformation();

    }
    public void drawEntity(Graphics g, Point entity, Color color) {
        int width = 10;
        int height = 10;
        g.setColor(Color.black);
        g.fillRect(entity.x * width, entity.y * height, width, height);
        g.setColor(color);
        g.fillRect(entity.x * width + 2, entity.y * height + 2, width - 4, height - 4);
    }
    public void render() {
        BufferStrategy bs = getBufferStrategy();
        if (bs == null) {
            createBufferStrategy(2);
            requestFocus();
            return;
        }
        if (api == null){
            return;
        }
        Graphics g = bs.getDrawGraphics();

        if (gameRunned) {
            g.setColor(new Color(20, 100, 10));
            g.fillRect(0, 0, getWidth(), getHeight());
            g.setColor(Color.BLACK);
            for (int i = 0; i <= WIDTH / 10; i++) {
                g.drawLine(i * 10, 0, i * 10, HEIGHT);
            }
            for (int i = 0; i <= HEIGHT / 10; i++) {
                g.drawLine(0, i * 10, WIDTH, i * 10);
            }
            if (!gameLose) {
                for (SnakeInfo snake : snakes) {
                    for (Point point : snake.snakePoints) {
                        drawEntity(g, point, Color.cyan);
                    }
                }
                for (BonusInfo bonusInfo : bonuses) {
                    if (bonusInfo.bonusType == BonusType.APPLE)
                        drawEntity(g, new Point(bonusInfo.x, bonusInfo.y), Color.orange);
                    else {
                        drawEntity(g, new Point(bonusInfo.x, bonusInfo.y), Color.gray);
                    }
                }
            } else {
                g.setColor(Color.BLACK);
                g.fillRect(0, 0, getWidth(), getHeight());
                g.setColor(Color.WHITE);
                g.drawString("GAME OVER", 150, 100);
                g.drawString("PRESS UP TO START NEW GAME", 100, 120);
            }
        }else{
            mainMenu.render(g);
            if(mainMenu.getNewGameButtonClickedState()){
                gameRunned = true;
            }
        }

       // hero.draw(g, x, y);
        g.dispose();
        bs.show();

    }

    public void update() {
        if (tick > 500) {
            /*if (api == null) {
                return;
            }*/

            if (leftPressed) {
                api.sendMoveSnakeEvent(1,1001, SnakeDirections.LEFT);
                x--;
            }
            if (rightPressed) {
                api.sendMoveSnakeEvent(1,1001, SnakeDirections.RIGHT);
                x++;
            }
            if (upPressed ) {
                api.sendMoveSnakeEvent(1,1001, SnakeDirections.UP);
                y--;
            }
            if (downPressed ) {
                api.sendMoveSnakeEvent(1,1001, SnakeDirections.DOWN);
                y++;
            }
            tick  = 0;
        }
    }
    protected class MouseAction{
        Point location;
        boolean click;
        MouseAction(Point location, boolean click){
            this.location = location;
            this.click = click;
        }
        void update(Point location,boolean click){
            this.location = location;
            this.click = click;
        }
    }
    private  class MouseMotionHandler implements  MouseMotionListener {

        @Override
        public void mouseDragged(MouseEvent e) {

        }

        @Override
        public void mouseMoved(MouseEvent e) {
            if (mouseAction != null)
                mouseAction.update(e.getPoint(), false);
        }
    }
    private class MouseInputHandler implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            if( mouseAction != null)
            mouseAction.update(e.getPoint(), true);
        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {


        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }
    }


    private class KeyInputHandler extends KeyAdapter {
        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                leftPressed = true;
            }
            if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                rightPressed = true;
            }
            if (e.getKeyCode() == KeyEvent.VK_UP) {
                upPressed = true;
            }
            if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                downPressed = true;
            }
        }

        public void keyReleased(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                leftPressed = false;
            }
            if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                rightPressed = false;
            }
            if (e.getKeyCode() == KeyEvent.VK_UP) {
                upPressed = false;
            }
            if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                downPressed = false;
            }
        }
    }
}
