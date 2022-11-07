package dsw.gerumap.app.gui.swing.tree.controller;


import dsw.gerumap.app.gui.swing.tree.model.MapTreeItem;
import dsw.gerumap.app.gui.swing.view.MainFrame;
import dsw.gerumap.app.mapRepository.composite.MapNode;
import dsw.gerumap.app.mapRepository.composite.MapNodeComposite;
import dsw.gerumap.app.mapRepository.implementation.Project;
import lombok.Getter;

import javax.swing.*;
import javax.swing.tree.DefaultTreeCellEditor;
import javax.swing.tree.DefaultTreeCellRenderer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.util.EventObject;

@Getter
public class MapTreeCellEditor extends DefaultTreeCellEditor implements ActionListener {


    private Object clickedOn = null;
    private JTextField edit = null;
    private int brojac;

    public MapTreeCellEditor(JTree arg0, DefaultTreeCellRenderer arg1) {
        super(arg0, arg1);
    }

    public Component getTreeCellEditorComponent(JTree arg0, Object arg1, boolean arg2, boolean arg3, boolean arg4, int arg5) {
        super.getTreeCellEditorComponent(arg0,arg1,arg2,arg3,arg4,arg5);
        clickedOn = arg1;
        edit = new JTextField(arg1.toString());
        edit.addActionListener(this);
        return (Component) edit;
    }

    public boolean isCellEditable(EventObject arg0) {

        if (arg0 instanceof MouseEvent)
            if (((MouseEvent)arg0).getClickCount() == 3) {
                brojac = 0;
                return true;
            }
            else if (((MouseEvent)arg0).getClickCount() == 2)
            {
                brojac = 2;
            }
        return false;
    }

    public void actionPerformed(ActionEvent e) {

        if (!(clickedOn instanceof MapTreeItem))
            return;
        MapTreeItem clicked = (MapTreeItem) clickedOn;
        MapNodeComposite parent = (MapNodeComposite) clicked.getMapNode().getParent();

        boolean editable = true;
        for (MapNode child : parent.getChildren()) {
            if (!(child.getName().equals(e.getActionCommand()))) {
                editable = true;
            } else {
                editable = false;
                break;
            }
        }
       if (editable)
            clicked.setName(e.getActionCommand());


    }



}
