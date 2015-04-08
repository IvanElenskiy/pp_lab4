import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JTextField;

/**
 * Created by Andrew on 06.04.2015.
 */
public class MainWindow implements ListSelectionListener {
    private JList ShapeList;
    private JTextField Arg1;
    private JTextField Arg2;
    private JPanel MainPanel;
    private ShapePanel ShapeView;
    private JLabel Arg1Label;
    private JLabel Arg2Label;
    private JLabel Result1Label;
    private JLabel Result2Label;
    private JLabel Arg3Label;
    private JTextField Arg3;
    private JLabel Result1;
    private JLabel Result2;

    public static void main(String[] args) {
        JFrame frame = new JFrame("MainWindow");
        frame.setContentPane(new MainWindow().MainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1024, 768);
        frame.setVisible(true);
    }

    private void createUIComponents() {
        ShapeList = new JList();
        ShapeList.addListSelectionListener(this);

        Arg1 = new JTextField();
        Arg1.addKeyListener(new KeyAdapter() {
            boolean valid = false;

            @Override
            public void keyPressed(KeyEvent e) {
                if (((e.getKeyCode() < 96) || (e.getKeyCode() > 105)) && ((e.getKeyCode() != 46) && (e.getKeyCode() != 110)))
                    valid = false;
                else if (!verificationString(Arg1.getText() + e.getKeyChar()))
                    valid = false;
                else
                    valid = true;
            }

            @Override
            public void keyTyped(KeyEvent e) {
                if (!valid)
                    e.consume();
                else
                    doTask();
            }
        });

        Arg2 = new JTextField();
        Arg2.addKeyListener(new KeyAdapter() {
            boolean valid = false;

            @Override
            public void keyPressed(KeyEvent e) {
                if (((e.getKeyCode() < 96) || (e.getKeyCode() > 105)) && ((e.getKeyCode() != 46) && (e.getKeyCode() != 110)))
                    valid = false;
                else if (!verificationString(Arg2.getText() + e.getKeyChar()))
                    valid = false;
                else
                    valid = true;
            }

            @Override
            public void keyTyped(KeyEvent e) {
                if (!valid)
                    e.consume();
                else
                    doTask();
            }
        });

        Arg3 = new JTextField();
        Arg3.addKeyListener(new KeyAdapter() {
            boolean valid = false;

            @Override
            public void keyPressed(KeyEvent e) {
                if (((e.getKeyCode() < 96) || (e.getKeyCode() > 105)) && ((e.getKeyCode() != 46) && (e.getKeyCode() != 110)))
                    valid = false;
                else if (!verificationString(Arg3.getText() + e.getKeyChar()))
                    valid = false;
                else
                    valid = true;
            }

            @Override
            public void keyTyped(KeyEvent e) {
                if (!valid)
                    e.consume();
                else
                    doTask();
            }
        });
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        switch(ShapeList.getSelectedIndex())
        {
            case 0: //Параллелепипед
                Arg1Label.setText("Длина");
                Arg1.setEnabled(true);
                Arg2Label.setText("Высота");
                Arg2.setEnabled(true);
                Arg3Label.setText("Ширина");
                Arg3.setEnabled(true);
                setVolumeResult();
                break;
            case 1: //Сфера
                Arg1Label.setText("Радиус");
                Arg1.setEnabled(true);
                Arg2Label.setText("");
                Arg2.setEnabled(false);
                Arg3Label.setText("");
                Arg3.setEnabled(false);
                setVolumeResult();
                break;
            case 2: //Цилиндр
                Arg1Label.setText("Радиус");
                Arg1.setEnabled(true);
                Arg2Label.setText("Высота");
                Arg2.setEnabled(true);
                Arg3Label.setText("");
                Arg3.setEnabled(false);
                setVolumeResult();
                break;
            case 3: //Конус
                Arg1Label.setText("Радиус");
                Arg1.setEnabled(true);
                Arg2Label.setText("Высота");
                Arg2.setEnabled(true);
                Arg3Label.setText("");
                Arg3.setEnabled(false);
                setVolumeResult();
                break;
            case 4: //Треугольник
                Arg1Label.setText("Сторона 1");
                Arg1.setEnabled(true);
                Arg2Label.setText("Сторона 2");
                Arg2.setEnabled(true);
                Arg3Label.setText("Сторона 3");
                Arg3.setEnabled(true);
                setPlainResult();
                break;
            case 5: //Прямоугольник
                Arg1Label.setText("Длина");
                Arg1.setEnabled(true);
                Arg2Label.setText("Ширина");
                Arg2.setEnabled(true);
                Arg3Label.setText("");
                Arg3.setEnabled(false);
                setPlainResult();
                break;
            case 6: //Круг
                Arg1Label.setText("Радиус");
                Arg1.setEnabled(true);
                Arg2Label.setText("");
                Arg2.setEnabled(false);
                Arg3Label.setText("");
                Arg3.setEnabled(false);
                setPlainResult();
                break;
            default:
                Arg1Label.setText("");
                Arg1.setEnabled(false);
                Arg2Label.setText("");
                Arg2.setEnabled(false);
                Arg3Label.setText("");
                Arg3.setEnabled(false);
        }
           ShapeView.ChangePicture(ShapeList.getSelectedIndex());
    }

    private void setPlainResult() { Result1Label.setText("P="); }

    private void setVolumeResult()
    {
        Result1Label.setText("V=");
    }

    private boolean verificationString(String testString) {
        Pattern p = Pattern.compile("^\\d+\\.?\\d*$");
        Matcher m = p.matcher(testString);
        
        return m.matches();
    }

    private void doTask()
    {
        Result res = new Result(0,0,0);
        switch(ShapeList.getSelectedIndex())
        {
            case 0: //Параллелепипед
                if (!Arg1.getText().isEmpty()&&!Arg2.getText().isEmpty()&&!Arg3.getText().isEmpty()) {
                    System.out.println(Arg1.getText()+" "+Arg2.getText()+" "+Arg3.getText());
                    res = FigCalc.calcParallelepiped(Double.parseDouble(Arg1.getText()), Double.parseDouble(Arg2.getText()), Double.parseDouble(Arg3.getText()));
                }
                break;
            case 1: //Сфера
                if (!Arg1.getText().isEmpty())
                    res = FigCalc.calcSphere(Double.parseDouble(Arg1.getText()));
                break;
            case 2: //Цилиндр
                if (!Arg1.getText().isEmpty()&&!Arg2.getText().isEmpty())
                    res = FigCalc.calcCylinder(Double.parseDouble(Arg1.getText()), Double.parseDouble(Arg2.getText()));
                break;
            case 3: //Конус
                if (!Arg1.getText().isEmpty()&&!Arg2.getText().isEmpty())
                    res = FigCalc.calcCone(Double.parseDouble(Arg1.getText()), Double.parseDouble(Arg2.getText()));
                break;
            case 4: //Треугольник
                if (!Arg1.getText().isEmpty()&&!Arg2.getText().isEmpty()&&!Arg3.getText().isEmpty())
                    res = FigCalc.calcTriangle(Double.parseDouble(Arg1.getText()), Double.parseDouble(Arg2.getText()), Double.parseDouble(Arg3.getText()));
                break;
            case 5: //Прямоугольник
                if (!Arg1.getText().isEmpty()&&!Arg2.getText().isEmpty())
                    res = FigCalc.calcRectangle(Double.parseDouble(Arg1.getText()), Double.parseDouble(Arg2.getText()));
                break;
            case 6: //Круг
                if (!Arg1.getText().isEmpty())
                    res = FigCalc.calcCircle(Double.parseDouble(Arg1.getText()));
                break;
            default:
                break;
        }
        Double a = res.getA();
        Result2.setText(a.toString());
        Double b = res.getV();
        if (b==-1)
        {
            b = res.getP();
        }
        Result1.setText(b.toString());
    }
}
