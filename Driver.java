import java.awt.*;
import javax.swing.*;

public class Driver extends JFrame {
    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;

    private FractalTree myFractalTree;

    public Driver() {
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBackground(Color.black);
        setVisible(true);
    }

    public static void main(String[] args) {
        Driver frame = new Driver();
    }

    public void paint(Graphics g) {
        myFractalTree = new FractalTree();
        myFractalTree.draw(g);
    }
}