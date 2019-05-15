import java.awt.Color;
import java.awt.Graphics;

public class MyDrawing
{
	private int x, y, w, h;
	private Color lineColor, fillColor;
	private int lineWidth;
	private int lineBold;

	private boolean isDashed = false;

	public MyDrawing() {
		x = y = 0;
		w = h = 40;
		lineColor = Color.black;
		fillColor = Color.white;
		lineWidth = 1;
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

	public void setLineBold(int lb) {
		this.lineBold = lb;
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

	public int getLineWidth() {
		return lineWidth;
	}

	public Color getFillColor() {
		return fillColor;
	}

	public Color getLineColor() {
		return lineColor;
	}

	public int getLineBold() {
		return lineBold;
	}

	public void setDashed(boolean b) {
		isDashed = b;
	}

	public boolean getDashed() {
		return isDashed;
	}
}
