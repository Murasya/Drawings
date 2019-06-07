import java.awt.Color;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.lang.reflect.Field;

import javax.swing.JComboBox;

public class ColorComboBox extends JComboBox<String> {
	StateManager stateManager;
	JComboBox<String> combo;
	String[] bolds = {"WHITE", "GRAY", "BLACK", "RED", "ORANGE", "YELLOW", "GREEN", "BLUE", "CYAN"};

	public ColorComboBox(StateManager stateManager) {
		super();
		for (String bold : bolds)
			addItem(bold);
		this.stateManager = stateManager;
		addItemListener(new ColorListener());
	}
	class ColorListener implements ItemListener {
		Color color;
		@Override
		public void itemStateChanged(ItemEvent e) {
			Mediator med = stateManager.getMediator();
			try {
			    Field field = Color.class.getField((String)e.getItem());
			    color = (Color)field.get(null);
			} catch (Exception ex) {
			    color = null; // Not defined
			}
			med.setColor(color);
		}
	}
}
