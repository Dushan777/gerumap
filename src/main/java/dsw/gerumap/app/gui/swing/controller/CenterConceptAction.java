package dsw.gerumap.app.gui.swing.controller;


import java.awt.event.ActionEvent;

public class CenterConceptAction extends AbstractGerumapAction {

    public CenterConceptAction() {
        putValue(SMALL_ICON, loadIcon("/images/center.png"));
        putValue(NAME, "Center Concept");
        putValue(SHORT_DESCRIPTION, "Center Concept");
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
