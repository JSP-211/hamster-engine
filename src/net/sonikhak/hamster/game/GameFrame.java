package net.sonikhak.hamster.game;

import net.sonikhak.hamster.ui.FrameConstructor;
import net.sonikhak.hamster.ui.MyCanvas;

import java.awt.*;

/**
 * THIS CLASS AND THE {@link MyCanvas} CLASS ARE NOT SUPPOSED TO SHOW GOOD CODE!
 * IN FACT THEY ARE BOTH BAD!!!! THEY ARE JUST THERE AS EXAMPLES!
 *
 * @author sonikhak (https://github.com/sonikhak)
 */
public class GameFrame {
    private Frame frame;

    private GameFrame(String title, int w, int h) {
        frame = FrameConstructor.frame(title,w,h);
        frame.setResizable(false);
        MyCanvas canvas = new MyCanvas(Color.BLACK);
        frame.add(canvas);
    }

    public static void main(String[] args) {
        /*for(File f : new File("sprites/").listFiles()) {
            String name = f.getName();
            if(name.endsWith(".png") || name.endsWith(".gif") || name.endsWith(".jpg") || name.endsWith(".jpeg")) {
                try {
                    ImageCache.cache();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } */
        new GameFrame("Hamster Engine!", 542, 472);
    }
}
