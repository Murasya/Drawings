import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Vector;

public class File {
	Vector<MyDrawing> v;
	Mediator mediator;

	public File(Mediator mediator) {
		this.mediator = mediator;
		v = mediator.drawings;
	}

    // File入力
	public Vector<MyDrawing> fileInput() {
		System.out.println("read file.txt");
		try {
			FileInputStream fin = new FileInputStream("file.txt");
	        ObjectInputStream in = new ObjectInputStream(fin);

	        v = (Vector<MyDrawing>)in.readObject();
	        fin.close();
	        mediator.drawings = v;
	        mediator.repaint();
	    } catch (Exception ex) {
	    }
		return v;
	}
    // File出力
	public void fileOutput() {
	    try {
	        FileOutputStream fout = new FileOutputStream("file.txt");
	        ObjectOutputStream out = new ObjectOutputStream(fout);

	        out.writeObject(v);
	        out.flush();

	        fout.close();
	    } catch (Exception ex) {
	    }
	}
}
