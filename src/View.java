import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class View {

    private PanelDraw panelDraw;
    private PanelTop panelTop;
    private PanelStatus panelStatus;

    public View(JFrame frame, Model model) {
        panelDraw = new PanelDraw(model, this); //this on class view ise!
        panelTop = new PanelTop(model, this, panelDraw); //annad kaasa modeli, this ehk view ja tehtud paneeli
        panelStatus = new PanelStatus(model);

        frame.add(panelDraw, BorderLayout.CENTER); // See paneb panelDraw frame peale
        frame.add(panelTop, BorderLayout.NORTH); // See paneb frame ülesse serva
        frame.add(panelStatus, BorderLayout.SOUTH);

    }

    public JLabel getLblMouse() {
        return panelStatus.getLblMouse();// View kaudu pääseme ligi panelStatus hiirekastile
    }

    public JLabel getLblColor() {
        return panelStatus.getLblColor(); //View kaudu pääseme ligi panelStatus värvikastile
    }

    /**
     * Lisame nupule actionListener
     * @param actionListener ActionListener objekt
     */
    public void registerButtonSave(ActionListener actionListener) {
        panelTop.getBtnSave().addActionListener(actionListener); // Sellega ütleme kust ta selle nupu saab, et funktsionaalsust külge panna (ütleb, et l on see actionlistener omadus, see mida ta teeb tuleb constructorisse).
    }

    // GETTER PanelDraw-le
    public PanelDraw getPanelDraw() {
        return panelDraw;
    }
}
