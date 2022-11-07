package dsw.gerumap.app.gui.swing.controller;

import dsw.gerumap.app.gui.swing.tree.model.MapTreeItem;
import dsw.gerumap.app.gui.swing.view.MainFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;


public class RemoveAction extends AbstractGerumapAction {


    public RemoveAction() {
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(
                KeyEvent.VK_F4, ActionEvent.ALT_MASK));
        putValue(SMALL_ICON, loadIcon("/images/remove.png"));
        putValue(NAME, "Remove");
        putValue(SHORT_DESCRIPTION, "Remove");
    }

    public void actionPerformed(ActionEvent arg0) {
        MapTreeItem selected = (MapTreeItem) MainFrame.getInstance().getMapTree().getSelectedNode();
        if (selected != null) {
            MainFrame.getInstance().getMapTree().getSelectedNode().removeFromParent();
            MainFrame.getInstance().getMapTree().removeChild(selected);
        }

    }

}
