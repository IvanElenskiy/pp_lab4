import javax.swing.*;
import java.awt.*;
import java.awt.geom.GeneralPath;
import java.awt.geom.Rectangle2D;

/**
 * Created by Andrew on 07.04.2015.
 */
public class ShapePanel extends JPanel {
    @Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;
        @SuppressWarnings("deprecation")
        Rectangle2D bounds = g2.getClipRect();
        Double width = bounds.getWidth()*0.5;
        Double height = width / 3;
        Double top = bounds.getHeight()*0.25;
        Double left = bounds.getWidth()*0.25;
        Rectangle2D whiteRect = new Rectangle2D.Double(left, top, width, height);
        Rectangle2D redRect = new Rectangle2D.Double(left, top + height, width, height);
        GeneralPath blueTriangle = new GeneralPath();
        blueTriangle.moveTo(left, top);
        blueTriangle.lineTo(left + width / 2, top + height);
        blueTriangle.lineTo(left, top + 2 * height);
        blueTriangle.closePath();
        g2.setPaint(Color.WHITE);
        g2.fill(whiteRect);
        g2.setPaint(Color.RED);
        g2.fill(redRect);
        g2.setPaint(Color.BLUE);
        g2.fill(blueTriangle);
    }

}
