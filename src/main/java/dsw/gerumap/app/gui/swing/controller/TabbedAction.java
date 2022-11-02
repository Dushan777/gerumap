package dsw.gerumap.app.gui.swing.controller;

import dsw.gerumap.app.gui.swing.view.TabbedFrame;
import lombok.Getter;
import lombok.Setter;

import java.awt.event.ActionEvent;

@Getter
@Setter
public class TabbedAction extends AbstractGerumapAction{

    @Override
    public void actionPerformed(ActionEvent e) {

        TabbedFrame tabbedFrame = new TabbedFrame();
        tabbedFrame.initialise();
        tabbedFrame.setVisible(true);
    }
}
