package dsw.gerumap.app.mapRepository.composite;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public abstract class MapNodeComposite extends MapNode{
    private List<MapNode> nodes;
    public abstract void addChild(MapNode child);

    public void deleteChild(MapNode child)
    {
        if(nodes.size() > 0)
            nodes.remove(child);
    }

}
