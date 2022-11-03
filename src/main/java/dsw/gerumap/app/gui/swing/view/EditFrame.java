package dsw.gerumap.app.gui.swing.view;



import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
import java.awt.*;
@Getter
@Setter
public class EditFrame extends JDialog {

    private static EditFrame instance;

    private EditFrame()
    {

    }
    private JLabel lblAuthor;
    private JTextField tfAuthor;
    private JButton btnOk;
    public void initialise()
    {
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        int screenHeight = screenSize.height;
        int screenWidth = screenSize.width;
        setSize(screenWidth / 6,  screenHeight / 6);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(MainFrame.getInstance());
        setTitle("Edit author's name");

        BoxLayout boxLayout = new BoxLayout(getContentPane(), BoxLayout.Y_AXIS);
        getContentPane().setLayout(boxLayout);

        lblAuthor = new JLabel("Set author's name: ");
        tfAuthor = new JTextField();
        tfAuthor.setPreferredSize(new Dimension(100,25));
        btnOk = new JButton("OK");
        btnOk.addActionListener(MainFrame.getInstance().getActionManager().getOkAction());

        FlowLayout flowLayout = new FlowLayout();
        flowLayout.setHgap(30);
        flowLayout.setAlignment(FlowLayout.CENTER);
        flowLayout.setAlignOnBaseline(true);

        JPanel panel = new JPanel();
        panel.setLayout(flowLayout);
        panel.add(lblAuthor);
        panel.add(tfAuthor);
        panel.add(btnOk);

        add(panel);



    }

    public static EditFrame getInstance()
    {
        if(instance == null)
        {
            instance = new EditFrame();
            instance.initialise();
        }
        return instance;
    }

}
