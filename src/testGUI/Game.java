package testGUI;

import  Core.API;
import Core.GameType;
import Entities.BonusInfo;
import Entities.SnakeDirections;
import Entities.SnakeInfo;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.LinkedList;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

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

    public static Sprite hero;
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
        long lastTime = System.currentTimeMillis();
        long delta;

        init();

        while(running) {
            delta = System.currentTimeMillis() - lastTime;
            lastTime = System.currentTimeMillis();
            render();
            update(delta);
            snakes = api.getSnakesInformation();
            bonuses = api.getBonusesInformation();
            tick++;
        }
    }

    public void init() {
        addKeyListener(new KeyInputHandler());
        hero = new Sprite();
        api = new API(GameType.USER);
        snakes = api.getSnakesInformation();
        bonuses = api.getBonusesInformation();
       // hero = getSprite("C:\\Users\\Alexqq11\\Documents\\GitHub\\Snake_V2\\src\\testGUI\\man.png");
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

        g.setColor(new Color(20,100,10));
        g.fillRect(0, 0, getWidth(), getHeight());
        g.setColor(Color.BLACK);
        for (int i = 0; i < WIDTH / 10; i++){
            g.drawLine(i*10, 0, i*10 , HEIGHT);
        }
        for(int i = 0; i < HEIGHT /10; i++){
            g.drawLine(0, i*10, WIDTH, i *10);
        }
        for (SnakeInfo snake : snakes) {
            for (Point point : snake.snakePoints) {
                drawEntity(g, point, Color.cyan);
            }
        }
        for (BonusInfo bonusInfo : bonuses){
            drawEntity(g, new Point(bonusInfo.x, bonusInfo.y), Color.orange);
        }
       // hero.draw(g, x, y);
        g.dispose();
        bs.show();

    }

    public void update(long delta) {
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



    public static void main(String[] args) {
        Game game = new Game();
        game.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        JFrame frame = new JFrame(Game.NAME);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.add(game, BorderLayout.CENTER);
        frame.pack();
        frame.setResizable(false);
        frame.setVisible(true);
        game.start();
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
