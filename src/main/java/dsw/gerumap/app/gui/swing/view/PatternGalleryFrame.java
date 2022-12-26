package dsw.gerumap.app.gui.swing.view;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class PatternGalleryFrame extends JFrame {

    private JLabel slidesLabel = new JLabel();
    private List<Icon> icons = new ArrayList<>();
    private int currentSlide = -1;
    private File[] files;
    private File directory;
    private JLabel name = new JLabel();
    public PatternGalleryFrame() {
        try {
            directory = new File("src/main/resources/patternGallery");
            files = directory.listFiles();
            for(File f : files)
            {
                icons.add(new ImageIcon(ImageIO.read(f)));
            }
            slidesLabel.setVerticalAlignment(JLabel.CENTER);
            slidesLabel.setHorizontalAlignment(JLabel.CENTER);
            setLayout(new BorderLayout());
            add(slidesLabel, BorderLayout.CENTER);
            add(name, BorderLayout.NORTH);
            slidesLabel.addMouseListener(new ClickListener());
            nextSlide();
        } catch (IOException exp) {
            exp.printStackTrace();
        }
    }

    public void nextSlide() {
        if (currentSlide < icons.size() - 1) {
            currentSlide++;
            slidesLabel.setIcon(icons.get(currentSlide));
            name.setText(files[currentSlide].getName());
        }
        else
        {
            currentSlide = 0;
            slidesLabel.setIcon(icons.get(currentSlide));
            name.setText(files[currentSlide].getName());

        }
    }

    public class ClickListener extends MouseAdapter {

        @Override
        public void mouseClicked(MouseEvent e) {
            nextSlide();
        }
    }
}

