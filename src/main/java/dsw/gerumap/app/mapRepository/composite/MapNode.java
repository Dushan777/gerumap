package dsw.gerumap.app.mapRepository.composite;

import dsw.gerumap.app.gui.swing.observer.IPublisher;
import dsw.gerumap.app.gui.swing.observer.ISubscriber;
import dsw.gerumap.app.mapRepository.implementation.Element;
import dsw.gerumap.app.mapRepository.implementation.MindMap;
import dsw.gerumap.app.mapRepository.implementation.Project;
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
        if(this instanceof Project)
            ((Project) this).setChanged(true);
        if(this instanceof Element){
            if( this.getParent() != null)
                ((Project)(this.getParent()).getParent()).setChanged(true);
        }
        if(this instanceof MindMap){
            if( this.getParent() != null)
                ((Project)this.getParent()).setChanged(true);
        }
        this.notifySubscribers(this);
    }
}
