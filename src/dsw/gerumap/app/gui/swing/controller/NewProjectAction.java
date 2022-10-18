package dsw.gerumap.app.gui.swing.controller;

import java.awt.event.ActionEvent;

public class NewProjectAction extends AbstractGerumapAction{
    public NewProjectAction() {
      /*  putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(
                KeyEvent.VK_F4, ActionEvent.ALT_MASK)); // promeniti shortcut
        putValue(SMALL_ICON, loadIcon("images/log-out.png"));
        putValue(NAME, "Exit");
        putValue(SHORT_DESCRIPTION, "Exit");*/
    }

    public void actionPerformed(ActionEvent arg0)
    {
        System.exit(0); // promeniti
    }

}
