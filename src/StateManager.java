import java.awt.event.KeyEvent;

public class StateManager {
	private MyCanvas canvas;
	private State state;
	private boolean isDashed;
	private boolean isDropShadow;
	private float lineWidth;
	rightMenu rm;

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
	public void keyDown(int keyCode) {
		MyDrawing selectedDrawing = canvas.getMediator().selectedDrawing;
		if (keyCode == KeyEvent.VK_DELETE) {
			System.out.println("pressDeleteKey");
			canvas.getMediator().removeDrawing(selectedDrawing);
		}
		canvas.repaint();
	}
}
