
import java.awt.Color;
import java.util.Enumeration;
import java.util.Vector;

public class Mediator {
	Vector<MyDrawing> drawings;
	MyCanvas canvas;
	Vector<MyDrawing> selectedDrawings;
	Vector<MyDrawing> buffer;
	MyRectangle rect;
	Vector<Vector<MyDrawing>> history;
	private int history_index;

	public Mediator(MyCanvas canvas) {
		this.canvas = canvas;
		drawings = new Vector<MyDrawing>();
		selectedDrawings = new Vector<MyDrawing>();
		buffer = new Vector<MyDrawing>();
		history = new Vector<Vector<MyDrawing>>();
		history.add(new Vector<MyDrawing>());
		history_index = 0;
	}

	public Enumeration<MyDrawing> drawingsElements() {
		return drawings.elements();
	}

	public void addDrawing(MyDrawing d) {
		drawings.add(d);
		addHistory();
	}

	public void removeDrawing(Vector<MyDrawing> ds) {
		for (MyDrawing d : ds)
			drawings.remove(d);
		clearSelectedDrawings();
		repaint();
	}
	public void removeDrawing(MyDrawing d) {
		drawings.remove(d);
		repaint();
	}

	public Vector<MyDrawing> getSelectedDrawing() {
		return selectedDrawings;
	}

	public void move(int dx, int dy) {
		if (!selectedDrawings.isEmpty()) {
			for (MyDrawing d : selectedDrawings)
				d.move(dx,  dy);
		}
	}

	public void repaint() {
		canvas.repaint();
	}

	public int setSelected(int x, int y) {
		MyDrawing d;
		int j;
		boolean isSelect = false;
		if (!selectedDrawings.isEmpty()) {
			for (MyDrawing sd : selectedDrawings) {
				if ((j = sd.contains(x, y)) != -1)
					return j;
			}
		}
		clearSelectedDrawings();
		for (int i = drawings.size()-1; i >= 0; i--) {
			d = drawings.elementAt(i);
			if (d.contains(x, y)==8 && !isSelect) {
				selectedDrawings.add(d);
				d.setSelected(true);
				isSelect = true;
			}
		}
		if (!isSelect) {
			rect = new MyRectangle(x, y, 0, 0);
			addDrawing(rect);
		}
		System.out.println(selectedDrawings);
		return isSelect ? 8:-1;
	}

	public void setRectangle(int x, int y) {
		int dx, dy, dw, dh;
		int rx=rect.getX(), ry=rect.getY();
		rect.setSize(x-rx, y-ry);
		rect.setRegion();
		clearSelectedDrawings();
		for (int i = drawings.size()-1; i >= 0; i--) {
			MyDrawing d = drawings.elementAt(i);
			dx=d.getX(); dy=d.getY(); dw=d.getW(); dh=d.getH();
			if (dw < 0) {
				dx += dw;
				dw *= -1;
			}
			if (dh < 0) {
				dy += dh;
				dh *= -1;
			}
			if (rect.region.intersects(dx, dy, dw, dh)) {
				selectedDrawings.add(d);
				d.setSelected(true);
			} else {
				d.setSelected(false);
			}
		}
		repaint();
	}
	public MyRectangle getRectangle() {
		return rect;
	}

	public void setSelectedDrawing(Vector<MyDrawing> d) {
		this.selectedDrawings = d;
	}

	public void setFillColor(Color c) {
		if (!selectedDrawings.isEmpty()) {
			for (MyDrawing d : selectedDrawings)
				d.setFillColor(c);
		}
	}
	public void setLineColor(Color c) {
		if (!selectedDrawings.isEmpty()) {
			for (MyDrawing d : selectedDrawings)
				d.setLineColor(c);
		}
	}
	public void setLineWidth(float lineWidth) {
		if (!selectedDrawings.isEmpty()) {
			for (MyDrawing d : selectedDrawings)
				d.setLineWidth(lineWidth);
		}
	}
	public void clearBuffer() {
		buffer.clear();
	}
	public void clearSelectedDrawings() {
		for (MyDrawing d : selectedDrawings)
			d.setSelected(false);
		selectedDrawings.clear();
	}
	public void copy() {
		clearBuffer();
		if (!selectedDrawings.isEmpty())
			for (MyDrawing d : selectedDrawings)
				buffer.add(d.clone());
	}
	public void cut() {
		clearBuffer();
		if (!selectedDrawings.isEmpty()) {
			for (MyDrawing d : selectedDrawings)
				buffer.add(d.clone());
			removeDrawing(selectedDrawings);
		}
	}
	public void paste(int x, int y) {
		int dx=0, dy=0;
		if (!buffer.isEmpty()) {
			dx = buffer.elementAt(buffer.size()-1).getX();
			dy = buffer.elementAt(buffer.size()-1).getY();
			for (int i = buffer.size()-1; i>=0; i--) {
				MyDrawing clone = buffer.elementAt(i).clone();
				clone.move(x-dx, y-dy);
				addDrawing(clone);
				clone.setSelected(false);
			}
			repaint();
		}
	}

	public void setDropShadow(boolean b) {
		if (!selectedDrawings.isEmpty()) {
			for (MyDrawing d : selectedDrawings)
				d.setDropShadow(b);
		}
	}

	public void setDashed(boolean b) {
		if (!selectedDrawings.isEmpty()) {
			for (MyDrawing d : selectedDrawings)
				d.setDashed(b);
		}
	}

	public void addHistory() {
		Vector<MyDrawing> his = new Vector<MyDrawing>();
		history_index += 1;
		for (MyDrawing drawing : drawings) {
			his.add(drawing);
		}
		history.add(history_index, (Vector<MyDrawing>)his.clone());
		while(true) {
			try {
				history.remove(history_index+1);
			} catch (Exception e) {
				break;
			}
		}
		System.out.println(history);
		System.out.println(his);
	}

	public void undo() {
		if (history_index != 0) {
			history_index -= 1;
			drawings = (Vector<MyDrawing>) history.elementAt(history_index).clone();
		}

		System.out.println(history);
		System.out.println(drawings);
		repaint();
	}

	public void redo() {
		if (history_index < history.size()-1) {
			history_index += 1;
			drawings = (Vector<MyDrawing>) history.elementAt(history_index).clone();
		}
		System.out.println(history);
		System.out.println(history_index);
		repaint();
	}
}
