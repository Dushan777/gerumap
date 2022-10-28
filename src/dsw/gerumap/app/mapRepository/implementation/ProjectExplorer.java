package dsw.gerumap.app.mapRepository.implementation;

import dsw.gerumap.app.mapRepository.composite.MapNode;
import dsw.gerumap.app.mapRepository.composite.MapNodeComposite;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Getter
@Setter
@AllArgsConstructor
public class ProjectExplorer extends MapNodeComposite {

    @Override
    public void addChild(MapNode child) {
        if(child instanceof Project)
            getNodes().add((Project) child);

    }


}
