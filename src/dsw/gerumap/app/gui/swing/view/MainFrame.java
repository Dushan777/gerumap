package dsw.gerumap.app.gui.swing.view;

import dsw.gerumap.app.AppCore;

public class MainFrame {

    private static MainFrame instance;


    private MainFrame()
    {

    }

    public static MainFrame getInstance()
    {
        if(instance == null)
        {
            instance = new MainFrame();
        }
        return instance;
    }

}
