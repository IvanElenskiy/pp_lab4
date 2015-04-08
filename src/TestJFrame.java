import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JTextField;

//Example
public class TestJFrame {
	private JTextField arg1 = new JTextField();
	
	private boolean verificationString(String testString) {
		Pattern p = Pattern.compile("^\\d+\\.?\\d*$");
        Matcher m = p.matcher(testString);  
        return m.matches();  
	}
	
	TestJFrame() {
		arg1.addKeyListener(new KeyAdapter() {
			boolean valid = false;
			
			@Override
		    public void keyPressed(KeyEvent e) {
				if( ((e.getKeyCode() < 96) || (e.getKeyCode() > 105)) && ((e.getKeyCode() != 46) && (e.getKeyCode() != 110)) )
		    		valid = false;
				else if( !verificationString(arg1.getText() + e.getKeyChar()) )
					valid = false;
		    	else
		    		valid = true;
		    }
			
		    @Override
		    public void keyTyped(KeyEvent e) {
		    	if( !valid )
		    		e.consume();
		    }
		});
	}
}