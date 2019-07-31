import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JTextField;

public class TextInputBox extends JFrame {
	JTextField textField = new JTextField(10);

    TextInputBox(TextInputButton.TextBoxState textBoxState) {
        getContentPane().add(textField);
        this.pack();
        this.setVisible(true);
        textField.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	textBoxState.notifying();
            }
        });
    }
    public String getText() {
    	return textField.getText();
    }
}
