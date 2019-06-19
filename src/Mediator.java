
import java.awt.Color;
import java.util.Enumeration;
import java.util.Vector;

public class Mediator {
	Vector<MyDrawing> drawings;
	MyCanvas canvas;
	MyDrawing selectedDrawing;
	MyDrawing buffer;

	public Mediator(MyCanvas canvas) {
		this.canvas = canvas;
		drawings = new Vector<MyDrawing>();
		selectedDrawing = null;
		buffer = null;
	}

	public Enumeration<MyDrawing> drawingsElements() {
		return drawings.elements();
	}

	public void addDrawing(MyDrawing d) {
		// setSelectedDrawing(d);
		drawings.add(d);
	}

	public void removeDrawing(MyDrawing d) {
		drawings.remove(d);
		selectedDrawing = null;
		repaint();
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

	public void setFillColor(Color c) {
		if (selectedDrawing != null)
			selectedDrawing.setFillColor(c);
	}
	public void setLineColor(Color c) {
		if (selectedDrawing != null)
			selectedDrawing.setLineColor(c);
	}
	public void setLineWidth(float lineWidth) {
		if (selectedDrawing != null)
			selectedDrawing.setLineWidth(lineWidth);
	}
	public void clearBuffer() {
		buffer = null;
	}
	public void copy() {
		clearBuffer();
		if (selectedDrawing != null)
			buffer = selectedDrawing.clone();
	}
	public void cut() {
		clearBuffer();
		if (selectedDrawing != null) {
			buffer = selectedDrawing.clone();
			removeDrawing(selectedDrawing);
		}
	}
	public void paste(int x, int y) {
		if (buffer != null) {
			MyDrawing clone = buffer.clone();
			clone.setLocation(x, y);
			addDrawing(clone);
			selectedDrawing.setSelected(false);
			selectedDrawing = clone;
			repaint();
		}
	}

	public void setDropShadow(boolean b) {
		if (selectedDrawing != null) {
			selectedDrawing.setDropShadow(b);
		}
	}
}
