package dsw.gerumap.app.gui.swing.view;

import dsw.gerumap.app.gui.swing.observer.ISubscriber;
import dsw.gerumap.app.gui.swing.tree.controller.MapTreeCellEditor;
import dsw.gerumap.app.gui.swing.tree.controller.MapTreeSelectionListener;
import dsw.gerumap.app.gui.swing.tree.model.MapTreeItem;
import dsw.gerumap.app.mapRepository.implementation.Project;
import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class ProjectView extends JPanel implements ISubscriber {

    private JLabel lbl;
    private JTabbedPane tabbedPane;
    private List<MindMapView> mindMapViews;
    private Project project;

    public ProjectView()
    {
        initialise();
    }

    private  void initialise()
    {

        mindMapViews = new ArrayList<>();
        this.setLayout(new BorderLayout());
        lbl = new JLabel(" ");

        tabbedPane = new JTabbedPane(SwingConstants.TOP);
        JPanel jPanel1 = new JPanel();
        JPanel jPanel2 = new JPanel();
        JPanel jPanel3 = new JPanel();
        tabbedPane.addTab("Tab 1", jPanel1);
        tabbedPane.addTab("Tab 2", jPanel2);
        tabbedPane.addTab("Tab 3", jPanel3);
        add(lbl, BorderLayout.NORTH);
        add(tabbedPane);
    }



    @Override
    public void update(Object notification)
    {

        if(notification instanceof Project)
        {
            Project p = (Project) notification;
            lbl.setText(p.toString());               // vidljiva promena
        }

    }

    public void setProject(Project project) {
        this.project.removeSubscribers(this);
        this.project = project;
        project.addSubscribers(this);
    }
}
