package dsw.gerumap.app.mapRepository.implementation;
import dsw.gerumap.app.gui.swing.observer.IPublisher;
import dsw.gerumap.app.mapRepository.composite.MapNode;
import dsw.gerumap.app.mapRepository.composite.MapNodeComposite;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter

public class MindMap extends MapNodeComposite {

    private boolean template;
    private int numberOfChildren = 0;

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
            numberOfChildren++;
            //child umesto this za notification
            this.notifySubscribers(child);
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
    @Override
    public void deleteChild(MapNode child) {
        super.deleteChild(child);
        this.notifySubscribers(this);
    }
}
