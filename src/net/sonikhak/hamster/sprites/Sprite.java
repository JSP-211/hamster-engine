package net.sonikhak.hamster.sprites;

import net.sonikhak.hamster.ui.MyCanvas;

import java.awt.*;

/**
 * @author sonikhak (https://github.com/sonikhak)
 */
public class Sprite {
    private boolean image;
    private Graphics2D g2d;
    private MyCanvas supr;

    public Sprite(boolean image, Graphics2D g2d, MyCanvas supr) {
        this.image = image;
        this.g2d = g2d;
        this.supr = supr;
    }

    public void setColor(Color c) {
        g2d.setColor(c);
    }

    public void rectangle(int w, int h, int x, int y) {
        g2d.fillRect(w,h,x,y);
    }

    public void trans_rectangle(int w, int h, int x, int y, float opacity) {
        AlphaComposite composite = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, opacity);
        g2d.setComposite(composite);
        g2d.fillRect(w, h, x, y);
        g2d.setComposite(AlphaComposite.Src);
    }

    public void square_border(int w, int h, int x, int y) {
        g2d.drawRect(w, h, x, y);
    }

    public void circle(int w, int h, int x, int y) {
        g2d.fillOval(w, h, x, y);
    }

    public void round_border(int w, int h, int x, int y) {
        g2d.drawOval(w, h, x, y);
    }

    public void text(String s, int x, int y) {
        if(s.contains("@blu@")) {
            g2d.setColor(Color.BLUE);
        }
        g2d.drawString(s, x, y);
    }

    public void line(int x1, int x2, int y1, int y2) {
        g2d.drawLine(x1, y1, x2, y2);
    }

    public void image(String img,int x,int y) {
        g2d.drawImage(Toolkit.getDefaultToolkit().getImage("sprites/" + img),x,y,supr);
    }
}
