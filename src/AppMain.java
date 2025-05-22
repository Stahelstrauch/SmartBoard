import javax.swing.*;
import java.awt.*;

public class AppMain {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Tarktahvel"); // Loome akna, koos tittelriba tekstiga
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Sellega paneme külge nupud minimize, maximize ja sulge
        frame.setPreferredSize(new Dimension(500, 400)); // Akna suuruse määramine

        Model model = new Model();
        View view = new View(frame, model);
        new Controller(view); // Loome controlleri


        frame.pack(); // Loksuta JKomponendid omale kohale
        frame.setLocationRelativeTo(null); // Paiguta JFrame ekraani keskele
        frame.setResizable(true); //Akna muutmine (true on jah, false on ei)
        frame.setVisible(true); // Teeme akna nähtavaks - kõige olulisem rida!
    }
}
