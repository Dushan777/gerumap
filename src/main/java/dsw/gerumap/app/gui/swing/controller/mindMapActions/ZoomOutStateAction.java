package dsw.gerumap.app.gui.swing.controller.mindMapActions;

import dsw.gerumap.app.gui.swing.controller.AbstractGerumapAction;

import java.awt.event.ActionEvent;

public class ZoomOutStateAction extends AbstractGerumapAction {

    public ZoomOutStateAction()
    {
        putValue(SMALL_ICON, loadIcon("/images/zoomout.png"));
        putValue(NAME, "Zoom Out");
        putValue(SHORT_DESCRIPTION, "Zoom Out");
    }
    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
