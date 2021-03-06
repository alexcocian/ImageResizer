import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;

public class Main {

    public static void main(String[] args) {
        ImageGUI gui = new ImageGUI();

        var fileManager = new FileManager();
        var files = fileManager.getLocalImages();
        Iterator iterator = files.iterator();
        while (iterator.hasNext()) {
            var file = (File) iterator.next();
            var editEngine = new ImageEditEngine(file);
            String imageName = "";
            try {
                imageName = fileManager.save((RenderedImage) editEngine.getImg());
            } catch (IOException e) {
                e.printStackTrace();
            }
            gui.displayImage(editEngine.getImg(), imageName);
            gui.setVisible(true);
        }
        System.exit(0);
    }
}