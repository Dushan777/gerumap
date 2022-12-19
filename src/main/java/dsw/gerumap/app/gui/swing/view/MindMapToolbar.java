package dsw.gerumap.app.gui.swing.view;

import javax.swing.*;

public class MindMapToolbar extends JToolBar {

    public MindMapToolbar()
    {
        super(VERTICAL);
        setFloatable(false);
        add(MainFrame.getInstance().getActionManager().getSelectStateAction());
        add(MainFrame.getInstance().getActionManager().getAddStateAction());
        add(MainFrame.getInstance().getActionManager().getConnectStateAction());
        add(MainFrame.getInstance().getActionManager().getMoveStateAction());
        add(MainFrame.getInstance().getActionManager().getRemoveStateAction());
        add(MainFrame.getInstance().getActionManager().getZoomStateAction());
        add(MainFrame.getInstance().getActionManager().getZoomOutStateAction());
        add(MainFrame.getInstance().getActionManager().getColorChooserAction());

    }

}
