package dsw.gerumap.app.mapRepository.composite;

import dsw.gerumap.app.gui.swing.observer.IPublisher;
import dsw.gerumap.app.gui.swing.observer.ISubscriber;
import dsw.gerumap.app.gui.swing.tree.controller.MapTreeCellEditor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.EventObject;
import java.util.List;

@Getter
@Setter
public abstract class MapNode implements IPublisher {

    private String name;

    private List<ISubscriber> subscribers;


    @ToString.Exclude
    private MapNode parent;

    public MapNode(String name, MapNode parent) {
        this.name = name;
        this.parent = parent;
        subscribers = new ArrayList<>();

    }

    @Override
    public boolean equals(Object obj) {
        if (obj != null && obj instanceof MapNode) {
            MapNode otherObj = (MapNode) obj;
            return this.getName().equals(otherObj.getName());
        }
        return false;
    }
    @Override
    public void addSubscribers(ISubscriber sub) {
        if(sub == null)
            return;
        if(this.subscribers == null)
            this.subscribers = new ArrayList<>();
        if(this.subscribers.contains(sub))
            return;
        this.subscribers.add(sub);


    }

    @Override
    public void removeSubscribers(ISubscriber sub) {
        if(sub == null || this.subscribers == null || !this.subscribers.contains(sub))
            return;
        this.subscribers.remove(sub);
    }

    @Override
    public void notifySubscribers(Object notification) {
        if(notification == null || this.subscribers == null || this.subscribers.isEmpty())
            return;

        for(ISubscriber listener : subscribers){
            listener.update(notification);
        }
    }

    public boolean doubleClicked(MapTreeCellEditor map) {
       if(map.getBrojac() == 2)
           return true;
       return false;
    }
    public void setName(String name) {
        this.name = name;
        this.notifySubscribers(this);
    }
}
