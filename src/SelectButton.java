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
		private boolean isSelect;

		public SelectState(StateManager stateManager) {
			this.stateManager = stateManager;
		}

		public void mouseDown(int x, int y) {
			isSelect = stateManager.getMediator().setSelected(x, y);
			this.x = x;
			this.y = y;
		}

		public void mouseUp(int x, int y) {
			Mediator m = stateManager.getMediator();
			if (!isSelect) {
				m.removeDrawing(m.getRectangle());
			}
		}
		public void mouseDrag(int x, int y) {
			if (isSelect) {
				int dx = x - this.x;
				int dy = y - this.y;
				this.x = x; this.y = y;
				for (MyDrawing d : stateManager.getMediator().getSelectedDrawing())
					d.move(dx, dy);
			} else {
				stateManager.getMediator().setRectangle(x, y);
			}
		}
	}
}
