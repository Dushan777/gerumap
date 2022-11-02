package dsw.gerumap.app.gui.swing.view;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.swing.*;

@Getter
@Setter
@NoArgsConstructor
public class TabbedFrame extends JPanel {

    private JTabbedPane tabbedPane;
    public void initialise()
    {


        tabbedPane = new JTabbedPane(JTabbedPane.TOP, JTabbedPane.WRAP_TAB_LAYOUT);
        tabbedPane.addTab("Tab 1", new JPanel());
        tabbedPane.addTab("Tab 2", new JPanel());
        tabbedPane.addTab("Tab 3", new JPanel());

        this.add(tabbedPane);


    }



}
