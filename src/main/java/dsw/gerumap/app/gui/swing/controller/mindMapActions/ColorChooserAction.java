package dsw.gerumap.app.gui.swing.controller.mindMapActions;

import dsw.gerumap.app.gui.swing.controller.AbstractGerumapAction;
import dsw.gerumap.app.gui.swing.view.MainFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class ColorChooserAction extends AbstractGerumapAction {


    public ColorChooserAction()
    {
        putValue(SMALL_ICON, loadIcon("/images/edit.png"));
        putValue(NAME, "Customize");
        putValue(SHORT_DESCRIPTION, "Customize");
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        JFrame frame = new JFrame();
        JColorChooser colorChooser = new JColorChooser();
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        int screenHeight = screenSize.height;
        int screenWidth = screenSize.width;
        frame.setSize(screenWidth / 4,  screenHeight / 2);
        frame.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        frame.setLocationRelativeTo(MainFrame.getInstance());
        frame.setTitle("Color");
        frame.add(colorChooser);
        frame.setVisible(true);
        MainFrame.getInstance().getProjectView().startColorState();
    }
}
