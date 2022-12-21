package dsw.gerumap.app.gui.swing.controller;

import dsw.gerumap.app.core.ApplicationFramework;
import dsw.gerumap.app.gui.swing.errorLogger.EventType;
import dsw.gerumap.app.gui.swing.view.MainFrame;
import dsw.gerumap.app.mapRepository.implementation.Project;
import dsw.gerumap.app.messageGenerator.MessageGeneratorImplementation;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.File;

public class SaveAction extends AbstractGerumapAction {

    public SaveAction() {
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(
                KeyEvent.VK_S, ActionEvent.CTRL_MASK));
        putValue(SMALL_ICON, loadIcon("/images/save.png"));
        putValue(NAME, "Save");
        putValue(SHORT_DESCRIPTION, "Save");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JFileChooser jfc = new JFileChooser();

        if (MainFrame.getInstance().getMapTree().getSelectedNode() == null || !(MainFrame.getInstance().getMapTree().getSelectedNode().getMapNode() instanceof Project))
        {
            ((MessageGeneratorImplementation) ApplicationFramework.getInstance().getMessageGenerator()).setType(EventType.MUST_CHOOSE_PROJECT);
            ApplicationFramework.getInstance().getMessageGenerator().generateMessage();
            return;
        }
        

        Project project = (Project) MainFrame.getInstance().getMapTree().getSelectedNode().getMapNode();
        File projectFile = null;

        if (!project.isChanged()) {
            return;
        }

        if (project.getFilePath() == null || project.getFilePath().isEmpty()) {
            if (jfc.showSaveDialog(MainFrame.getInstance()) == JFileChooser.APPROVE_OPTION) {
                projectFile = jfc.getSelectedFile();
                project.setFilePath(projectFile.getPath());
                if(!projectFile.getPath().contains(".json"))
                    project.setFilePath(projectFile.getPath() + ".json");

            } else {
                return;
            }

        }


        ApplicationFramework.getInstance().getSerializer().saveProject(project);

        project.setChanged(false);
    }
}
