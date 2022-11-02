package dsw.gerumap.app.gui.swing.view;


import javax.swing.*;

public class Toolbar extends JToolBar {

    public Toolbar()
    {
        super(HORIZONTAL);
        setFloatable(false);

        add(MainFrame.getInstance().getActionManager().getNewProjectAction());
        add(MainFrame.getInstance().getActionManager().getRemoveAction());
        add(MainFrame.getInstance().getActionManager().getEditAction());
        add(MainFrame.getInstance().getActionManager().getInfoAction());
    }


}
