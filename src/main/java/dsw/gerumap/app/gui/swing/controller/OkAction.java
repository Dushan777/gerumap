package dsw.gerumap.app.gui.swing.controller;

import dsw.gerumap.app.gui.swing.view.EditFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OkAction implements ActionListener {

    private String author; // TODO
    @Override
    public void actionPerformed(ActionEvent e) {
        author = EditFrame.getInstance().getTfAuthor().getText();
        EditFrame.getInstance().dispose();
    }
}
