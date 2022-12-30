package L_And_F;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;


public class RoundJPassField extends JPasswordField {
    public Shape shape;
    public RoundJPassField(int size) {
        super(size);
        setOpaque(false); // As suggested by @AVD in comment.
    }
    protected void paintComponent(Graphics g) {
         g.setColor(Color.white);
         g.fillRoundRect(0, 0, getWidth()-1, getHeight()-1, 10, 10);
         super.paintComponent(g);
    }
    protected void paintBorder(Graphics g) {
         g.setColor(Color.white);
         g.drawRoundRect(0, 0, getWidth()-1, getHeight()-1, 10, 10);
    }
    public boolean contains(int x, int y) {
         if (shape == null || !shape.getBounds().equals(getBounds())) {
             shape = new RoundRectangle2D.Float(0, 0, getWidth()-1, getHeight()-1, 10, 10);
         }
         return shape.contains(x, y);
    }
}