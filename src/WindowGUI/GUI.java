package WindowGUI;

/**
 * Created by Alexqq11 on 23.11.2016.
 */
import java.awt.GridLayout;
import javax.swing.JFrame;

public class GUI extends JFrame{
    public GUI(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Snake");
        init();

    }
    public void init(){
        setLayout(new GridLayout(1,1,0,0));
        Screen s = new Screen();
        add(s);
        setLocationRelativeTo(null);
        setVisible(true);

    }
    public static void main(String[] args){
        new GUI();
    }
}
