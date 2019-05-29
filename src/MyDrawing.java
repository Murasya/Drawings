import java.awt.Color;
import java.awt.Graphics;

public class MyDrawing
{
	private int x, y, w, h;
	private Color lineColor, fillColor;
	private float lineWidth;
	private boolean isDropShadow;
	private boolean isDashed;

	public MyDrawing() {
		x = y = 0;
		w = h = 40;
		lineColor = Color.black;
		fillColor = Color.white;
		lineWidth = 1.0f;
		isDropShadow = false;
		isDashed = false;
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

	}

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
}
