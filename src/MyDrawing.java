import java.awt.Color;
import java.awt.Graphics;
import java.awt.Shape;
import java.io.Serializable;

public abstract class MyDrawing implements Cloneable, Serializable
{
	private int x, y, w, h;
	private Color lineColor, fillColor;
	private float lineWidth;
	private boolean isDropShadow;
	private boolean isDashed;
	private boolean isSelected;
	Shape region;
	final int SIZE = 7;

	public MyDrawing() {
		x = y = 0;
		w = h = 40;
		lineColor = Color.black;
		fillColor = Color.white;
		lineWidth = 1.0f;
		isDropShadow = false;
		isDashed = false;
		setRegion();
	}
	public MyDrawing(int xpt, int ypt) {
		this();
		setLocation(xpt, ypt);
	}
	public MyDrawing(int xpt, int ypt, int wpt, int hpt) {
		this(xpt, ypt);
		setSize(wpt, hpt);
	}
	public MyDrawing(int xpt, int ypt, int wpt, int hpt, Color fc) {
		this(xpt, ypt, wpt, hpt);
		setFillColor(fc);
		setLineColor(fc);
	}

	public void draw(Graphics g) {
		if (isSelected) {
			g.setColor(Color.black);
			g.fillRect(x+w/2-SIZE/2, y-SIZE/2, SIZE, SIZE);
			g.fillRect(x-SIZE/2, y+h/2-SIZE/2, SIZE, SIZE);
			g.fillRect(x+w/2-SIZE/2, y+h-SIZE/2, SIZE, SIZE);
			g.fillRect(x+w-SIZE/2, y+h/2-SIZE/2, SIZE, SIZE);
			g.fillRect(x-SIZE/2, y-SIZE/2, SIZE, SIZE);
			g.fillRect(x+w-SIZE/2, y-SIZE/2, SIZE, SIZE);
			g.fillRect(x-SIZE/2, y+h-SIZE/2, SIZE, SIZE);
			g.fillRect(x+w-SIZE/2, y+h-SIZE/2, SIZE, SIZE);
		}
		setRegion();
	}

	public boolean getSelected() {
		return isSelected;
	}
	public void setSelected(boolean isSelected) {
		this.isSelected = isSelected;
	}

	public abstract boolean contains(int x, int y);
	public abstract void setRegion();

	public void move(int dx, int dy) {
		x += dx;
		y += dy;
	}

	public void setLineColor(Color c) {
		lineColor = c;
	}
	public void setFillColor(Color c) {
		fillColor = c;
	}
	public void setColor(Color c) {
		lineColor = c;
		fillColor = c;
		if (c == Color.white)
			lineColor = Color.black;
	}
	public void setLocation(int x, int y) {
		this.x = x;
		this.y = y;
	}
	public void setSize(int w, int h) {
		this.w = w;
		this.h = h;
	}

	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public int getW() {
		return w;
	}
	public int getH() {
		return h;
	}
	public void setX(int x) {
		this.x = x;
	}
	public void setY(int y) {
		this.y = y;
	}
	public void setW(int w) {
		this.w = w;
	}
	public void setH(int h) {
		this.h = h;
	}

	public void setLineWidth(float b) {
		this.lineWidth = b;
	}
	public float getLineWidth() {
		return lineWidth;
	}

	public Color getFillColor() {
		return fillColor;
	}
	public Color getLineColor() {
		return lineColor;
	}

	public void setDashed(boolean b) {
		isDashed = b;
	}
	public boolean getDashed() {
		return isDashed;
	}

	public void setDropShadow(boolean b) {
		isDropShadow = b;
	}
	public boolean getDropShadow() {
		return isDropShadow;
	}
	@Override
	public MyDrawing clone() {
		MyDrawing d = null;
		try {
			d = (MyDrawing)super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return d;
	}
}
