package main.java.dsw.gerumap.app.mapRepository.implementation;

import main.java.dsw.gerumap.app.mapRepository.composite.MapNode;
import main.java.dsw.gerumap.app.mapRepository.composite.MapNodeComposite;
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
        if(child instanceof Project)
            getChildren().add((Project) child);

    }


}
