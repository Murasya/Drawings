import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class MyOval extends MyDrawing{
	Ellipse2D region;

	public MyOval(int xpt, int ypt) {
		super(xpt, ypt);
	}

	public MyOval(int xpt, int ypt, int wpt, int hpt) {
		super(xpt, ypt, wpt, hpt);
	}

	public MyOval(int xpt, int ypt, int wpt, int hpt, Color fc) {
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

		if (getDashed())
			g2.setStroke(new MyDashStroke(getLineWidth()));
		else
			g2.setStroke(new BasicStroke(getLineWidth()));

		if (getDropShadow()) {
			g2.setColor(Color.black);
			g2.fillOval(x+5, y+5, w, h);
			g2.setColor(Color.black);
			g2.drawOval(x+5, y+5, w, h);
		}

		g2.setColor(getFillColor());
		g2.fillOval(x, y, w, h);
		g2.setColor(getLineColor());
		g2.drawOval(x, y, w, h);


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
		region = new Ellipse2D.Float(x, y, w, h);
		System.out.println(region);
	}

	private void writeObject(ObjectOutputStream out) throws IOException {
		out.writeInt(getX());
		out.writeInt(getY());
		out.writeInt(getW());
		out.writeInt(getH());
	}

	private void readObject(ObjectInputStream in) throws IOException {
		int x = in.readInt();
		int y = in.readInt();
		int w = in.readInt();
		int h = in.readInt();
		Ellipse2D s = new Ellipse2D.Double(x, y, w, h);
		region = s;
	}
}
