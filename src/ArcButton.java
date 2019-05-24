import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class ArcButton extends JButton {
	StateManager stateManager;

	public ArcButton(StateManager stateManager) {
		super("Arc");
		addActionListener(new ArcListener());
		this.stateManager = stateManager;
	}

	class ArcListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			stateManager.setState(new ArcState(stateManager));
		}
	}

	class ArcState implements State {
		StateManager stateManager;
		private int x1, y1;
		MyArc myArc;

		public ArcState(StateManager stateManager) {
			this.stateManager = stateManager;
		}

		public void mouseDown(int x, int y) {
			stateManager.addDrawing(myArc = new MyArc(x, y, 0, 0));
			x1 = x;
			y1 = y;
		}

		public void mouseUp(int x, int y) {
			if (!stateManager.getDashed())
				myArc.setDashed(false);
			if (myArc.getDropShadow()) {
				stateManager.removeDrawing(myArc);
				stateManager.addDrawing(new MyArc(x1+5, y1+5, x-x1, y-y1, Color.BLACK));
				stateManager.addDrawing(myArc);
			}
		}
		public void mouseDrag(int x, int y) {
			myArc.setDashed(true);
			myArc.setSize(x-x1, y-y1);
		}
	}
}