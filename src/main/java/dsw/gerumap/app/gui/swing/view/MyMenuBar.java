package main.java.dsw.gerumap.app.gui.swing.view;

import javax.swing.*;

import java.awt.event.KeyEvent;


public class MyMenuBar extends JMenuBar {

    public MyMenuBar()
    {
        JMenu fileMenu = new JMenu("File");
        fileMenu.setMnemonic(KeyEvent.VK_F);
        fileMenu.add(MainFrame.getInstance().getActionManager().getExitAction());
        fileMenu.add(MainFrame.getInstance().getActionManager().getNewProjectAction());

        JMenu helpMenu = new JMenu("Help");
        helpMenu.setMnemonic(KeyEvent.VK_H);
        helpMenu.add(MainFrame.getInstance().getActionManager().getEditAction());

        JMenu infoMenu = new JMenu("Info"); // jos ne radi nista
        infoMenu.setMnemonic(KeyEvent.VK_I);
        infoMenu.add(MainFrame.getInstance().getActionManager().getInfoAction());


        this.add(fileMenu);
        this.add(helpMenu);
        this.add(infoMenu);

    }


}
