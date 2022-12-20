package dsw.gerumap.app.gui.swing.tree;

import dsw.gerumap.app.gui.swing.tree.model.MapTreeItem;
import dsw.gerumap.app.gui.swing.tree.view.MapTreeView;
import dsw.gerumap.app.mapRepository.implementation.Project;
import dsw.gerumap.app.mapRepository.implementation.ProjectExplorer;


public interface MapTree {

    MapTreeView generateTree(ProjectExplorer projectExplorer);
    void addChild(MapTreeItem parent);

    void removeChild(MapTreeItem parent);
    MapTreeItem getSelectedNode();
    void loadProject(Project node);
}
