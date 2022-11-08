package dsw.gerumap.app.gui.swing.controller;

import dsw.gerumap.app.gui.swing.tree.controller.MapTreeSelectionListener;
import dsw.gerumap.app.gui.swing.view.MainFrame;
import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
import java.awt.event.ActionEvent;

@Getter
@Setter
public class TabbedAction extends AbstractGerumapAction{

   private JPanel tab;
   private String tabName;
   private MapTreeSelectionListener treeSelectionListener;

    @Override
    public void actionPerformed(ActionEvent e) {

        tab = new JPanel();
        treeSelectionListener = new MapTreeSelectionListener();  // TODO
        tabName = treeSelectionListener.getName();    // TODO

        if (!tabName.equals("")) {

        }
    }
}
