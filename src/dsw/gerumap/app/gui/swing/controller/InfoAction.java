package dsw.gerumap.app.gui.swing.controller;


import dsw.gerumap.app.gui.swing.view.InfoFrame;

import java.awt.event.ActionEvent;

public class InfoAction extends AbstractGerumapAction{

    public InfoAction()
    {
        putValue(SMALL_ICON ,loadIcon("images/info.png"));

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        InfoFrame infoFrame = new InfoFrame();
        infoFrame.initialise();
        infoFrame.setVisible(true);
    }
}
