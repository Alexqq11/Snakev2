package testGUI;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Alexqq11 on 01.12.2016.
 */
public class GUI {
    public static void main(String[] args) {
        int WIDTH  = 400;
        int HEIGHT = 300;
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
}
