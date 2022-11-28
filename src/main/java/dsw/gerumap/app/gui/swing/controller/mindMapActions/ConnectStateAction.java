package dsw.gerumap.app.gui.swing.controller.mindMapActions;

import dsw.gerumap.app.gui.swing.controller.AbstractGerumapAction;

import java.awt.event.ActionEvent;

public class ConnectStateAction extends AbstractGerumapAction {

    public ConnectStateAction()
    {
        putValue(SMALL_ICON, loadIcon("/images/edit.png"));
        putValue(NAME, "Add Connection");
        putValue(SHORT_DESCRIPTION, "Add Connection");
    }
    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
