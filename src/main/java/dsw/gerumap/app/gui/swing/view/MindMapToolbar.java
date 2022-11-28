package dsw.gerumap.app.gui.swing.view;

import javax.swing.*;

public class MindMapToolbar extends JToolBar {

    public MindMapToolbar()
    {
        super(VERTICAL);
        setFloatable(false);
        // izmeniti na odgovarajuce akcije
        add(MainFrame.getInstance().getActionManager().getNewProjectAction());
        add(MainFrame.getInstance().getActionManager().getRemoveAction());
        add(MainFrame.getInstance().getActionManager().getEditAction());
        add(MainFrame.getInstance().getActionManager().getInfoAction());
    }

}
