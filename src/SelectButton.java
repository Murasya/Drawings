import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Enumeration;

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

		public SelectState(StateManager stateManager) {
			this.stateManager = stateManager;
		}

		public void mouseDown(int x, int y) {
			/*
			Enumeration<MyDrawing> ds = stateManager.getMediator().drawingsElements();
			for (Enumeration<MyDrawing> d = ds ; d.hasMoreElements() ;) {
				MyDrawing t = d.nextElement();
				System.out.println(t);
		        if (t.contains(x, y)) {
		        	System.out.println("true");
		        	t.setSelected(true);
		        } else {
		        	t.setSelected(false);
		        }
		    }
		    */
			stateManager.getMediator().setSelected(x, y);
			stateManager.getMediator().repaint();
		}

		public void mouseUp(int x, int y) {}
		public void mouseDrag(int x, int y) {}
	}
}
