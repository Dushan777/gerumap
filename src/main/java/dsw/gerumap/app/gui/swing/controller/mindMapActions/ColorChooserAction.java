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
        JTextField textField = new JTextField();
        JButton button = new JButton("OK");
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
        FlowLayout flowLayout = new FlowLayout();
        flowLayout.setAlignOnBaseline(true);

        JPanel panel = new JPanel();
        panel.setLayout(flowLayout);
        panel.add(new JLabel("Choose line stroke size: "));
        panel.add(textField);

        textField.setPreferredSize(new Dimension(150,20));
        flowLayout.setAlignment(FlowLayout.CENTER);


        JPanel panel1 = new JPanel();
        BoxLayout boxLayout1 = new BoxLayout(panel1, BoxLayout.Y_AXIS);
        panel1.setLayout(boxLayout1);
        panel1.add(colorChooser);
        panel1.add(button);

        frame.add(panel);
        frame.add(panel1);
        frame.setVisible(true);

        MainFrame.getInstance().getProjectView().startColorState();
    }
}
