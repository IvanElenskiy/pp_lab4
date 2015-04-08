import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.GeneralPath;
import java.awt.geom.Rectangle2D;
import java.io.File;

/**
 * Created by Andrew on 07.04.2015.
 */
public class ShapePanel extends JPanel {
    //@Override

    private int Figure=0;
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;
        //@SuppressWarnings("deprecation")


        switch(Figure)
        {
            case 0: //Параллелепипед
                try {
                    java.awt.Image bitmap = ImageIO.read(new File("images\\0.jpg"));
                    g2.drawImage(bitmap, 0, 0, 500, 500, this);
                }
                catch (Exception ex)
                {
                System.out.println("NOPE");
                }



                break;
            case 1: //Сфера
                try {
                    java.awt.Image bitmap = ImageIO.read(new File("images\\1.jpg"));
                    g2.drawImage(bitmap, 0, 0, 500, 500, this);
                }
                catch (Exception ex)
                {
                    System.out.println("NOPE");
                }
                break;
            case 2: //Цилиндр
                try {
                    java.awt.Image bitmap = ImageIO.read(new File("images\\2.jpg"));
                    g2.drawImage(bitmap, 0, 0, 500, 500, this);
                }
                catch (Exception ex)
                {
                    System.out.println("NOPE");
                }
                break;
            case 3: //Конус
                try {
                    java.awt.Image bitmap = ImageIO.read(new File("images\\3.jpg"));
                    g2.drawImage(bitmap, 0, 0, 500, 500, this);
                }
                catch (Exception ex)
                {
                    System.out.println("NOPE");
                }
                break;
            case 4: //Треугольник
                try {
                    java.awt.Image bitmap = ImageIO.read(new File("images\\4.jpg"));
                    g2.drawImage(bitmap, 0, 0, 500, 500, this);
                }
                catch (Exception ex)
                {
                    System.out.println("NOPE");
                }
                break;
            case 5: //Прямоугольник
                try {
                    java.awt.Image bitmap = ImageIO.read(new File("images\\5.jpg"));
                    g2.drawImage(bitmap, 0, 0, 500, 500, this);
                }
                catch (Exception ex)
                {
                    System.out.println("NOPE");
                }
                break;
            case 6: //Круг
                try {
                    java.awt.Image bitmap = ImageIO.read(new File("images\\6.jpg"));
                    g2.drawImage(bitmap, 0, 0, 500, 500, this);
                }
                catch (Exception ex)
                {
                    System.out.println("NOPE");
                }
                break;
            default:

        }
    }

    public void ChangePicture(int pictype)
    {
        Figure = pictype;
        repaint();
    }

}
