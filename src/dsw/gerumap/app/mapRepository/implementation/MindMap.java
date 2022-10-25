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
public class MindMap extends MapNodeComposite {

    private boolean template;
    private List<Element> elements;


    @Override
    public void addChild(MapNode child) {
        if(child instanceof Element)
            elements.add((Element) child);
    }

    @Override
    public void deleteChild(MapNode child) {
        if(elements.size() != 0)
            elements.remove((Element)child);
    }

}
