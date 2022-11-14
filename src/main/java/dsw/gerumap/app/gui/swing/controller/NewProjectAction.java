package dsw.gerumap.app.gui.swing.controller;

import dsw.gerumap.app.core.ApplicationFramework;
import dsw.gerumap.app.gui.swing.errorLogger.EventType;
import dsw.gerumap.app.gui.swing.tree.model.MapTreeItem;
import dsw.gerumap.app.gui.swing.view.MainFrame;
import dsw.gerumap.app.mapRepository.implementation.Element;
import dsw.gerumap.app.messageGenerator.MessageGeneratorImplementation;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class NewProjectAction extends AbstractGerumapAction {
    public NewProjectAction() {
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(
                KeyEvent.VK_N, ActionEvent.CTRL_MASK));
        putValue(SMALL_ICON, loadIcon("/images/add.png"));
        putValue(NAME, "New Project");
        putValue(SHORT_DESCRIPTION, "New Project"); //a
    }

    public void actionPerformed(ActionEvent arg0)
    {

        MapTreeItem selected = (MapTreeItem) MainFrame.getInstance().getMapTree().getSelectedNode();
        if(selected == null)
        {
            ((MessageGeneratorImplementation)ApplicationFramework.getInstance().getMessageGenerator()).setType(EventType.NOTHING_IS_SELECTED);
            ApplicationFramework.getInstance().getMessageGenerator().generateMessage();
            return;
        }
        if(selected.getMapNode() instanceof Element)
        {
            ((MessageGeneratorImplementation)ApplicationFramework.getInstance().getMessageGenerator()).setType(EventType.CANNOT_ADD_CHILD);
            ApplicationFramework.getInstance().getMessageGenerator().generateMessage();
            return;
        }
        MainFrame.getInstance().getMapTree().addChild(selected);

    }

}
