
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Label;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
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
		canvas.setFocusable(true);

		stateManager = new StateManager(canvas);

		MenuBar menuBar = new MenuBar(stateManager);
		setJMenuBar(menuBar);

		ToolBar toolBar = new ToolBar(stateManager);
		jp.add(toolBar);

		SelectButton selectButton = new SelectButton(stateManager);
		jp.add(selectButton);

		OvalButton ovalButton = new OvalButton(stateManager);
		jp.add(ovalButton);

		HendButton hendButton = new HendButton(stateManager);
		jp.add(hendButton);

		ArcButton arcButton = new ArcButton(stateManager);
		jp.add(arcButton);

		TextInputButton textInputButton = new TextInputButton(stateManager);
		jp.add(textInputButton);

		DropShadowBox dropShadowBox = new DropShadowBox(stateManager);
		jp.add(dropShadowBox);

		DashStrokeBox dashStrokeBox = new DashStrokeBox(stateManager);
		jp.add(dashStrokeBox);

		jp.add(new Label("LineWidth", Label.RIGHT));

		LineBoldComboBox lineBold = new LineBoldComboBox(stateManager);
		jp.add(lineBold);

		jp.add(new Label("FillColor", Label.RIGHT));
		ColorComboBox fillColor = new ColorComboBox(stateManager, 1);
		jp.add(fillColor);

		jp.add(new Label("LineColor", Label.RIGHT));
		ColorComboBox lineColor = new ColorComboBox(stateManager, 2);
		jp.add(lineColor);

		RightMenu rightMenu = new RightMenu(stateManager);
		jp.add(rightMenu);

		getContentPane().setLayout(new BorderLayout());
		getContentPane().add(jp, BorderLayout.NORTH);
		getContentPane().add(canvas, BorderLayout.CENTER);

		canvas.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				canvas.requestFocusInWindow();
				if (e.getButton() == MouseEvent.BUTTON3)
					rightMenu.show(e.getComponent(), e.getX(), e.getY());
				else
					stateManager.mouseDown(e.getX(), e.getY());
			}
			public void mouseReleased(MouseEvent e) {
				stateManager.mouseUp(e.getX(), e.getY());
			}
		});

		canvas.addMouseMotionListener(new MouseMotionAdapter() {
			public void mouseDragged(MouseEvent e) {
				stateManager.mouseDrag(e.getX(), e.getY());
			}
		});

		canvas.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				stateManager.keyDown(e.getKeyCode());
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
		return new Dimension(1100, 400);
	}

	public static void main(String[] args) {
		MyApplication app = new MyApplication();
		app.pack();
		app.setVisible(true);
	}
}