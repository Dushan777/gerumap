package dsw.gerumap.app.gui.swing.controller;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class NewProjectAction extends AbstractGerumapAction{
    public NewProjectAction() {
        /*putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(
                KeyEvent.VK_N, ActionEvent.CTRL_MASK));
        putValue(SMALL_ICON, loadIcon("images/add-files.png"));
        putValue(NAME, "New Project");
        putValue(SHORT_DESCRIPTION, "New Project");*/
    }

    public void actionPerformed(ActionEvent arg0)
    {
        System.exit(0); // promeniti
    }

}
