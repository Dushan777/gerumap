package dsw.gerumap.app.gui.swing.tree.controller;

import dsw.gerumap.app.gui.swing.tree.model.MapTreeItem;
import dsw.gerumap.app.mapRepository.implementation.Project;
import lombok.Getter;
import lombok.Setter;

import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.TreePath;

@Getter
@Setter
public class MapTreeSelectionListener implements TreeSelectionListener {

    private String name = "";  // TODO
    @Override
    public void valueChanged(TreeSelectionEvent e) {
        TreePath path = e.getPath();
        MapTreeItem treeItemSelected = (MapTreeItem)path.getLastPathComponent();

        if(treeItemSelected.getMapNode() instanceof Project)
            name = treeItemSelected.getMapNode().getName();

        System.out.println("Selektovan cvor:"+ treeItemSelected.getMapNode().getName());
        System.out.println("getPath: "+e.getPath());
    }
}
