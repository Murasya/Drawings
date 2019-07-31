import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Rectangle;

public class MyTextBox extends MyDrawing {
	private String text;

    public MyTextBox(String _text, int xpt, int ypt, int wpt, int hpt) {
    	super(xpt, ypt, wpt, hpt);
        text = _text;
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
		FontMetrics fm = g.getFontMetrics();
		setSize(fm.stringWidth(text), fm.getHeight());
        g.drawString(text, x, y + fm.getAscent());
        super.draw(g);
    }

    public int contains(int x, int y) {
    	int i = super.contains(x, y);
		if (i == -1 && region.contains(x, y))
			return 8;
		else
			return i;
    }

	@Override
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
