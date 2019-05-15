
public class StateManager {
	private MyCanvas canvas;
	private State state;
	private boolean isDashed;

	public StateManager(MyCanvas canvas) {
		this.canvas = canvas;
	}
	public void addDrawing(MyDrawing md) {
		canvas.addDrawing(md);
	}
	public void setState(State state) {
		this.state = state;
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
	public boolean getDashed() {
		return isDashed;
	}
}
