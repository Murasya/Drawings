import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class MyArc extends MyDrawing{
	public MyArc(int xpt, int ypt) {
		super(xpt, ypt);
		setLocation(xpt, ypt);
	}

	public MyArc(int xpt, int ypt, int wpt, int hpt) {
		super(xpt, ypt, wpt, hpt);
	}

	public MyArc(int xpt, int ypt, int wpt, int hpt, Color fc) {
		super(xpt, ypt, wpt, hpt, fc);
	}

	public void draw(Graphics g) {
		int x = getX();
		int y = getY();
		int w = getW();
		int h = getH();
		int cir_s = -180, cir_e = 180;
		int tmp;

		if (w < 0) {
			x += w;
			w *= -1;
		}
		if (h < 0) {
			y += h;
			h *= -1;
			tmp = cir_s;
			cir_s = cir_e;
			cir_e = tmp;
		}

		Graphics2D g2 = (Graphics2D) g;

		if (getDashed())
			g2.setStroke(new MyDashStroke(getLineWidth()));
		else
			g2.setStroke(new BasicStroke(getLineWidth()));

		g2.setColor(getFillColor());
		g2.fillArc(x, y, w, h, cir_s, cir_e);
		g2.setColor(getLineColor());
		g2.drawArc(x, y, w, h, cir_s, cir_e);
		super.draw(g);
	}

	public boolean contains(int x, int y) {
		return region.contains(x, y);
	}
	public void setRegion() {
		region = new Rectangle(getX(), getY(), getW(), getH());
	}
}
