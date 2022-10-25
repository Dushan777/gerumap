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
public class Project extends MapNodeComposite {

    private String projectName, author, folderDirection;
    private List<MindMap> mindMaps;

    @Override
    public void addChild(MapNode child) {
        if(child instanceof MindMap)
            mindMaps.add((MindMap) child);
    }




}
