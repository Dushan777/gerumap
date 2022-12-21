package dsw.gerumap.app.gui.swing.controller;

import dsw.gerumap.app.gui.swing.view.MainFrame;
import dsw.gerumap.app.gui.swing.view.MindMapView;
import dsw.gerumap.app.mapRepository.implementation.MindMap;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public class PictureAction  extends AbstractGerumapAction {

    public PictureAction() {
        putValue(SMALL_ICON, loadIcon("/images/picture.png"));
        putValue(NAME, "Export picture");
        putValue(SHORT_DESCRIPTION, "Export picture");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (MainFrame.getInstance().getProjectView().getTabbedPane().getSelectedComponent() instanceof MindMapView) {
            BufferedImage image = new BufferedImage(MainFrame.getInstance().getProjectView().getTabbedPane().getSelectedComponent().getWidth(), MainFrame.getInstance().getProjectView().getTabbedPane().getSelectedComponent().getHeight(), BufferedImage.TYPE_INT_RGB);
            Graphics2D g = image.createGraphics();
            MainFrame.getInstance().getProjectView().getTabbedPane().getSelectedComponent().printAll(g);
            g.dispose();
            try {
                //ImageIO.write(image, "jpg", new File("Paint.jpg"));
                ImageIO.write(image, "png", new File("Paint.png"));
            } catch (IOException exp) {
                exp.printStackTrace();
            }
        }
    }
}
