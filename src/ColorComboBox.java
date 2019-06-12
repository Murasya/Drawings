import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Field;

import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JFrame;

public class ColorComboBox extends JComboBox<String> {
	StateManager stateManager;
	JComboBox<String> combo;
	String[] bolds = {"WHITE", "GRAY", "BLACK", "RED", "ORANGE", "YELLOW", "GREEN", "BLUE", "CYAN", "Other Colors"};

	public ColorComboBox(StateManager stateManager) {
		super();
		for (String bold : bolds)
			addItem(bold);
		this.stateManager = stateManager;
		addActionListener(new ColorListener());
	}
	class ColorListener implements ActionListener {
		Color color;
		JFrame jf;
		@Override
		public void actionPerformed(ActionEvent e) {
			Mediator med = stateManager.getMediator();
			System.out.println(getItemAt(getSelectedIndex()));
			if (getItemAt(getSelectedIndex()).equals("Other Colors")) {
				color = JColorChooser.showDialog(jf, "JColorChooser", Color.white);
			} else {
				try {
					Field field = Color.class.getField(getItemAt(getSelectedIndex()));
					color = (Color)field.get(null);
				} catch (Exception ex) {
					color = null; // Not defined
				}
			}
			med.setColor(color);
		}
	}
}
