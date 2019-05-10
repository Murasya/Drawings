
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MyApplication extends JFrame
{
	StateManager stateManager;
	MyCanvas canvas;

	public MyApplication() {
		super("My Painter");

		JPanel jp = new JPanel();
		jp.setLayout(new FlowLayout());

		canvas = new MyCanvas();
		canvas.setBackground(Color.white);

		stateManager = new StateManager(canvas);

		OvalButton ovalButton = new OvalButton(stateManager);
		jp.add(ovalButton);

		HendButton hendButton = new HendButton(stateManager);
		jp.add(hendButton);

		ArcButton arcButton = new ArcButton(stateManager);
		jp.add(arcButton);

		getContentPane().setLayout(new BorderLayout());
		getContentPane().add(jp, BorderLayout.NORTH);
		getContentPane().add(canvas, BorderLayout.CENTER);

		canvas.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				stateManager.mouseDown(e.getX(), e.getY());
				canvas.repaint();
			}
		});

		this.addWindowListener(
			new WindowAdapter() {
				public void windowClosing(WindowEvent e) {
					System.exit(0);
				}
			}
		);
	}

	public Dimension getPreferredSize() {
		return new Dimension(300, 400);
	}

	public static void main(String[] args) {
		MyApplication app = new MyApplication();
		app.pack();
		app.setVisible(true);
	}

}