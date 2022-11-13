package dsw.gerumap.app.mapRepository.implementation;
import dsw.gerumap.app.mapRepository.composite.MapNode;
import dsw.gerumap.app.mapRepository.composite.MapNodeComposite;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter

public class MindMap extends MapNodeComposite {

    private boolean template;
    public MindMap(String name, MapNode parent) {
        super(name, parent);
    }

    public MindMap()
    {
        this.settName();
    }
    @Override
    public void addChild(MapNode child) {
        if(child instanceof Element)
        {
            getChildren().add((Element) child);
        }
    }

    private void settName()
    {
        this.setName("MindMap");
    }

    @Override
    public void setName(String name) {
        super.setName(name);
        this.notifySubscribers(this);
    }
}
