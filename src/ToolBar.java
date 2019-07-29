import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JToolBar;

public class ToolBar extends JToolBar {
	StateManager stateManager;

	public ToolBar(StateManager stateManager) {
		this.stateManager = stateManager;
		JButton undo = new JButton("undo");
		add(undo);
		undo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				stateManager.getMediator().undo();
			}
		});
		JButton redo = new JButton("redo");
		add(redo);
		redo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				stateManager.getMediator().redo();
			}
		});
	}
}
