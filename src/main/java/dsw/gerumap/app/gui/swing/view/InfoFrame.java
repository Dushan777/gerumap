package dsw.gerumap.app.gui.swing.view;

import lombok.NoArgsConstructor;

import javax.swing.*;
import java.awt.*;

@NoArgsConstructor
public class InfoFrame extends JDialog {

    private JLabel lblD, lblDName;
    private JLabel lblU, lblUName;

    public void initialise()
    {
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        int screenHeight = screenSize.height;
        int screenWidth = screenSize.width;
        setSize(screenWidth / 4,  screenHeight / 4);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(MainFrame.getInstance());
        setTitle("Info");

        lblD = new JLabel(MainFrame.getInstance().getActionManager().getInfoAction().loadIcon("/images/add.png"));
        lblU = new JLabel(MainFrame.getInstance().getActionManager().getInfoAction().loadIcon("/images/add.png"));
        lblDName = new JLabel("Dusan Colic RN 31/21");
        lblUName = new JLabel("Uros Colic RN 30/21");


        BoxLayout boxLayout = new BoxLayout(getContentPane(), BoxLayout.Y_AXIS);
        getContentPane().setLayout(boxLayout);

        FlowLayout flowLayoutD = new FlowLayout();
        flowLayoutD.setHgap(30);
        flowLayoutD.setAlignment(FlowLayout.CENTER);

        FlowLayout flowLayoutU = new FlowLayout();
        flowLayoutU.setHgap(30);
        flowLayoutU.setAlignment(FlowLayout.CENTER);

        JPanel panelD = new JPanel();
        panelD.setLayout(flowLayoutD);
        panelD.add(lblD);
        panelD.add(lblDName);

        JPanel panelU = new JPanel();
        panelU.setLayout(flowLayoutU);
        panelU.add(lblU);
        panelU.add(lblUName);


        add(panelD);
        add(panelU);

    }






}
