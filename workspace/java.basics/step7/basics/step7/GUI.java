package basics.step7;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Label;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class GUI {

  static final int WIDTH = 600;
  static final int HEIGHT = 600;

  Frame frame;
  Label header;
  Label status;
  MyCanvas canvas;
  Point origin;
  Circle circle;
  int nRounds;
  int nRound;
  int nSmooths;
  int nSmooth;

  GUI(int nRounds, int nSmooths) {
    this.nRounds = nRounds;
    this.nSmooths = nSmooths;

    frame = new Frame("Java AWT Examples");
    frame.setSize(WIDTH, HEIGHT);
    // frame.setLayout(new GridLayout(3, 1));
    frame.setLayout(new BorderLayout());
    frame.addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent windowEvent) {
        System.exit(0);
      }
    });
    header = new Label();
    header.setAlignment(Label.CENTER);
    header.setSize(WIDTH, 25);

    status = new Label();
    status.setAlignment(Label.CENTER);
    status.setSize(WIDTH, 25);

    canvas = new MyCanvas();
    canvas.setSize(WIDTH, HEIGHT - 50);

    frame.add(header, BorderLayout.NORTH);
    frame.add(canvas, BorderLayout.CENTER);
    frame.add(status, BorderLayout.SOUTH);
    frame.setVisible(true);

  }

  void repaint() {
    canvas.repaint();
  }

  class MyCanvas extends Canvas {

    Point toCanvas(Point p) {
      p = new Point(p);
      p.translate(origin);
      return p;
    }

    public MyCanvas() {
      setBackground(Color.GRAY);
    }

    public void paint(Graphics g) {
      Graphics2D g2;
      if (circle == null) {
        g2 = (Graphics2D) g;
        g2.drawString("Time is " + System.currentTimeMillis(), 70, 70);
      } else {
        GUI.this.paint(g);
      }
    }
  }

  void paint(Graphics g) {
    if (origin == null)
      origin = new Point(canvas.getWidth() / 2, canvas.getHeight() / 2);
    if (circle != null) {
      String text = "Round " + nRound + " out of " + nRounds;
      text += " -- Smooth " + nSmooth + " out of " + nSmooths;
      text += " -- Circle with " + circle.poly.npoints + " points.";
      header.setText(text);
      circle.draw(g, origin);
    }
  }

}
