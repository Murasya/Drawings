import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class MyArc extends MyDrawing{
	public MyArc(int xpt, int ypt) {
		super();
		setLocation(xpt, ypt);
	}
	
	public MyArc(int xpt, int ypt, int wpt, int hpt, Color fc) {
		super();
		setLocation(xpt, ypt);
		setSize(wpt, hpt);
		setFillColor(fc);
		setLineColor(fc);
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
		g2.setStroke(new BasicStroke(getLineWidth()));
		g2.setColor(getFillColor());
		g2.fillArc(x, y, w, h, -180, 180);
		g2.setColor(getLineColor());
		g2.drawArc(x, y, w, h, -180, 180);
	}
}
