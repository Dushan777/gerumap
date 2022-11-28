package dsw.gerumap.app.gui.swing.controller.mindMapActions;

import dsw.gerumap.app.gui.swing.controller.AbstractGerumapAction;

import java.awt.event.ActionEvent;

public class SelectStateAction extends AbstractGerumapAction {

    public SelectStateAction()
    {
        putValue(SMALL_ICON, loadIcon("/images/edit.png"));
        putValue(NAME, "Select");
        putValue(SHORT_DESCRIPTION, "Select");
    }
    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
