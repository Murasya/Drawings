import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class TextInputButton extends JButton {
	StateManager stateManager;

	public TextInputButton(StateManager stateManager) {
		super("TextBox");
		addActionListener(new TextBoxListener());
		this.stateManager = stateManager;
	}

	class TextBoxListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			stateManager.setState(new TextBoxState(stateManager));
		}
	}

	class TextBoxState implements State {
		StateManager stateManager;
		TextInputBox textInputBox;
		MyTextBox myTextBox;
		int x, y;

		public TextBoxState(StateManager stateManager) {
			this.stateManager = stateManager;
		}

		public void mouseDown(int x, int y) {
			textInputBox = new TextInputBox(this);
			this.x = x; this.y = y;
		}

		public void mouseUp(int x, int y) {
		}
		public void mouseDrag(int x, int y) {
			myTextBox.setDashed(true);
			myTextBox.setSize(x-myTextBox.getX(), y-myTextBox.getY());
		}
		public void notifying() {
			textInputBox.dispose();
			String text = textInputBox.getText();
			myTextBox = new MyTextBox(text, x, y, 0, 0);
			stateManager.addDrawing(myTextBox);
			stateManager.getMediator().repaint();
		}
	}
}
