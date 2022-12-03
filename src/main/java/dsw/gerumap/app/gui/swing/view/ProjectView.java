
package dsw.gerumap.app.gui.swing.view;

import dsw.gerumap.app.gui.swing.observer.ISubscriber;
import dsw.gerumap.app.mapRepository.composite.MapNode;
import dsw.gerumap.app.mapRepository.factory.MindMapFactory;
import dsw.gerumap.app.mapRepository.implementation.MindMap;
import dsw.gerumap.app.mapRepository.implementation.Project;
import dsw.gerumap.app.state.StateManager;
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
    //    private List<MindMapView> mindMapViews;
    private Project project;
    private JToolBar mindMapToolbar;
    private StateManager stateManager;
    public ProjectView()
    {
        initialise();
    }

    private  void initialise()
    {

        stateManager = new StateManager();
        // mindMapViews = new ArrayList<>();
        this.setLayout(new BorderLayout());
        lbl = new JLabel(" ");
        tabbedPane = new JTabbedPane(SwingConstants.TOP);
        mindMapToolbar = new MindMapToolbar();
        add(mindMapToolbar, BorderLayout.EAST);
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
            MindMapView mindMapView = new MindMapView(mindMap);
//            if(!mindMapViews.contains(mindMapView))
//                mindMapViews.add(mindMapView);
            tabbedPane.addTab(mindMap.getName(),mindMapView);
            mindMap.addSubscribers(MainFrame.getInstance().getProjectView());
            mindMap.addSubscribers(mindMapView);
        }
    }

    @Override
    public void update(Object notification) {
        if (notification instanceof Project) {
            Project p = (Project) notification;
            lbl.setText(p.toString());               // vidljiva promena
            int numberOfTabs = tabbedPane.getTabCount();
            int numberOfChildren = p.getChildren().size();

            if (numberOfTabs > numberOfChildren) {
                for (int j = 0; j < numberOfTabs; j++) {
                    boolean flag = false;
                    for (MapNode mapNode : p.getChildren())
                        if (tabbedPane.getTitleAt(j).equals(mapNode.getName()))
                            flag = true;

                    if (!flag) {
                        tabbedPane.removeTabAt(j);
                        numberOfTabs--;
                    }
                }
            } else if (numberOfTabs < numberOfChildren) {
                for (MapNode mapNode : p.getChildren()) {
                    boolean flag = false;
                    for (int j = 0; j < numberOfTabs; j++) {
                        if (tabbedPane.getTitleAt(j).equals(mapNode.getName())) {
                            flag = true;
                            break;
                        }
                    }
                    if (!flag) {
                        MindMapView mindMapView = new MindMapView((MindMap) mapNode);
                        ((MindMap) mapNode).addSubscribers(mindMapView);
                        tabbedPane.addTab(mindMapView.getMindMap().getName(), mindMapView);
//                        if (!mindMapViews.contains(mindMapView))
//                            mindMapViews.add(mindMapView);
                    }
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

    public void misKliknut(MindMapView mindMapView, int x, int y)
    {
        stateManager.getCurrentState().misKliknut(mindMapView, x, y);
    }
    // za svaku metodu u mouseController-u postoji metoda u ProjectView-u i u State-u
    // paintComponent se poziva metodom repaint, ne drugacije

    public void misPusten(MindMapView mindMapView, int x, int y)
    {
        stateManager.getCurrentState().misPusten(mindMapView, x, y);
    }

    public void misPrevucen(MindMapView mindMapView, int x, int y)
    {
        stateManager.getCurrentState().misPrevucen(mindMapView, x, y);
    }

    public void startAddState()
    {
        this.stateManager.setAddState();
    }
    public void startSelectState()
    {
        this.stateManager.setSelectState();
    }
    public void startConnectState()
    {
        this.stateManager.setConnectState();
    }
    public void startMoveState()
    {
        this.stateManager.setMoveState();
    }
    public void startRemoveState()
    {
        this.stateManager.setRemoveState();
    }
    public void startZoomState()
    {
        this.stateManager.setZoomState();
    }
    public void startColorState()
    {
        this.stateManager.setColorState();
    }
}