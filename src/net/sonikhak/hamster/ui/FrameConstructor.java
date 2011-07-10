package net.sonikhak.hamster.ui;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @author sonikhak (https://github.com/sonikhak)
 */
public class FrameConstructor {
    private static Frame frame;

    public static Frame frame(String title, int w, int h) {
        frame = new Frame(title);
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent windowEvent) {
                System.exit(0);
            }
        });
        frame.setSize(w,h);
        frame.setVisible(true);
        return frame;
    }

    public static void add(Component cmpt) {
        frame.add(cmpt);
    }

    public static void setXY(int x, int y) {
        frame.setLocation(x,y);
    }
}
