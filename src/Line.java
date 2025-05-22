import java.awt.*;

/**
 * Klass on vajalik joonte meeles pidamiseks
 */
public class Line {
    private int x1, y1, x2, y2; // defineeritakse 4 muutujat: joone kordinaadid
    private Color color; // Joone värv
    private int width; // Joone paksus

    public Line(int x1, int y1, int x2, int y2, Color color, int width) { // Konstruktor
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.color = color;
        this.width = width;
    }


    // GETTERS
    public int getX1() {
        return x1;
    }

    public int getY1() {
        return y1;
    }

    public int getX2() {
        return x2;
    }

    public int getY2() {
        return y2;
    }

    public Color getColor() {
        return color;
    }

    public int getWidth() {
        return width;
    }
}
