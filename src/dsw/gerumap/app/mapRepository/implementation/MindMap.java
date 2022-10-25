package dsw.gerumap.app.mapRepository.implementation;

import dsw.gerumap.app.mapRepository.composite.MapNode;
import dsw.gerumap.app.mapRepository.composite.MapNodeComposite;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
public class MindMap extends MapNodeComposite {

    private boolean template;


    @Override
    public void addChild(MapNode child) {
        if(child instanceof Element)
            getNodes().add((Element) child);
    }



}
