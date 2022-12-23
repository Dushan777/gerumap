package dsw.gerumap.app.gui.swing.controller;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class MakePatternAction extends AbstractGerumapAction{

    public MakePatternAction() {

        putValue(SMALL_ICON, loadIcon("/images/makepattern.png"));
        putValue(NAME, "Make a pattern");
        putValue(SHORT_DESCRIPTION, "Make a pattern");
    }
    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
