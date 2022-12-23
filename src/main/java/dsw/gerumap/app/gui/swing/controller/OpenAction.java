package dsw.gerumap.app.gui.swing.controller;

import dsw.gerumap.app.core.ApplicationFramework;
import dsw.gerumap.app.gui.swing.view.MainFrame;
import dsw.gerumap.app.mapRepository.implementation.Project;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.File;

public class OpenAction extends AbstractGerumapAction{

    public OpenAction() {
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(
                KeyEvent.VK_O, ActionEvent.CTRL_MASK));
        putValue(SMALL_ICON, loadIcon("/images/open.png"));
        putValue(NAME, "Open");
        putValue(SHORT_DESCRIPTION, "Open");
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

        if (jfc.showOpenDialog(MainFrame.getInstance()) == JFileChooser.APPROVE_OPTION) {
            try {
                File file = jfc.getSelectedFile();
                if(!file.getName().contains(".json"))
                    return;
                Project p = ApplicationFramework.getInstance().getSerializer().loadProject(file);
                System.out.println(p.getChildren());
                MainFrame.getInstance().getMapTree().loadProject(p);

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

}
