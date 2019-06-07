import java.awt.Color;

public class StateManager {
	private MyCanvas canvas;
	private State state;
	private Color color;
	private boolean isDashed;
	private boolean isDropShadow;
	private float lineWidth;

	public StateManager(MyCanvas canvas) {
		this.canvas = canvas;
		state = null;
		isDashed = false;
		isDropShadow = false;
		lineWidth = 1.0f;
	}
	public void addDrawing(MyDrawing md) {
		md.setDashed(isDashed);
		md.setDropShadow(isDropShadow);
		md.setLineWidth(lineWidth);
		this.canvas.getMediator().addDrawing(md);
	}
	public Mediator getMediator() {
		return canvas.getMediator();
	}
	public void removeDrawing(MyDrawing md) {
		this.canvas.getMediator().removeDrawing(md);
	}
	public void setColor(Color c) {
		this.color = c;
	}
	public void setState(State state) {
		this.state = state;
	}
	public void setDropShadow(boolean b) {
		this.isDropShadow = b;
	}
	public void setDashed(boolean b) {
		this.isDashed = b;
	}
	public void setLineWidth(float b) {
		this.lineWidth = b;
	}
	public boolean getDashed() {
		return isDashed;
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
}
