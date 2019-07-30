import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Vector;

import javax.imageio.ImageIO;
import javax.swing.JFileChooser;

public class File {
	Vector<MyDrawing> v;
	Mediator mediator;
	JFileChooser fc;
	int returnVal;

	public File(Mediator mediator) {
		this.mediator = mediator;
		v = mediator.drawings;
		fc = new JFileChooser();
	}

	public BufferedImage imageInput() {
		BufferedImage bufferedImage = null;
		fc.addChoosableFileFilter(new ImageFilter());
		try {
			returnVal = fc.showOpenDialog(null);
			if (returnVal == JFileChooser.APPROVE_OPTION ) {
				java.io.File file = fc.getSelectedFile();
				bufferedImage = ImageIO.read(file);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return bufferedImage;
	}

    // File入力
	public Vector<MyDrawing> fileInput() {
		System.out.println("Read File");
		try {
			returnVal = fc.showOpenDialog(null);
			if (returnVal == JFileChooser.APPROVE_OPTION) {
				java.io.File file = fc.getSelectedFile();
				FileInputStream fin = new FileInputStream(file);
		        ObjectInputStream in = new ObjectInputStream(fin);

		        v = (Vector<MyDrawing>)in.readObject();
		        in.close();
		        fin.close();
		        mediator.drawings = v;
		        mediator.repaint();
			}
	    } catch (Exception ex) {
	    	System.out.println(ex);
	    }
		return v;
	}
    // File出力
	public void fileOutput() {
		System.out.println("Save File");
	    try {
	    	returnVal = fc.showSaveDialog(null);
	    	if (returnVal == JFileChooser.APPROVE_OPTION) {
	    		java.io.File file = fc.getSelectedFile();
	    		mediator.clearSelectedDrawings();
		        FileOutputStream fout = new FileOutputStream(file);
		        ObjectOutputStream out = new ObjectOutputStream(fout);

		        out.writeObject(v);
		        out.flush();

		        out.close();
		        fout.close();
	    	}
	    } catch (Exception ex) {
	    	System.out.println(ex);
	    }
	}
}
