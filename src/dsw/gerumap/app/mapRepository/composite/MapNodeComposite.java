package dsw.gerumap.app.mapRepository.composite;

import java.util.List;

public abstract class MapNodeComposite extends MapNode{
    private List<MapNode> nodes;
    public abstract void addChild(MapNode child);

    public void deleteChild(MapNode child)
    {
        if(nodes.size() > 0)
            nodes.remove(child);
    }

}
