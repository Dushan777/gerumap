package dsw.gerumap.app.gui.swing.controller;

import dsw.gerumap.app.core.ApplicationFramework;
import dsw.gerumap.app.gui.swing.errorLogger.EventType;
import dsw.gerumap.app.gui.swing.view.MainFrame;
import dsw.gerumap.app.gui.swing.view.MindMapView;
import dsw.gerumap.app.mapRepository.implementation.MindMap;
import dsw.gerumap.app.mapRepository.implementation.Project;
import dsw.gerumap.app.messageGenerator.MessageGeneratorImplementation;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class MakePatternAction extends AbstractGerumapAction{

    public MakePatternAction() {

        putValue(SMALL_ICON, loadIcon("/images/makepattern.png"));
        putValue(NAME, "Make a pattern");
        putValue(SHORT_DESCRIPTION, "Make a pattern");
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        JFileChooser jfc = new JFileChooser();

        if (MainFrame.getInstance().getMapTree().getSelectedNode() == null || !(MainFrame.getInstance().getMapTree().getSelectedNode().getMapNode() instanceof MindMap))
        {
            ((MessageGeneratorImplementation) ApplicationFramework.getInstance().getMessageGenerator()).setType(EventType.MUST_CHOOSE_MINDMAP);
            ApplicationFramework.getInstance().getMessageGenerator().generateMessage();
            return;
        }
        jfc.setCurrentDirectory(new File("src/main/resources/patternGalleryFiles"));
        MindMap mindMap = (MindMap) MainFrame.getInstance().getMapTree().getSelectedNode().getMapNode();
        File mindMapFile = null;

            if (jfc.showSaveDialog(MainFrame.getInstance()) == JFileChooser.APPROVE_OPTION) {
                mindMapFile = jfc.getSelectedFile();
                mindMap.setFilePath(mindMapFile.getPath());
                if(!mindMapFile.getPath().contains(".json"))
                    mindMap.setFilePath(mindMapFile.getPath() + ".json");

            } else
                return;

        ApplicationFramework.getInstance().getSerializer().saveMindMap(mindMap);
        if (MainFrame.getInstance().getProjectView().getTabbedPane().getSelectedComponent() instanceof MindMapView) {
            BufferedImage image = new BufferedImage(MainFrame.getInstance().getProjectView().getTabbedPane().getSelectedComponent().getWidth(), MainFrame.getInstance().getProjectView().getTabbedPane().getSelectedComponent().getHeight(), BufferedImage.TYPE_INT_RGB);
            Graphics2D g = image.createGraphics();
            MainFrame.getInstance().getProjectView().getTabbedPane().getSelectedComponent().printAll(g);
            g.dispose();
            try {
                if(mindMapFile.getPath().contains(".json"))
                    ImageIO.write(image, "png", new File("src/main/resources/patternGallery/" + mindMapFile.getName().substring(0, mindMapFile.getName().length() - 5) + ".png"));
                    else
                  ImageIO.write(image, "png", new File( "src/main/resources/patternGallery/" + mindMapFile.getName() + ".png"));
            } catch (IOException exp) {
                exp.printStackTrace();
            }
        }

    }
}
