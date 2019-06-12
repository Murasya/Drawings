import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class SelectButton extends JButton {
	StateManager stateManager;

	public SelectButton(StateManager stateManager) {
		super("Select");
		addActionListener(new SelectListener());
		this.stateManager = stateManager;
	}

	class SelectListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			stateManager.setState(new SelectState(stateManager));
		}
	}

	class SelectState implements State {
		StateManager stateManager;
		private int x, y;

		public SelectState(StateManager stateManager) {
			this.stateManager = stateManager;
		}

		public void mouseDown(int x, int y) {
			stateManager.getMediator().setSelected(x, y);
			this.x = x;
			this.y = y;
			stateManager.getMediator().repaint();
		}

		public void mouseUp(int x, int y) {}
		public void mouseDrag(int x, int y) {
			if (stateManager.getMediator().getSelectedDrawing() != null) {
				int dx = x - this.x;
				int dy = y - this.y;
				this.x = x; this.y = y;
				stateManager.getMediator().getSelectedDrawing().move(dx, dy);
				stateManager.getMediator().repaint();
			}
		}
	}
}
