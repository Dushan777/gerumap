package dsw.gerumap.app.gui.swing.view;


import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
@Getter
@Setter
public class Toolbar extends JToolBar {

    private JColorChooser colorChooser = new JColorChooser();

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
