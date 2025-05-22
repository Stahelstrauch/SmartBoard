import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

public class PanelDraw extends JPanel implements MouseMotionListener {
    private Model model;
    private View view;
    private int x1; // hiire kordinaadid
    private int y1;
    private boolean start = true;

    // Vaja teha siia: Line klass
    private ArrayList<Line> lines = new ArrayList<>(); // Loome listi joonte jaoks


    public PanelDraw(Model model, View view) {
        this.model = model; // Konstruktoriga loodud
        this.view = view;

        addMouseMotionListener(this); // Hiire liikumise jälgimine
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); // paintComponent kõik omadused kaasa antud
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);

        //Joonista tausta värv, see käib PanelDraw jaoks JPanel
        setBackground(new Color(234, 7, 231, 94)); //saad valida värvi kas Color.GREEN valmis valik või numbritega 3tk (siis saad eesikoonist värvi vahetada)
        // Joonista jooned
        for(Line line : lines) {
            g2d.setColor(line.getColor()); // määrame joone värvi
            g2d.setStroke(new BasicStroke(line.getWidth())); // määrame jooone paksuse
            g2d.drawLine(line.getX1(), line.getY1(), line.getX2(), line.getY2()); // Joone enda joonistamine
        }
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        int x = x1; // tuvastab muutujad, hiire kordinaadid
        int y = y1;
        x1 = e.getX(); //Hiire kordinaadid
        y1 = e.getY();
        if(start) {
            x = x1;
            y = y1;
            start = false;
        }
        lines.add(new Line(x, y, x1, y1, model.getColor(), model.getWidth())); // Lisan hiire kordinaadid listi
        showMousePosition(e.getX(), e.getY());
        repaint(); // Värskenda joonistust


    }

    @Override
    public void mouseMoved(MouseEvent e) {
        start = true; // Hiir hakkas liikuma
        showMousePosition(e.getX(), e.getY()); //mouseeventi enda muutujad on need getX ja getY

    }

    private void showMousePosition(int mouseX, int mouseY) {
        view.getLblMouse().setText(String.format("x: %d y: %d", mouseX, mouseY)); // sellega paneme tööle hiire kordinaatide näitamise status paneelil
    }

    // Getter Lines listile
    public ArrayList<Line> getLines() {
        return lines;
    }
}
