package dsw.gerumap.app.mapRepository.composite;

import dsw.gerumap.app.gui.swing.observer.IPublisher;
import dsw.gerumap.app.gui.swing.observer.ISubscriber;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public abstract class MapNode extends IPublisher {

    private String name;

    private transient List<ISubscriber> subscribers;


    @ToString.Exclude
    private transient MapNode parent;

    public MapNode(String name, MapNode parent) {
        this.name = name;
        this.parent = parent;
        subscribers = new ArrayList<>();

    }

    public MapNode(){}
    @Override
    public boolean equals(Object obj) {
        if (obj != null && obj instanceof MapNode) {
            MapNode otherObj = (MapNode) obj;
            return this.getName().equals(otherObj.getName());
        }
        return false;
    }


    public void setName(String name) {
        this.name = name;
        this.notifySubscribers(this);
    }
}
