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
		MyDrawing myOval;

		public OvalState(StateManager stateManager) {
			this.stateManager = stateManager;
		}

		public void mouseDown(int x, int y) {
			stateManager.addDrawing(myOval = new MyOval(x, y, 0, 0));
		}

		public void mouseUp(int x, int y) {
			if (!stateManager.getDashed())
				myOval.setDashed(false);
		}
		public void mouseDrag(int x, int y) {
			myOval.setDashed(true);
			myOval.setSize(x-myOval.getX(), y-myOval.getY());
		}
	}
}