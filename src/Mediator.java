import java.awt.Color;
import java.util.Enumeration;
import java.util.Vector;

public class Mediator {
	Vector<MyDrawing> drawings;
	Color color;
	MyCanvas canvas;
	MyDrawing selectedDrawing = null;

	public Mediator(MyCanvas canvas) {
		this.canvas = canvas;
		color = Color.white;
		drawings = new Vector<MyDrawing>();
	}

	public Enumeration<MyDrawing> drawingsElements() {
		return drawings.elements();
	}

	public void addDrawing(MyDrawing d) {
		d.setColor(color);
		//setSelectedDrawing(d);
		drawings.add(d);
	}

	public void removeDrawing(MyDrawing d) {
		drawings.remove(d);
	}

	public MyDrawing getSelectedDrawing() {
		return selectedDrawing;
	}

	public void move(int dx, int dy) {
		if (selectedDrawing != null)
			selectedDrawing.move(dx,  dy);
	}

	public void repaint() {
		canvas.repaint();
	}

	public void setSelected(int x, int y) {
		MyDrawing d;
		boolean isSelect = false;
		for (int i = drawings.size()-1; i >= 0; i--) {
			d = drawings.elementAt(i);
			if (d.contains(x, y) && !isSelect) {
				selectedDrawing = d;
				d.setSelected(true);
				isSelect = true;
			} else {
				d.setSelected(false);
			}
			if (!isSelect) {
				selectedDrawing = null;
			}
		}
		System.out.println(selectedDrawing);
	}

	public void setSelectedDrawing(MyDrawing d) {
		this.selectedDrawing = d;
	}

	public void setColor(Color c) {
		color = c;
		if (selectedDrawing != null) {
			selectedDrawing.setColor(c);
			if (c == Color.white) {
				selectedDrawing.setLineColor(Color.black);
			}
		}
		canvas.repaint();
	}
}
