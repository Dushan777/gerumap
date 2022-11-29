package dsw.gerumap.app.gui.swing.controller.mindMapActions;

import dsw.gerumap.app.gui.swing.controller.AbstractGerumapAction;
import dsw.gerumap.app.gui.swing.view.MainFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.concurrent.Flow;

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
        JTextField textField = new JTextField(10);
        JButton button = new JButton("Ok");

        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        colorChooser.setPreferredSize(new Dimension(100,100));

        int screenHeight = screenSize.height;
        int screenWidth = screenSize.width;
        frame.setSize(screenWidth / 2,  screenHeight / 2);
        frame.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        frame.setLocationRelativeTo(MainFrame.getInstance());
        frame.setTitle("Color");

        BoxLayout boxLayout = new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS);
        frame.getContentPane().setLayout(boxLayout);

        frame.add(new JLabel("Unesi debljinu linije: "));
        frame.add(textField);
        frame.add(colorChooser);
        frame.add(button);
        frame.setVisible(true);

        MainFrame.getInstance().getProjectView().startColorState();
    }
}
