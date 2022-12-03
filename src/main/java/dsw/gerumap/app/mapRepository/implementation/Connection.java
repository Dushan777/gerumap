package dsw.gerumap.app.mapRepository.implementation;

import dsw.gerumap.app.mapRepository.composite.MapNode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Connection extends Element{

    private Concept firstConcept = null, secondConcept = null;

    public Connection(String name, MapNode parent, Concept firstConcept, Concept secondConcept) {
        super(name, parent);
        this.firstConcept = firstConcept;
        this.secondConcept = secondConcept;
    }
}
