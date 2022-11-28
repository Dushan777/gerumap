package dsw.gerumap.app.gui.swing.controller.mindMapActions;

import dsw.gerumap.app.gui.swing.controller.AbstractGerumapAction;

import java.awt.event.ActionEvent;

public class AddStateAction extends AbstractGerumapAction {

    public AddStateAction()
    {
        putValue(SMALL_ICON, loadIcon("/images/edit.png"));
        putValue(NAME, "Add Element");
        putValue(SHORT_DESCRIPTION, "Add Element");
    }
    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
