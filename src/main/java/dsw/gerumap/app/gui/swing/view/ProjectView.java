package dsw.gerumap.app.gui.swing.view;

import dsw.gerumap.app.gui.swing.observer.ISubscriber;
import dsw.gerumap.app.mapRepository.composite.MapNode;
import dsw.gerumap.app.mapRepository.implementation.MindMap;
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
        add(lbl, BorderLayout.NORTH);
        add(tabbedPane);
    }

    private void switchUI()
    {
        lbl.setText(project.toString());
        tabbedPane.removeAll();
        for(MapNode mapNode : project.getChildren())
        {
            MindMap mindMap = (MindMap)mapNode;
            tabbedPane.addTab(mindMap.getName(), new JPanel());
            mindMap.addSubscribers(MainFrame.getInstance().getProjectView());
        }
    }

    @Override
    public void update(Object notification)
    {
        if(notification instanceof Project)
        {
            Project p = (Project) notification;
            lbl.setText(p.toString());               // vidljiva promena
            int numberOfTabs = tabbedPane.getTabCount();
            int numberOfChildren = p.getChildren().size();

            if(numberOfTabs > numberOfChildren)
            {
                for(int j = 0; j < numberOfTabs; j++)
                {
                    boolean flag = false;
                    for(MapNode mapNode : p.getChildren())
                        if (tabbedPane.getTitleAt(j).equals(mapNode.getName()))
                            flag = true;

                    if(!flag)
                    {
                        tabbedPane.removeTabAt(j);
                        numberOfTabs--;
                    }
                }
            }

            else if(numberOfTabs < numberOfChildren)
            {
                for(MapNode mapNode : p.getChildren())
                {
                    boolean flag = false;
                    for(int j = 0; j < numberOfTabs; j++)
                    {
                        if (tabbedPane.getTitleAt(j).equals(mapNode.getName()))
                        {
                            flag = true;
                            break;
                        }
                    }
                    if(!flag)
                        tabbedPane.addTab(mapNode.getName(), new JPanel());
                }
            }
        }
        if(notification instanceof MindMap)
             mindMapTabNames((Project) ((MindMap)notification).getParent());
    }
    private void mindMapTabNames(Project p)
    {
        List<String> childrenNames = new ArrayList<>();
        List<String> tabNames = new ArrayList<>();

        for(MapNode mapNode : p.getChildren())
            childrenNames.add(mapNode.getName());

        for(int i = 0; i < tabbedPane.getTabCount(); i++)
            tabNames.add(tabbedPane.getTitleAt(i));

        for(String s : childrenNames)
        {
            if(tabNames.contains(s))
                continue;
            tabbedPane.setTitleAt(childrenNames.indexOf(s),s);
        }
    }

    public void setProject(Project project) {
        if(this.project != null)
            this.project.removeSubscribers(this);
        this.project = project;
        if(this.project == null)
            return ;
        this.project.addSubscribers(this);
        switchUI();
    }
}
