package dsw.gerumap.app.mapRepository.implementation;

import dsw.gerumap.app.mapRepository.composite.MapNode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Element extends MapNode {

    private static int br = 1;
    public Element(String name, MapNode parent) {
        super(name, parent);
    }
    public Element()
    {
        this.settName();
    }
    private void settName()
    {
        this.setName("Element" + br++);
    }
}
