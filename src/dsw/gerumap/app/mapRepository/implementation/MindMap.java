package dsw.gerumap.app.mapRepository.implementation;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MindMap {

    private boolean template;

    public MindMap(boolean template)
    {
        this.template = template;
    }

}
