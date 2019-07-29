import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Shape;

public class MyRectangle extends MyDrawing
{
	Shape region;
	public MyRectangle(int xpt, int ypt) {
		super(xpt, ypt);
	}

	public MyRectangle(int xpt, int ypt, int wpt, int hpt) {
		super(xpt, ypt, wpt, hpt);
	}

	public MyRectangle(int xpt, int ypt, int wpt, int hpt, Color fc) {
		super(xpt, ypt, wpt, hpt, fc);
	}

	public void draw(Graphics g) {
		int x = getX();
		int y = getY();
		int w = getW();
		int h = getH();

		if (w < 0) {
			x += w;
			w *= -1;
		}
		if (h < 0) {
			y += h;
			h *= -1;
		}

		Graphics2D g2 = (Graphics2D) g;
		g2.setStroke(new MyDashStroke(getLineWidth()));
		g2.setColor(getFillColor());
		//g2.fillRect(x, y, w, h);
		g2.setColor(getLineColor());
		g2.drawRect(x, y, w, h);
	}

	public boolean contains(int x, int y) {
		return region.contains(x, y);
	}
	public void setRegion() {
		int x = getX();
		int y = getY();
		int w = getW();
		int h = getH();
		if (w < 0) {
			x += w;
			w *= -1;
		}
		if (h < 0) {
			y += h;
			h *= -1;
		}
		region = new Rectangle(x, y, w, h);
	}
}
