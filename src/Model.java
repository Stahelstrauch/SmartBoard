import java.awt.*;

public class Model {
    private Color color = new Color(255, 255, 255); // Vaikimisi joone värv
    private int width = 3; //Joone paksus, see on algväärtus kui ma panen tööle programmi



    // GETTERS

    public Color getColor() {
        return color;
    }

    public int getWidth() {
        return width;
    }


    //SETTERS

    public void setColor(Color color) {
        this.color = color;
    }

    public void setWidth(int width) {
        this.width = width;
    }
}
