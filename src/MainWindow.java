import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

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

    private void setPlainResult()
    {
        Result1Label.setText("P=");
    }

    private void setVolumeResult()
    {
        Result1Label.setText("V=");
    }
}
