package dsw.gerumap.app.gui.swing.view;

import javax.swing.*;

import java.awt.event.KeyEvent;


public class MyMenuBar extends JMenuBar {

    public MyMenuBar()
    {
        JMenu fileMenu = new JMenu("File");
        fileMenu.setMnemonic(KeyEvent.VK_F);
        fileMenu.add(MainFrame.getInstance().getActionManager().getNewProjectAction());
        fileMenu.add(MainFrame.getInstance().getActionManager().getRemoveAction());
        fileMenu.add(MainFrame.getInstance().getActionManager().getSaveAction());
        fileMenu.add(MainFrame.getInstance().getActionManager().getSaveAsAction());
        fileMenu.add(MainFrame.getInstance().getActionManager().getOpenAction());
        fileMenu.add(MainFrame.getInstance().getActionManager().getMakePatternAction());
        fileMenu.add(MainFrame.getInstance().getActionManager().getChoosePatternAction());

        JMenu helpMenu = new JMenu("Help");
        helpMenu.setMnemonic(KeyEvent.VK_H);
        helpMenu.add(MainFrame.getInstance().getActionManager().getEditAction());

        JMenu infoMenu = new JMenu("Info");
        infoMenu.setMnemonic(KeyEvent.VK_I);
        infoMenu.add(MainFrame.getInstance().getActionManager().getInfoAction());


        this.add(fileMenu);
        this.add(helpMenu);
        this.add(infoMenu);

    }


}
