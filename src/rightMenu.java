
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

public class rightMenu extends JPopupMenu {
	StateManager stateManager;
	private int x, y;

	public rightMenu(StateManager stateManager) {
		this.stateManager = stateManager;
		addPopupMenuItem("Copy", new ActionListener(){
	        public void actionPerformed(ActionEvent e){
	            System.out.println("Copy");
	            Mediator med = stateManager.getMediator();
	            med.copy();
	        }
	    });
		addPopupMenuItem("Cut", new ActionListener(){
	        public void actionPerformed(ActionEvent e){
	            System.out.println("Cut");
	            Mediator med = stateManager.getMediator();
	            med.cut();
	        }
	    });
		addPopupMenuItem("Paste", new ActionListener(){
	        public void actionPerformed(ActionEvent e){
	            System.out.println("Paste");
	            Mediator med = stateManager.getMediator();
	            med.paste(x,y);
	        }
	    });
		addPopupMenuItem("Delete", new ActionListener(){
	        public void actionPerformed(ActionEvent e){
	            System.out.println("Delete");
	            Mediator med = stateManager.getMediator();
	            med.removeDrawing(med.selectedDrawing);
	        }
	    });
	}

	private JMenuItem addPopupMenuItem(String name, ActionListener al){
	    JMenuItem item = new JMenuItem(name);
	    item.addActionListener(al);
	    add(item);
	    return item;
	}
	@Override
	public void show(Component component, int x, int y) {
		this.x = x;
		this.y = y;
		super.show(component, x, y);
	}
}
