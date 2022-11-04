package dsw.gerumap.app.gui.swing.controller;

import dsw.gerumap.app.gui.swing.tree.model.MapTreeItem;
import dsw.gerumap.app.gui.swing.view.EditFrame;
import dsw.gerumap.app.gui.swing.view.MainFrame;
import dsw.gerumap.app.mapRepository.composite.MapNode;
import dsw.gerumap.app.mapRepository.implementation.Project;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OkAction implements ActionListener {

    private String author; // TODO
    private MapNode project;

    @Override
    public void actionPerformed(ActionEvent e) {
        MapTreeItem selected = (MapTreeItem) MainFrame.getInstance().getMapTree().getSelectedNode();
        if(selected != null)
        {
            author = EditFrame.getInstance().getTfAuthor().getText();
            EditFrame.getInstance().getTfAuthor().setText("");
            project = selected.getMapNode();
            if(project instanceof Project)
            {
                ((Project) project).setAuthor(author);
                MainFrame.getInstance().getLbl().setText(project.toString());
            }
        }
        EditFrame.getInstance().dispose();



    }
}
