import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JCheckBox;

public class DropShadowBox extends JCheckBox {
	StateManager stateManager;

	public DropShadowBox(StateManager stateManager) {
		super("DropShadow");
		addItemListener(new DropShadowListener());
		this.stateManager = stateManager;
	}
	class DropShadowListener implements ItemListener {
		public void itemStateChanged(ItemEvent e) {
			int state = e.getStateChange();
			if (state == ItemEvent.SELECTED) {
				stateManager.setDropShadow(true);
			} else {
				stateManager.setDropShadow(false);
			}
		}
	}
}
