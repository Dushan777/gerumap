package dsw.gerumap.app.gui.swing;

import dsw.gerumap.app.core.ApplicationFramework;
import dsw.gerumap.app.core.Gui;
import dsw.gerumap.app.gui.swing.view.MainFrame;
import dsw.gerumap.app.messageGenerator.Message;

import javax.swing.*;

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

    @Override
    public void update(Object notification) {
        JOptionPane.showMessageDialog(new JFrame(), ((Message)notification).toString());
    }
}
