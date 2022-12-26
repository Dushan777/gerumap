package dsw.gerumap.app.gui.swing.controller;

import dsw.gerumap.app.core.ApplicationFramework;
import dsw.gerumap.app.gui.swing.errorLogger.EventType;
import dsw.gerumap.app.gui.swing.view.MainFrame;
import dsw.gerumap.app.gui.swing.view.MindMapView;
import dsw.gerumap.app.mapRepository.composite.MapNode;
import dsw.gerumap.app.mapRepository.implementation.Concept;
import dsw.gerumap.app.mapRepository.implementation.Element;
import dsw.gerumap.app.mapRepository.implementation.MindMap;
import dsw.gerumap.app.mapRepository.implementation.Project;
import dsw.gerumap.app.messageGenerator.MessageGeneratorImplementation;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.Iterator;

public class ChoosePatternAction extends AbstractGerumapAction{

    public ChoosePatternAction() {

        putValue(SMALL_ICON, loadIcon("/images/choosepattern.png"));
        putValue(NAME, "Choose a pattern");
        putValue(SHORT_DESCRIPTION, "Choose a pattern");
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        JFileChooser jfc = new JFileChooser();
        jfc.setFileFilter(new FileFilter() {
            public String getDescription() {
                return "JSON Documents (*.json)";
            }

            public boolean accept(File f) {
                if (f.isDirectory()) {
                    return true;
                } else {
                    return f.getName().toLowerCase().endsWith(".json");
                }
            }
        });
        if (MainFrame.getInstance().getMapTree().getSelectedNode() == null || !(MainFrame.getInstance().getMapTree().getSelectedNode().getMapNode() instanceof MindMap))
        {
            ((MessageGeneratorImplementation) ApplicationFramework.getInstance().getMessageGenerator()).setType(EventType.MUST_CHOOSE_MINDMAP);
            ApplicationFramework.getInstance().getMessageGenerator().generateMessage();
            return;
        }
        jfc.setCurrentDirectory(new File("src/main/resources/patternGalleryFiles"));
        if (jfc.showOpenDialog(MainFrame.getInstance()) == JFileChooser.APPROVE_OPTION) {
            try {
                File file = jfc.getSelectedFile();
                if(!file.getName().contains(".json"))
                    return;
                MindMap m = ApplicationFramework.getInstance().getSerializer().loadMindMap(file);

                if(MainFrame.getInstance().getProjectView() == null || MainFrame.getInstance().getProjectView().getTabbedPane() == null || MainFrame.getInstance().getProjectView().getTabbedPane().getSelectedComponent() == null)
                    return;
                MindMapView view = ((MindMapView)MainFrame.getInstance().getProjectView().getTabbedPane().getSelectedComponent());
                MindMap mindMap1 = view.getMindMap();

                view.getMapSelectionModel().getSelectedElements().clear();

                for(MapNode mapNode : m.getChildren())
                {
                    mindMap1.addChild(mapNode);
                    mapNode.setParent(mindMap1);
                    if(mapNode instanceof Concept) {
                        view.getMapSelectionModel().getSelectedElements().add((Element) mapNode);
                        ((Concept) mapNode).setSelected(true);
                    }
                }

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}
