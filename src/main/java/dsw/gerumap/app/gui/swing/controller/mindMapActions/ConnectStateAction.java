package dsw.gerumap.app.gui.swing.controller.mindMapActions;

import dsw.gerumap.app.gui.swing.controller.AbstractGerumapAction;
import dsw.gerumap.app.gui.swing.view.MainFrame;

import java.awt.event.ActionEvent;

public class ConnectStateAction extends AbstractGerumapAction {

    public ConnectStateAction()
    {
        putValue(SMALL_ICON, loadIcon("/images/connection.png"));
        putValue(NAME, "Add Connection");
        putValue(SHORT_DESCRIPTION, "Add Connection");
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        MainFrame.getInstance().getProjectView().startConnectState();
    }
}
