package dsw.gerumap.app.gui.swing;

import dsw.gerumap.app.core.Gui;
import dsw.gerumap.app.gui.swing.view.MainFrame;
import dsw.gerumap.app.mapRepository.command.CommandManager;
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
        disableRedoAction();
        disableUndoAction();
        instance.setVisible(true);
    }


    @Override
    public void disableUndoAction() {
        MainFrame.getInstance().getActionManager().getUndoAction().setEnabled(false);

    }

    @Override
    public void disableRedoAction() {
        MainFrame.getInstance().getActionManager().getRedoAction().setEnabled(false);

    }
    @Override
    public void enableRedoAction() {
        MainFrame.getInstance().getActionManager().getRedoAction().setEnabled(true);


    }
    @Override
    public void enableUndoAction() {
        MainFrame.getInstance().getActionManager().getUndoAction().setEnabled(true);

    }

    @Override
    public void update(Object notification) {
        JOptionPane.showMessageDialog(new JFrame(), ((Message)notification).toString());
    }
}
