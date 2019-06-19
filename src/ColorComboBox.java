import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Field;

import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JFrame;

public class ColorComboBox extends JComboBox<String> {
	StateManager stateManager;
	int type;
	String[] bolds = {"WHITE", "GRAY", "BLACK", "RED", "ORANGE", "YELLOW", "GREEN", "BLUE", "CYAN", "Other Colors"};

	public ColorComboBox(StateManager stateManager, int type) {
		super();
		for (String bold : bolds)
			addItem(bold);
		this.stateManager = stateManager;
		this.type = type;
		if (type == 2)
			setSelectedIndex(2);
		addActionListener(new ColorListener());
	}
	class ColorListener implements ActionListener {
		Color color;
		JFrame jf;
		@Override
		public void actionPerformed(ActionEvent e) {
			//System.out.println(getItemAt(getSelectedIndex()));
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
			if (type == 1)
				stateManager.setFillColor(color);
			else
				stateManager.setLineColor(color);
		}
	}
}
