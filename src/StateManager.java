
public class StateManager {
	MyCanvas canvas;
	State state;

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
}
