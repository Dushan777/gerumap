package dsw.gerumap.app.gui.swing.controller.mindMapActions;

import dsw.gerumap.app.gui.swing.controller.AbstractGerumapAction;

import java.awt.event.ActionEvent;

public class MoveStateAction extends AbstractGerumapAction {

    public MoveStateAction()
    {
        putValue(SMALL_ICON, loadIcon("/images/edit.png"));
        putValue(NAME, "Move");
        putValue(SHORT_DESCRIPTION, "Move");
    }
    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
