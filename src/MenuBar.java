import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MenuBar extends JMenuBar{
	StateManager stateManager;
	JMenu file = new JMenu("File");
	JMenuItem open = new JMenuItem("Open");
	JMenuItem save = new JMenuItem("Save");
	File f;

	public MenuBar(StateManager stateManager) {
		this.stateManager = stateManager;
		f = new File(stateManager.getMediator());
		add(file);
		file.add(open);
		open.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				f.fileInput();
			}
		});
		file.add(save);
		save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				f.fileOutput();
			}
		});
	}
}
