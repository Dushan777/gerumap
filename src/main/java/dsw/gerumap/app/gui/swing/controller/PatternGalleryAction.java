package dsw.gerumap.app.gui.swing.controller;

import dsw.gerumap.app.gui.swing.view.PatternGalleryFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class PatternGalleryAction extends AbstractGerumapAction {

    public PatternGalleryAction() {
        putValue(SMALL_ICON, loadIcon("/images/patternGallery.png"));
        putValue(NAME, "Pattern Gallery");
        putValue(SHORT_DESCRIPTION, "Pattern Gallery");

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        EventQueue.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (ClassNotFoundException | InstantiationException | IllegalAccessException |
                     UnsupportedLookAndFeelException ex) {
                ex.printStackTrace();
            }

            PatternGalleryFrame frame = new PatternGalleryFrame();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}
