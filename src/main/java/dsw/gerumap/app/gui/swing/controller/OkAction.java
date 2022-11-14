package dsw.gerumap.app.gui.swing.controller;

import dsw.gerumap.app.core.ApplicationFramework;
import dsw.gerumap.app.gui.swing.errorLogger.EventType;
import dsw.gerumap.app.gui.swing.tree.model.MapTreeItem;
import dsw.gerumap.app.gui.swing.view.EditFrame;
import dsw.gerumap.app.gui.swing.view.MainFrame;
import dsw.gerumap.app.mapRepository.composite.MapNode;
import dsw.gerumap.app.mapRepository.implementation.Project;
import dsw.gerumap.app.messageGenerator.MessageGeneratorImplementation;

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
            if(!author.matches("[a-zA-Z0-9]+"))
            {
                ((MessageGeneratorImplementation) ApplicationFramework.getInstance().getMessageGenerator()).setType(EventType.CANNOT_SET_NAME);
                ApplicationFramework.getInstance().getMessageGenerator().generateMessage();
                EditFrame.getInstance().getTfAuthor().setText("");
                return;
            }
            EditFrame.getInstance().getTfAuthor().setText("");
            project = selected.getMapNode();
            if(project instanceof Project)
            {
                ((Project) project).setAuthor(author);
                MainFrame.getInstance().getProjectView().getLbl().setText(project.toString());
            }
            else
            {
                ((MessageGeneratorImplementation) ApplicationFramework.getInstance().getMessageGenerator()).setType(EventType.CANNOT_SET_AUTHOR);
                ApplicationFramework.getInstance().getMessageGenerator().generateMessage();
            }
        }
        else
        {
            ((MessageGeneratorImplementation)ApplicationFramework.getInstance().getMessageGenerator()).setType(EventType.NOTHING_IS_SELECTED);
            ApplicationFramework.getInstance().getMessageGenerator().generateMessage();
        }
        EditFrame.getInstance().getTfAuthor().setText("");
        EditFrame.getInstance().dispose();



    }
}
