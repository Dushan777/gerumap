package dsw.gerumap.app.gui.swing.controller;


import dsw.gerumap.app.gui.swing.view.EditFrame;

import java.awt.event.ActionEvent;


public class EditAction extends AbstractGerumapAction {

    public EditAction() {
        putValue(SMALL_ICON, loadIcon("/images/edit.png"));
        putValue(NAME, "Edit");
        putValue(SHORT_DESCRIPTION, "Edit");
    }

    public void actionPerformed(ActionEvent arg0)
    {
        EditFrame editFrame = new EditFrame();
        editFrame.initialise();
        editFrame.setVisible(true);
    }

}
