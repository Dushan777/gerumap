package dsw.gerumap.app.gui.swing.controller.mindMapActions;

import dsw.gerumap.app.gui.swing.controller.AbstractGerumapAction;
import dsw.gerumap.app.gui.swing.view.MainFrame;
import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.concurrent.Flow;

@Getter
@Setter
public class ColorChooserAction extends AbstractGerumapAction {

    private JFrame frame;
    private JColorChooser colorChooser;
    private JTextField textField;
    private JTextField textFieldText;
    private Boolean flag;
    public ColorChooserAction()
    {
        putValue(SMALL_ICON, loadIcon("/images/edit.png"));
        putValue(NAME, "Customize");
        putValue(SHORT_DESCRIPTION, "Customize");
    }
    @Override
    public void actionPerformed(ActionEvent e) {

        frame = new JFrame();
        colorChooser = new JColorChooser(Color.BLACK);
        textField = new JTextField();
        textFieldText = new JTextField();

        flag = false;
        JButton button = new JButton("Confirm");
        button.addActionListener(MainFrame.getInstance().getActionManager().getConfirmAction());

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
        panel.add(new JLabel("Insert text: "));
        panel.add(textFieldText);

        textField.setPreferredSize(new Dimension(150,20));
        textFieldText.setPreferredSize(new Dimension(150,20));
        flowLayout.setAlignment(FlowLayout.CENTER);


        JPanel panel1 = new JPanel();
        BoxLayout boxLayout1 = new BoxLayout(panel1, BoxLayout.Y_AXIS);
        panel1.setLayout(boxLayout1);
        panel1.add(colorChooser);
        panel1.add(button);

        frame.add(panel);
        frame.add(panel1);
        frame.setVisible(true);
        frame.addWindowListener(new WindowAdapter()
        {
            @Override
            public void windowClosing(WindowEvent e)
            {
                flag = true;
            }
        });

    }
}
