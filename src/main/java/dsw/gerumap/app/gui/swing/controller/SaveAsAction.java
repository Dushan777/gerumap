package dsw.gerumap.app.gui.swing.controller;

import dsw.gerumap.app.core.ApplicationFramework;
import dsw.gerumap.app.gui.swing.view.MainFrame;
import dsw.gerumap.app.mapRepository.implementation.Project;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.File;

public class SaveAsAction extends AbstractGerumapAction {

    public SaveAsAction() {
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(
                KeyEvent.VK_S, ActionEvent.CTRL_MASK + ActionEvent.SHIFT_MASK));
        putValue(SMALL_ICON, loadIcon("/images/saveas.png"));
        putValue(NAME, "Save as");
        putValue(SHORT_DESCRIPTION, "Save as");
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        JFileChooser jfc = new JFileChooser();

        if (MainFrame.getInstance().getMapTree().getSelectedNode() == null || !(MainFrame.getInstance().getMapTree().getSelectedNode().getMapNode() instanceof Project)) return;

        Project project = (Project) MainFrame.getInstance().getMapTree().getSelectedNode().getMapNode();
        File projectFile = null;

        if (!project.isChanged()) {
            return;
        }


            if (jfc.showSaveDialog(MainFrame.getInstance()) == JFileChooser.APPROVE_OPTION) {
                projectFile = jfc.getSelectedFile();
                project.setFilePath(projectFile.getPath());
            } else
                return;

         ApplicationFramework.getInstance().getSerializer().saveProject(project);

        project.setChanged(false);
    }

}
