package dsw.gerumap.app.gui.swing.tree.controller;


import dsw.gerumap.app.core.ApplicationFramework;
import dsw.gerumap.app.gui.swing.errorLogger.EventType;
import dsw.gerumap.app.gui.swing.tree.model.MapTreeItem;
import dsw.gerumap.app.gui.swing.view.MainFrame;
import dsw.gerumap.app.mapRepository.composite.MapNode;
import dsw.gerumap.app.mapRepository.composite.MapNodeComposite;
import dsw.gerumap.app.mapRepository.implementation.MindMap;
import dsw.gerumap.app.mapRepository.implementation.Project;
import dsw.gerumap.app.messageGenerator.MessageGeneratorImplementation;
import lombok.Getter;
import javax.swing.*;
import javax.swing.tree.DefaultTreeCellEditor;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.TreePath;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.util.EventObject;

@Getter
public class MapTreeCellEditor extends DefaultTreeCellEditor implements ActionListener {


    private Object clickedOn = null;
    private JTextField edit = null;

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
                return true;
            }
            else if (((MouseEvent)arg0).getClickCount() == 2)
            {
                MapNode node = MainFrame.getInstance().getMapTree().getSelectedNode().getMapNode();
                if(node instanceof Project)
                    MainFrame.getInstance().getProjectView().setProject((Project)node);
                if(node instanceof MindMap)
                    MainFrame.getInstance().getProjectView().setProject((Project)((MindMap)node).getParent());


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
        if(!e.getActionCommand().matches("[a-zA-Z0-9]+"))
        {
            editable = false;
            ((MessageGeneratorImplementation) ApplicationFramework.getInstance().getMessageGenerator()).setType(EventType.CANNOT_SET_NAME);
            ApplicationFramework.getInstance().getMessageGenerator().generateMessage();

        }
       if (editable)
            clicked.setName(e.getActionCommand());


    }



}
