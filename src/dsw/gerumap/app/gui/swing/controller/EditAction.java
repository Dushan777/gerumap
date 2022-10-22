package dsw.gerumap.app.gui.swing.controller;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class EditAction extends AbstractGerumapAction{

    public EditAction() {
        putValue(SMALL_ICON, loadIcon("images/edit.png"));
        putValue(NAME, "Edit");
        putValue(SHORT_DESCRIPTION, "Edit");
    }

    public void actionPerformed(ActionEvent arg0)
    {
        System.exit(0); // promeniti
    }

}
