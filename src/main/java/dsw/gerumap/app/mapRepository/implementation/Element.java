package dsw.gerumap.app.mapRepository.implementation;

import dsw.gerumap.app.mapRepository.composite.MapNode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Element extends MapNode {

    public Element(String name, MapNode parent) {
        super(name, parent);
    }
}
