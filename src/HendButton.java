import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class HendButton extends JButton {
	StateManager stateManager;

	public HendButton(StateManager stateManager) {
		super("Hendecagonal");
		addActionListener(new HendListener());
		this.stateManager = stateManager;
	}

	class HendListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			stateManager.setState(new HendState(stateManager));
		}
	}

	class HendState implements State {
		StateManager stateManager;

		public HendState(StateManager stateManager) {
			this.stateManager = stateManager;
		}

		public void mouseDown(int x, int y) {
			stateManager.addDrawing(new MyHendecagonal(x, y));
		}

		public void mouseUp(int x, int y) {}
		public void mouseDrag(int x, int y) {}
	}
}
