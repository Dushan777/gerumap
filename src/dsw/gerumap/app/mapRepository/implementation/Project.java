package dsw.gerumap.app.mapRepository.implementation;

import dsw.gerumap.app.mapRepository.composite.MapNode;
import dsw.gerumap.app.mapRepository.composite.MapNodeComposite;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Project extends MapNodeComposite {

    private String projectName, author, folderDirection;

    @Override
    public void addChild(MapNode child) {

    }

    @Override
    public void deleteChild(MapNode child) {

    }


}
