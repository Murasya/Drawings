import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JComboBox;

public class LineBoldComboBox extends JComboBox<String> {
	StateManager stateManager;
	JComboBox<String> combo;
	String[] bolds = {"1.0", "2.0", "3.0", "4.0"};

	public LineBoldComboBox(StateManager stateManager) {
		super();
		for (String bold : bolds)
			addItem(bold);
		this.stateManager = stateManager;
		addItemListener(new LineBoldListener());
	}
	class LineBoldListener implements ItemListener {
		@Override
		public void itemStateChanged(ItemEvent e) {
			if (e.getStateChange() == ItemEvent.SELECTED) {
				stateManager.setLineWidth(Float.parseFloat((String)e.getItem()));
			}
		}
	}
}
