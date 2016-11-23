package WindowGUI;

import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by Alexqq11 on 23.11.2016.
 */
public class Screen extends JPanel implements Runnable{
    private static final long serialVersionUID = 1L;
    public static final int WIDTH = 800, HEIGHT = 800;
    private Thread thread;
    private boolean running  = false;
    private Key key;
    public Screen(){
        setFocusable(true);
        key = new Key();
        addKeyListener(key);
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        start();
    }
    public void tick() {
       System.out.println("it works ....");
    }
    public void drawEntity(Graphics g, Point entity, Color color){
        int width = 10;
        int height = 10;
        g.setColor(Color.black);
        g.fillRect(entity.x * width, entity.y * height  , width, height);
        g.setColor(color);
        g.fillRect(entity.x * width + 2, entity.y  * height  + 2 , width - 4, height -4);

    }
    public void paint(Graphics g){
        g.clearRect(0,0,WIDTH,HEIGHT);
        g.setColor(Color.black);
        g.setColor(new Color(10,50,0));
        g.fillRect(0,0,WIDTH,HEIGHT);
        g.setColor(Color.black);
        for (int i = 0; i < WIDTH / 10; i++){
            g.drawLine(i*10, 0, i*10 , HEIGHT);
        }
        for(int i = 0; i < HEIGHT /10; i++){
            g.drawLine(0, i*10, WIDTH, i *10);
        }
        drawEntity(g, new Point(10, 10), Color.cyan);

    }
    public void start(){
        running = true;
        thread = new Thread(this, "Game Loop"); //this, "Game Loop");
        thread.start();

    }
    public void stop(){

    }
    public void run(){
        while (running){
            tick();
            repaint();
        }
    }
    private class Key implements KeyListener{

        @Override
        public void keyTyped(KeyEvent e) {
            int key = e.getKeyCode();
            if (key == KeyEvent.VK_RIGHT){
                System.out.println("right");
                running = false;
            }// && !left if we want chek input in this stage not in snake
            if (key == KeyEvent.VK_LEFT){
                System.out.println("left");
            }
            if (key == KeyEvent.VK_UP){
                System.out.println("up");
            }
            if (key == KeyEvent.VK_DOWN){
                System.out.println("down");
            }
        }

        @Override
        public void keyPressed(KeyEvent e) {

        }

        @Override
        public void keyReleased(KeyEvent e) {

        }
    }

}
