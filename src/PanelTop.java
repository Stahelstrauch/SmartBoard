import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

public class PanelTop extends JPanel {
    private Model model;
    private View view;
    private PanelDraw panelDraw;

    //Siia tulevad nupud, mida tuleb kuskil mujal kätte ka saada
    private JSpinner spnWidth; // Joone paksuse spinner valik
    private JButton btnSave; // Salvestuse nupp
    private BufferedImage image; // Pildi salvestamiseks


    public PanelTop(Model model, View view, PanelDraw panelDraw) {
        this.model = model; // Konstruktor
        this.view = view;
        this.panelDraw = panelDraw;


        setLayout(new FlowLayout(FlowLayout.LEFT)); // Objektid paneelis algavad vasakult servast
        setBackground(new Color(181, 136, 202)); // Paneeli taustavärv

        setupButtonColor(); // Loob värvi valiku nupu
        setupLineWidth(); // Loob joone paksuse osa (nii label kui spinner)
        setupButtonErase(); // Loob kustutamise nupu
        setupButtonSave(); // Loob nupu salvesta (salvestab pildi)
    }

    private void setupButtonSave() {
        btnSave = new JButton("Salvesta");
        add(btnSave); // Lisab nupu paneelile
    }

    // GETTER save nupule
    public JButton getBtnSave() {
        return btnSave;
    }

    private void setupButtonErase() {
        JButton erase = new JButton("Puhasta");
        erase.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // System.out.println("Kustuta"); // Test konsooli "Kustuta"
                // Teha vaja: Tühjenda joonte massiiv
                panelDraw.getLines().clear(); // Tühjendab joonte massiivi
                panelDraw.repaint(); // Joonista jooned uuesti
            }
        });
        add(erase);
    }

    private void setupLineWidth() {
        JLabel label = new JLabel("Joone paksus"); // Loob labeli
        add(label); //Paiguta silt paneelile

        SpinnerModel value = new SpinnerNumberModel(model.getWidth(), 1, 15, 1); // spinner paika: valitud laius, min, max ja samm
        spnWidth = new JSpinner(value); // Loob spinneri value väärtustega
        spnWidth.addChangeListener(new ChangeListener() { // Siin toimub funktsionaalsuse loomine
            @Override
            public void stateChanged(ChangeEvent e) {
                model.setWidth((Integer) spnWidth.getValue()); // Teeme mudelis joone paksuse täisarvuks, muidu on tekst
            }
        });// Sellega anname funktsionaalsuse
        add(spnWidth); // Lisame nupu paneelile
    }

    private void setupButtonColor() {
        JButton button = new JButton("Värv"); // Värvi valiku nupp
        button.addActionListener(new ActionListener() { // Nupu funktktsionaalsus tuleb siia
            @Override
            public void actionPerformed(ActionEvent e) {
                // System.out.println("Vali värv"); // TEST näitab konsooli "Vali värv"
                Color newColor = JColorChooser.showDialog(null, "Vali värv", model.getColor()); // Loome nupule värviballeti valimise
                if (newColor != null) {
                    model.setColor(newColor); // Muudab modelis värvi ära vastavalt balletis valitule
                }
                view.getLblColor().setBackground(model.getColor()); // Valitud värv balletist ilmub nüüd status panelile alla serva
                view.getLblColor().setForeground(model.getColor()); // Valitud tekstivärv ilmub status paneelile
            }

        });
        add(button);

    }

}
