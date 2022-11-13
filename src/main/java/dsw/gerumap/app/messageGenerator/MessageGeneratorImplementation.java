package dsw.gerumap.app.messageGenerator;

import dsw.gerumap.app.core.MessageGenerator;
import dsw.gerumap.app.gui.swing.errorLogger.EventType;
import dsw.gerumap.app.gui.swing.observer.ISubscriber;
import lombok.Getter;
import lombok.Setter;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
public class MessageGeneratorImplementation implements MessageGenerator {
    private EventType type;
    List<ISubscriber> subscribers;
    @Override
    public void generateMessage() {

        String timeStamp = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss").format(new Date());

        if(type.equals(EventType.CANNOT_ADD_CHILD))
            this.notifySubscribers(new Message("[Error]" + "[" + timeStamp + "] [Child cannot be added!]"));
        if(type.equals(EventType.CANNOT_REMOVE))
            this.notifySubscribers(new Message("[Error]" + "[" + timeStamp + "] [ProjectExplorer cannot be removed!]"));
        if(type.equals(EventType.CANNOT_SET_AUTHOR))
            this.notifySubscribers(new Message("[Error]" + "[" + timeStamp + "] [Cannot set author for nodes that are not projects!]"));
        if(type.equals(EventType.NAME_CANNOT_BE_EMPTY))
            this.notifySubscribers(new Message("[Error]" + "[" + timeStamp + "] [Cannot set an empty name!]"));
        if(type.equals(EventType.NOTHING_IS_SELECTED))
            this.notifySubscribers(new Message("[Error]" + "[" + timeStamp + "] [Must select a node!]"));
        if(type.equals(EventType.CANNOT_SET_NAME))
            this.notifySubscribers(new Message("[Error]" + "[" + timeStamp + "] [Must choose a valid name!]"));

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
}
