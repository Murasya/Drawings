import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class MyImage extends MyDrawing {
	BufferedImage image;
	public MyImage(int xpt, int ypt) {
		super(xpt, ypt);
	}
	public MyImage(int xpt, int ypt, int wpt, int hpt) {
		super(xpt, ypt, wpt, hpt);
	}
	public MyImage(int xpt, int ypt, int wpt, int hpt, Color fc) {
		super(xpt, ypt, wpt, hpt, fc);
	}
	public MyImage(BufferedImage image) {
		super(0, 0, image.getWidth(), image.getHeight());
		this.image = image;
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
		g2.drawImage(image, x, y, w, h, null);

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
		Rectangle s = new Rectangle(x, y, w, h);
		region = s;
	}
}
