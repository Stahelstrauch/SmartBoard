import javax.swing.*;
import java.awt.*;

public class PanelStatus extends JPanel {
    private JLabel lblMouse;
    private JLabel lblColor;

    public PanelStatus(Model model) {
        setLayout(new FlowLayout(FlowLayout.LEFT)); //Joonda vasakult objektid
        setBackground(Color.GRAY);

        lblMouse = new JLabel("x: 0 y: 0"); // Tee silt koos tekstiga, seal kuvatakse hiire kordinaate
        lblColor = new JLabel("Color"); // Valitud värvi idndikaator labeli peale
        lblColor.setBackground(model.getColor()); // Taustavärv: Paneb selle värvi, mis ta saab Modelist getColoriga.
        lblColor.setForeground(model.getColor()); // Teksti värv: paneb selle mis saab Modelist
        lblColor.setOpaque(true); // Tausta värvi jaoks

        add(lblMouse); // Lisab paneelile hiire kordinaadid
        add(lblColor); // Lisab paneelile taustavärvi indikaatori

    }
    //GETTERID


    public JLabel getLblMouse() {
        return lblMouse;
    }

    public JLabel getLblColor() {
        return lblColor;
    }
}
