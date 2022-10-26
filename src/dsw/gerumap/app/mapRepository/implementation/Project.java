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
@NoArgsConstructor
public class Project extends MapNodeComposite {

    private String projectName, author, folderDirection;

    @Override
    public void addChild(MapNode child) {
        if(child instanceof MindMap)
            getNodes().add((MindMap) child);

    }




}
