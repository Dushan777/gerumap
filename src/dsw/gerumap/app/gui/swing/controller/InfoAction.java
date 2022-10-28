package dsw.gerumap.app.gui.swing.controller;


import java.awt.event.ActionEvent;

public class InfoAction extends AbstractGerumapAction{

    public InfoAction()
    {
        putValue(SMALL_ICON ,loadIcon("images/info.png"));
        putValue(NAME, "........................"); // promeniti text

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
