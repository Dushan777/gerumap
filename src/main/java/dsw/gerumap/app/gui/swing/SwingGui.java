package main.java.dsw.gerumap.app.gui.swing;

import main.java.dsw.gerumap.app.core.Gui;
import main.java.dsw.gerumap.app.gui.swing.view.MainFrame;

public class SwingGui implements Gui {

    private MainFrame instance;

    public SwingGui()
    {

    }


    @Override
    public void start() {
        instance = MainFrame.getInstance();
        instance.setVisible(true);
    }
}
