package dsw.gerumap.app.gui.swing.controller;

import dsw.gerumap.app.core.ApplicationFramework;
import dsw.gerumap.app.gui.swing.errorLogger.EventType;
import dsw.gerumap.app.gui.swing.view.MainFrame;
import dsw.gerumap.app.mapRepository.implementation.MindMap;
import dsw.gerumap.app.mapRepository.implementation.Project;
import dsw.gerumap.app.messageGenerator.MessageGeneratorImplementation;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.File;

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
        jfc.setCurrentDirectory(new File("src/main/resources/patternGallery"));
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

    }
}
