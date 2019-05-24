import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JCheckBox;

public class DashStrokeBox extends JCheckBox {
	StateManager stateManager;

	public DashStrokeBox(StateManager stateManager) {
		super("Dashed");
		addItemListener(new DashStrokeListener());
		this.stateManager = stateManager;
	}
	class DashStrokeListener implements ItemListener {
		public void itemStateChanged(ItemEvent e) {
			int state = e.getStateChange();
			if (state == ItemEvent.SELECTED) {
				stateManager.setDashed(true);
			} else {
				stateManager.setDashed(false);
			}
		}
	}
}
