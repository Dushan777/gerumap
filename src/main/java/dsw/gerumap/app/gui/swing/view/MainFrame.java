package dsw.gerumap.app.gui.swing.view;

import dsw.gerumap.app.core.ApplicationFramework;
import dsw.gerumap.app.gui.swing.controller.ActionManager;
import dsw.gerumap.app.gui.swing.observer.ISubscriber;
import dsw.gerumap.app.gui.swing.tree.MapTree;
import dsw.gerumap.app.gui.swing.tree.MapTreeImplementation;
import dsw.gerumap.app.gui.swing.tree.view.MapTreeView;
import dsw.gerumap.app.mapRepository.implementation.Project;
import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
import java.awt.*;
@Getter
@Setter
public class MainFrame extends JFrame implements ISubscriber {

    private static MainFrame instance;
    private ActionManager actionManager;
    private JMenuBar menu;
    private JToolBar toolBar;
    private MapTree mapTree;

    private MapTreeView projectExplorer;

    private JLabel lbl;
    private JTabbedPane tabbedPane;
    private String authorName, projectName; // TODO

    private MainFrame()
    {

    }

    private void initialise()
    {
        actionManager = new ActionManager();
        mapTree = new MapTreeImplementation();
        projectExplorer = mapTree.generateTree(ApplicationFramework.getInstance().getMapRepository().getProjectExplorer());
        initialiseGUI(projectExplorer);
    }

    private void initialiseGUI(MapTreeView projectExplorer) {

        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        int screenHeight = screenSize.height;
        int screenWidth = screenSize.width;
        setSize(screenWidth / 2,  screenHeight / 2);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("GeRuMap app");

        menu = new MyMenuBar();
        setJMenuBar(menu);

        toolBar = new Toolbar();
        add(toolBar,BorderLayout.NORTH);

        lbl = new JLabel("");


        tabbedPane = new JTabbedPane(SwingConstants.TOP);
        JPanel jPanel1 = new JPanel();
        JPanel jPanel2 = new JPanel();
        JPanel jPanel3 = new JPanel();
        tabbedPane.addTab("Tab 1", jPanel1);
        tabbedPane.addTab("Tab 2", jPanel2);
        tabbedPane.addTab("Tab 3", jPanel3);


        JPanel desktop = new JPanel(new BorderLayout());
        desktop.add(lbl, BorderLayout.NORTH);
        desktop.add(tabbedPane);


        JScrollPane scroll = new JScrollPane(projectExplorer);
        scroll.setMinimumSize(new Dimension(200,150));
        JSplitPane split = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,scroll,desktop);
        getContentPane().add(split,BorderLayout.CENTER);

        split.setDividerLocation(250);
        split.setOneTouchExpandable(true);


    }

    public static MainFrame getInstance()
    {
        if(instance == null)
        {
            instance = new MainFrame();
            instance.initialise();
        }

        return instance;
    }

    public ActionManager getActionManager()
    {
        return  actionManager;
    }


    @Override
    public void update(Object notification)
    {
        if(notification instanceof Project)
        {
            Project p = (Project) notification;
            lbl.setText(p.toString());    // vidljiva promena
        }

    }
}
