import java.awt.*;
import java.util.concurrent.TimeUnit;
import java.util.Random;

public class FractalTree {
    private double branchScalingFactor;
    private double branchAngle;
    private int depth;

    public FractalTree() {
        branchScalingFactor = .8;
        branchAngle = .5;
        depth = 10;
    }

    public void draw(Graphics g) {
        g.setColor(Color.green);
        g.drawLine(400, 550, 400, 450);  //draws the trunk
        branch(g, depth, 100, 400, 450, 3*Math.PI/2);  //draws the first branches
    }

    public void branch(Graphics g, int depth, int length, int startX, int startY, double angle) {
        try {
            TimeUnit.MILLISECONDS.sleep(5);
        } catch(Exception e) {
            System.out.println("Can't wait a millisecond.");
        }

        Random rand = new Random();
        float red_val = rand.nextFloat();
        float green_val = rand.nextFloat();
        float blue_val = rand.nextFloat();

        Color c = new Color(red_val, green_val, blue_val);
        g.setColor(c);
        
        if (depth > 0) {
            double angleA = angle - branchAngle;
            double angleB = angle + branchAngle;

            double newLength = length * branchScalingFactor;

            int endX1 = (int) (length * Math.cos(angleA) + startX);
            int endY1 = (int) (length * Math.sin(angleA) + startY);

            int endX2 = (int) (length * Math.cos(angleB) + startX);
            int endY2 = (int) (length * Math.sin(angleB) + startY);

            g.drawLine(startX, startY, endX1, endY1);
            g.drawLine(startX, startY, endX2, endY2);

            branch(g, depth - 1, (int) newLength, endX1, endY1, angleA);
            branch(g, depth - 1, (int) newLength, endX2, endY2, angleB);
        }
    }
}