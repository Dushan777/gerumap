package dsw.gerumap.app.gui.swing.controller;

import dsw.gerumap.app.AppCore;
import dsw.gerumap.app.core.ApplicationFramework;
import dsw.gerumap.app.gui.swing.tree.model.MapTreeItem;
import dsw.gerumap.app.gui.swing.view.MainFrame;
import dsw.gerumap.app.mapRepository.factory.FactoryUtils;
import dsw.gerumap.app.mapRepository.factory.NodeFactory;

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
        MainFrame.getInstance().getMapTree().addChild(selected);
      //  NodeFactory nodeFactory = FactoryUtils.getFactory(selected.getMapNode());
      //  MapTreeItem mapTreeItem = new MapTreeItem(nodeFactory.getNode());
      //  MainFrame.getInstance().getMapTree().addChild(mapTreeItem);
    }

}
