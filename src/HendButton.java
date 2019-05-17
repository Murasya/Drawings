import java.awt.Color;
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
		private int x1, y1;
		MyHendecagonal myHend;

		public HendState(StateManager stateManager) {
			this.stateManager = stateManager;
		}

		public void mouseDown(int x, int y) {
			stateManager.addDrawing(myHend = new MyHendecagonal(x, y, 0, 0));
			x1 = x;
			y1 = y;
		}

		public void mouseUp(int x, int y) {
			myHend.setDashed(false);
			if (myHend.getDropShadow()) {
				stateManager.removeDrawing(myHend);
				stateManager.addDrawing(new MyHendecagonal(x1+5, y1+5, x-x1, y-y1, Color.BLACK));
				stateManager.addDrawing(myHend);
			}
		}
		public void mouseDrag(int x, int y) {
			myHend.setDashed(true);
			myHend.setSize(x-x1, y-y1);

		}
	}
}
