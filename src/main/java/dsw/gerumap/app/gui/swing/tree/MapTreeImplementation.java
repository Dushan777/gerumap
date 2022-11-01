package main.java.dsw.gerumap.app.gui.swing.tree;

import main.java.dsw.gerumap.app.gui.swing.tree.model.MapTreeItem;
import main.java.dsw.gerumap.app.gui.swing.tree.view.MapTreeView;
import main.java.dsw.gerumap.app.mapRepository.composite.MapNode;
import main.java.dsw.gerumap.app.mapRepository.composite.MapNodeComposite;
import main.java.dsw.gerumap.app.mapRepository.implementation.Project;
import main.java.dsw.gerumap.app.mapRepository.implementation.ProjectExplorer;

import javax.swing.*;
import javax.swing.tree.DefaultTreeModel;
import java.util.Random;

public class MapTreeImplementation implements MapTree{

    private MapTreeView treeView;
    private DefaultTreeModel treeModel;

    @Override
    public MapTreeView generateTree(ProjectExplorer projectExplorer) {
        MapTreeItem root = new MapTreeItem(projectExplorer);
        treeModel = new DefaultTreeModel(root);
        treeView = new MapTreeView(treeModel);
        return treeView;
    }

    @Override
    public void addChild(MapTreeItem parent) {

        if (!(parent.getMapNode() instanceof MapNodeComposite))
            return;

        MapNode child = createChild(parent.getMapNode());
        parent.add(new MapTreeItem(child));
        ((MapNodeComposite) parent.getMapNode()).addChild(child);
        treeView.expandPath(treeView.getSelectionPath());
        SwingUtilities.updateComponentTreeUI(treeView);
    }

    @Override
    public MapTreeItem getSelectedNode() {
        return (MapTreeItem) treeView.getLastSelectedPathComponent();
    }

    private MapNode createChild(MapNode parent) {
        if (parent instanceof ProjectExplorer)
            return  new Project("Project" +new Random().nextInt(100), parent);
        return null;
    }

}
