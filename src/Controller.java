import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Controller {
    private View view; // annan kaasa view

    public Controller(View view) {
        this.view = view;

        view.registerButtonSave(new SaveButton()); // võtab selle nupu viewst ja sulgudes on meetod mis ta teeb
    }

    private class SaveButton implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // System.out.println("Klikiti salvesta nupul"); //Test
            BufferedImage image = new BufferedImage(view.getPanelDraw().getWidth(), view.getPanelDraw().getHeight(), BufferedImage.TYPE_INT_ARGB); // Loome bufferedimage, seal vaja laiust ja kõrgust
            Graphics g = image.getGraphics();
            view.getPanelDraw().paintComponent(g);
            try {
                ImageIO.write(image, "png", new File("salvestatud_pilt.png"));  // Salvestab pildi. Annan kaasa faili formaadi "png" ja faili nimi
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
    }
}
