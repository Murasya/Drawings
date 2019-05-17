
public class StateManager {
	private MyCanvas canvas;
	private State state;
	private boolean isDashed;
	private boolean isDropShadow;

	public StateManager(MyCanvas canvas) {
		this.canvas = canvas;
	}
	public void addDrawing(MyDrawing md) {
		md.setDashed(isDashed);
		md.setDropShadow(isDropShadow);
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
