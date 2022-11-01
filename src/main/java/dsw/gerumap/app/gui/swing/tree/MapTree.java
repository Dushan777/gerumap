package main.java.dsw.gerumap.app.gui.swing.tree;

import main.java.dsw.gerumap.app.gui.swing.tree.model.MapTreeItem;
import main.java.dsw.gerumap.app.gui.swing.tree.view.MapTreeView;
import main.java.dsw.gerumap.app.mapRepository.implementation.ProjectExplorer;

public interface MapTree {

    MapTreeView generateTree(ProjectExplorer projectExplorer);
    void addChild(MapTreeItem parent);
    MapTreeItem getSelectedNode();

}
