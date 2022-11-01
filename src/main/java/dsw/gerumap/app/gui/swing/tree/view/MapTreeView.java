package dsw.gerumap.app.gui.swing.tree.view;



import dsw.gerumap.app.gui.swing.tree.controller.MapTreeCellEditor;
import dsw.gerumap.app.gui.swing.tree.controller.MapTreeSelectionListener;

import javax.swing.*;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultTreeModel;

public class MapTreeView extends JTree {


    public MapTreeView(DefaultTreeModel defaultTreeModel) {
        setModel(defaultTreeModel);
        MapTreeCellRenderer ruTreeCellRenderer = new MapTreeCellRenderer();
        addTreeSelectionListener((TreeSelectionListener) new MapTreeSelectionListener());
        setCellEditor(new MapTreeCellEditor(this, ruTreeCellRenderer));
        setCellRenderer(ruTreeCellRenderer);
        setEditable(true);
    }
}