package net.sonikhak.hamster.ui;

import net.sonikhak.hamster.sprites.Sprite;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

/**
 * THIS CLASS AND THE {@link net.sonikhak.hamster.game.GameFrame} CLASS ARE NOT SUPPOSED TO SHOW GOOD CODE!
 * IN FACT THEY ARE BOTH BAD!!!! THEY ARE JUST THERE AS EXAMPLES!
 *
 * @author sonikhak (https://github.com/sonikhak)
 */
public class MyCanvas extends Canvas implements MouseMotionListener, KeyListener {
    private int curx, cury;
    private String chat = "";

    public MyCanvas(Color bg) {
        setBackground(bg);
        addMouseMotionListener(this);
        addKeyListener(this);
    }

    @Override
    public void paint(Graphics g) {
        Sprite sprite = new Sprite(false, (Graphics2D) g, this);
        sprite.image("background.png", 0, 0);
        sprite.square_border(11, 330, 511, 95);
        sprite.setColor(Color.WHITE);
        sprite.trans_rectangle(12, 331, 510, 94, 0.50f);
        g.drawString("x: " + curx + ", y: " + cury, 15, 15);
        sprite.setColor(Color.BLACK);
        sprite.line(12, 521, 409, 409);
        sprite.text("sonikhak: " + chat, 15, 422);
        g.setColor(Color.BLUE);
    }

    @Override
    public void update(Graphics g) {
        Graphics offgc;
        Image offscreen;
        Dimension d = this.getSize();
        offscreen = createImage(d.width, d.height);
        offgc = offscreen.getGraphics();
        offgc.setColor(getBackground());
        offgc.fillRect(0, 0, d.width, d.height);
        offgc.setColor(getForeground());
        paint(offgc);
        g.drawImage(offscreen, 0, 0, this);
    }

    @Override
    public void mouseDragged(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseMoved(MouseEvent mouseEvent) {
        curx = mouseEvent.getXOnScreen();
        cury = mouseEvent.getYOnScreen();
        repaint();
    }

    @Override
    public void keyTyped(KeyEvent keyEvent) {

    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {
        char key = keyEvent.getKeyChar();
        int code = keyEvent.getKeyCode();
        if(key == KeyEvent.CHAR_UNDEFINED){
        } else if(code == KeyEvent.VK_BACK_SPACE) {
            if(chat.length() >= 1) {
            chat = chat.substring(0, chat.length() - 1);
            repaint();
            }
        } else {
            chat += key;
            repaint();
        }
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {

    }
}
