package dsw.gerumap.app.mapRepository.implementation;

import dsw.gerumap.app.mapRepository.composite.MapNode;
import dsw.gerumap.app.mapRepository.composite.MapNodeComposite;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MindMap extends MapNodeComposite {

    private boolean template;

    public MindMap(boolean template)
    {
        this.template = template;
    }

    @Override
    public void addChild(MapNode child) {


    }

    @Override
    public void deleteChild(MapNode child) {

    }

}
