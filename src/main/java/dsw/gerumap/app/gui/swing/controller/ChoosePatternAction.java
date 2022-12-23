package dsw.gerumap.app.gui.swing.controller;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class ChoosePatternAction extends AbstractGerumapAction{

    public ChoosePatternAction() {

        putValue(SMALL_ICON, loadIcon("/images/choosepattern.png"));
        putValue(NAME, "Choose a pattern");
        putValue(SHORT_DESCRIPTION, "Choose a pattern");
    }
    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
