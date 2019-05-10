
public class RectState extends State
{
	StateManager stateManager;

	public RectState(StateManager stateManager) {
		this.stateManager = stateManager;
	}

	public void mouseDown(int x, int y) {
		stateManager.addDrawing(new MyRectangle(x, y));
	}

	public void mouseUp(int x, int y) {}
	public void mouseDrag(int x, int y) {}
}
