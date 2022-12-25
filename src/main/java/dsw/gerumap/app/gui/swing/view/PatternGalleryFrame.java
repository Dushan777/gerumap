package dsw.gerumap.app.gui.swing.view;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class PatternGalleryFrame extends JFrame {

    private JLabel slidesLabel = new JLabel();
    private Icon[] icons;
    private int currentSlide = -1;
    private File[] files;

    private JLabel name = new JLabel();
    public PatternGalleryFrame() {
        try {
            icons = new Icon[]{
                    new ImageIcon(ImageIO.read(new File("src/main/resources/patternGallery/pattern1.png"))),
                    new ImageIcon(ImageIO.read(new File("src/main/resources/patternGallery/pattern2.png"))),
            };

            files = new File[]{
                    new File("src/main/resources/patternGallery/pattern1"),
                    new File("src/main/resources/patternGallery/pattern2"),
            };
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
        if (currentSlide < icons.length - 1) {
            currentSlide++;
            slidesLabel.setIcon(icons[currentSlide]);
            name.setText(files[currentSlide].getName());
        }
        else
        {
            currentSlide = 0;
            slidesLabel.setIcon(icons[currentSlide]);
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

