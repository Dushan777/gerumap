package dsw.gerumap.app.mapRepository.composite;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class MapNode {

    private String name;
    private MapNode parent;
}
