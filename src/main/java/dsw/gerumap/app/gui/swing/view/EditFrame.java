package dsw.gerumap.app.gui.swing.view;



import javax.swing.*;
import java.awt.*;

public class EditFrame extends JDialog {


    private JLabel lblAuthor;
    private JTextField tfName;
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
        tfName = new JTextField();
        tfName.setPreferredSize(new Dimension(100,25));
        btnOk = new JButton("OK");
        btnOk.addActionListener(MainFrame.getInstance().getActionManager().getOkAction());

        FlowLayout flowLayout = new FlowLayout();
        flowLayout.setHgap(30);
        flowLayout.setAlignment(FlowLayout.CENTER);
        flowLayout.setAlignOnBaseline(true);

        JPanel panel = new JPanel();
        panel.setLayout(flowLayout);
        panel.add(lblAuthor);
        panel.add(tfName);
        panel.add(btnOk);

        add(panel);



    }
}
