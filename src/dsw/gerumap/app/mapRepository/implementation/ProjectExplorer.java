package dsw.gerumap.app.mapRepository.implementation;

import dsw.gerumap.app.mapRepository.composite.MapNode;
import dsw.gerumap.app.mapRepository.composite.MapNodeComposite;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor

public class ProjectExplorer extends MapNodeComposite {

    private List<Project> projects;

    @Override
    public void addChild(MapNode child) {
        if(child instanceof Project)
            projects.add((Project) child);

    }

    // get project expl, init

}
