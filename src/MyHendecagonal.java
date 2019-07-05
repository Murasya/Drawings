import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class MyHendecagonal extends MyDrawing
{
	public MyHendecagonal(int xpt, int ypt) {
		super(xpt, ypt);
	}

	public MyHendecagonal(int xpt, int ypt, int wpt, int hpt) {
		super(xpt, ypt, wpt, hpt);
	}

	public MyHendecagonal(int xpt, int ypt, int wpt, int hpt, Color fc) {
		super(xpt, ypt, wpt, hpt, fc);
	}

	public void draw(Graphics g) {
		int x = getX();
		int y = getY();
		int w = getW();
		int h = getH();
		int xw[] = new int[11];
		int yw[] = new int[11];

		if (w < 0) {
			x += w;
			w *= -1;
		}
		if (h < 0) {
			y += h;
			h *= -1;
		}

		for(int i = 0; i < 11; i++) {
			xw[i] = x + w/2 + (int)(Math.sin((360.0 / 11 * i)/180 * 3.14) * w/2);
			yw[i] = y + h/2 + (int)(Math.cos((360.0 / 11 * i)/180 * 3.14) * h/2);
		}

		Graphics2D g2 = (Graphics2D) g;

		if (getDashed())
			g2.setStroke(new MyDashStroke(getLineWidth()));
		else
			g2.setStroke(new BasicStroke(getLineWidth()));

		if (getDropShadow()) {
			int tmpx[] = new int[11];
			int tmpy[] = new int[11];
			for (int i = 0; i < 11; i++) {
				tmpx[i] = xw[i]+5;
				tmpy[i] = yw[i]+5;
			}
			g2.setColor(Color.black);
			g2.fillPolygon(tmpx, tmpy, 11);
			g2.setColor(Color.black);
			g2.drawPolygon(tmpx, tmpy, 11);
		}

		g2.setColor(getFillColor());
		g2.fillPolygon(xw, yw, 11);
		g2.setColor(getLineColor());
		g2.drawPolygon(xw, yw, 11);
		super.draw(g);
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
