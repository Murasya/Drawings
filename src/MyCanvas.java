import java.awt.Color;
import java.awt.Graphics;
import java.util.Enumeration;

import javax.swing.JPanel;

public class MyCanvas extends JPanel
{
	Mediator mediator;

	public MyCanvas() {
		setBackground(Color.white);
		this.mediator = new Mediator(this);
	}

	public Mediator getMediator() {
		return mediator;
	}

	public void paint(Graphics g) {
		super.paint(g);

		Enumeration<MyDrawing> e = mediator.drawingsElements();
		while (e.hasMoreElements()) {
			MyDrawing d = e.nextElement();
			d.draw(g);
		}
	}
}
