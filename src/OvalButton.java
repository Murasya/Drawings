import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class OvalButton extends JButton {
	StateManager stateManager;

	public OvalButton(StateManager stateManager) {
		super("Oval");
		addActionListener(new OvalListener());
		this.stateManager = stateManager;
	}

	class OvalListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			stateManager.setState(new OvalState(stateManager));
		}
	}

	class OvalState implements State {
		StateManager stateManager;

		public OvalState(StateManager stateManager) {
			this.stateManager = stateManager;
		}

		public void mouseDown(int x, int y) {
			stateManager.addDrawing(new MyOval(x, y));
		}

		public void mouseUp(int x, int y) {}
		public void mouseDrag(int x, int y) {}
	}
}