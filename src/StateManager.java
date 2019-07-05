
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.util.Vector;

public class StateManager {
	private MyCanvas canvas;
	private State state;
	private boolean isDashed;
	private boolean isDropShadow;
	private float lineWidth;
	private Color fillColor;
	private Color lineColor;

	public StateManager(MyCanvas canvas) {
		this.canvas = canvas;
		state = null;
		isDashed = false;
		isDropShadow = false;
		lineWidth = 1.0f;
		fillColor = Color.WHITE;
		lineColor = Color.BLACK;
	}
	public void addDrawing(MyDrawing md) {
		md.setDashed(isDashed);
		md.setDropShadow(isDropShadow);
		md.setLineWidth(lineWidth);
		md.setFillColor(fillColor);
		md.setLineColor(lineColor);
		getMediator().addDrawing(md);
	}
	public Mediator getMediator() {
		return canvas.getMediator();
	}
	public void removeDrawing(Vector<MyDrawing> md) {
		getMediator().removeDrawing(md);
	}
	public void setState(State state) {
		this.state = state;
	}
	public void setDropShadow(boolean b) {
		this.isDropShadow = b;
		getMediator().setDropShadow(b);
		canvas.repaint();
	}
	public void setDashed(boolean b) {
		this.isDashed = b;
	}
	public void setLineWidth(float b) {
		this.lineWidth = b;
		getMediator().setLineWidth(b);
		canvas.repaint();
	}
	public boolean getDashed() {
		return isDashed;
	}
	public void setFillColor(Color c) {
		this.fillColor = c;
		getMediator().setFillColor(c);
		canvas.repaint();
	}
	public void setLineColor(Color c) {
		this.lineColor = c;
		getMediator().setLineColor(c);
		canvas.repaint();
	}
	public void mouseDown(int x, int y) {
		if (state != null)
			state.mouseDown(x, y);
		canvas.repaint();
	}
	public void mouseDrag(int x, int y) {
		if (state != null)
			state.mouseDrag(x, y);
		canvas.repaint();
	}
	public void mouseUp(int x, int y) {
		if (state != null)
			state.mouseUp(x, y);
		canvas.repaint();
	}
	public void keyDown(int keyCode) {
		Vector<MyDrawing> selectedDrawing = canvas.getMediator().selectedDrawings;
		if (keyCode == KeyEvent.VK_BACK_SPACE) {
			System.out.println("pressDeleteKey");
			getMediator().removeDrawing(selectedDrawing);
		}
		canvas.repaint();
	}
}
