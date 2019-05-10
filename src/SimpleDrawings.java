import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class SimpleDrawings extends JFrame{
	public SimpleDrawings() {
		super("My Painter");
		
		JPanel jp = new JPanel(new BorderLayout());
		getContentPane().add(jp);
		
		MyCanvas canvas = new MyCanvas();
		jp.add(BorderLayout.CENTER, canvas);
		
		setSize(new Dimension(360, 280));
		setVisible(true);
	}
	
	public static void main(String[] argv) {
		new SimpleDrawings();
	}
}
class MyCanvas extends JPanel
{
	MyCanvas(){
		setBackground(Color.white);
	}
		
	public void paint(Graphics g) {
		super.paint(g);
		
		MyRectangle rec = new MyRectangle(20,20);
		MyOval ova = new MyOval(200, 20);
		
		rec.setSize(100, 100);
		rec.draw(g);
		
		ova.setSize(50, 50);
		ova.draw(g);
		
//		g.setColor(Color.black);
//		g.drawLine(20,  20,  100,  80);
//		g.setColor(Color.green);
//		g.drawRect(20, 100, 80, 60);
//		g.setColor(Color.red);
//		g.drawRoundRect(20, 180, 80, 60, 10, 10);
//		g.setColor(Color.orange);
//		g.drawOval(150, 20, 80, 60);
//		g.setColor(Color.blue);
//		g.drawString("Hello World!!", 150, 150);
//		
//		g.setColor(Color.pink);
//		g.fillArc(150, 180, 80, 60, -155, 310);
//		g.setColor(Color.cyan);
//		g.fillRect(260, 20, 80, 60);
//		g.setColor(Color.yellow);
//		g.fillRoundRect(260, 100, 80, 60, 10, 10);
//		g.setColor(Color.gray);
//		g.fillOval(260, 180, 80, 60);
	}
}