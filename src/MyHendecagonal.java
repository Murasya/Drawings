import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class MyHendecagonal extends MyDrawing
{
	public MyHendecagonal(int xpt, int ypt) {
		super();
		setLocation(xpt, ypt);
	}
	
	public MyHendecagonal(int xpt, int ypt, int rpt, Color fc) {
		super();
		setLocation(xpt, ypt);
		setSize(rpt, rpt);
		setFillColor(fc);
		setLineColor(fc);
	}
	
	public void draw(Graphics g) {
		int r = getW() / 2;
		int x = getX() - r;
		int y = getY() - r;
		int w = getW();
		int h = getH();
		int i = 0;
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
		
		for(i = 0; i < 11; i++) {
			xw[i] = x + (int)(Math.sin((360.0 / 11 * i)/180 * 3.14) * r);
			yw[i] = y - (int)(Math.cos((360.0 / 11 * i)/180 * 3.14) * r);
		}
		
		Graphics2D g2 = (Graphics2D) g;
		g2.setStroke(new BasicStroke(getLineWidth()));
		g2.setColor(getFillColor());
		g2.fillPolygon(xw, yw, 11);
		g2.setColor(getLineColor());
		g2.drawPolygon(xw, yw, 11);
	}
}
