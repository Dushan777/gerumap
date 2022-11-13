package dsw.gerumap.app.mapRepository.implementation;

import dsw.gerumap.app.gui.swing.view.MainFrame;
import dsw.gerumap.app.mapRepository.composite.MapNode;
import dsw.gerumap.app.mapRepository.composite.MapNodeComposite;
import lombok.Getter;
import lombok.Setter;



@Getter
@Setter
public class ProjectExplorer extends MapNodeComposite {

    public ProjectExplorer(String name) {
        super(name, null);
    }

    @Override
    public void addChild(MapNode child) {
        if(child != null && child instanceof Project)
        {
            Project project = (Project) child;
            if(!this.getChildren().contains(project))
            {
                this.getChildren().add(project);
            }
        }

    }

    @Override
    public void deleteChild(MapNode child) {
        super.deleteChild(child);
        child.removeSubscribers(MainFrame.getInstance().getProjectView());
    }
}
