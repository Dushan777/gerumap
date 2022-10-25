package dsw.gerumap.app.mapRepository.composite;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public abstract class MapNode {

    private String name;
    private MapNode parent;
}
