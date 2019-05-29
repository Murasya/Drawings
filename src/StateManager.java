
public class StateManager {
	private MyCanvas canvas;
	private State state;
	private boolean isDashed;
	private boolean isDropShadow;
	private float lineWidth;

	public StateManager(MyCanvas canvas) {
		this.canvas = canvas;
		isDashed = false;
		isDropShadow = false;
		lineWidth = 1.0f;
	}
	public void addDrawing(MyDrawing md) {
		md.setDashed(isDashed);
		md.setDropShadow(isDropShadow);
		md.setLineWidth(lineWidth);
		canvas.addDrawing(md);
	}
	public void removeDrawing(MyDrawing md) {
		canvas.removeDrawing(md);
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
		state.mouseDown(x, y);
	}
	public void mouseDrag(int x, int y) {
		state.mouseDrag(x, y);
	}
	public void mouseUp(int x, int y) {
		state.mouseUp(x, y);
	}
}
