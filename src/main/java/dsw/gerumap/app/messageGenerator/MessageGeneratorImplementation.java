package dsw.gerumap.app.messageGenerator;

import dsw.gerumap.app.core.MessageGenerator;
import dsw.gerumap.app.gui.swing.errorLogger.EventType;
import dsw.gerumap.app.gui.swing.observer.ISubscriber;
import lombok.Getter;
import lombok.Setter;


import java.text.SimpleDateFormat;
import java.util.Date;
@Getter
@Setter
public class MessageGeneratorImplementation implements MessageGenerator {
    private EventType type;
    @Override
    public Message generateMessage() {

        String timeStamp = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss").format(new Date());

        if(type.equals(EventType.CANNOT_ADD_CHILD))
            return new Message("[Error]" + "[" + timeStamp + "] [Child cannot be added!]");
        if(type.equals(EventType.CANNOT_REMOVE))
            return new Message("[Error]" + "[" + timeStamp + "] [ProjectExplorer cannot be removed!]");
        if(type.equals(EventType.CANNOT_SET_AUTHOR))
            return new Message("[Error]" + "[" + timeStamp + "] [Cannot set author for elements that are not projects!]");
        if(type.equals(EventType.NAME_CANNOT_BE_EMPTY))
            return new Message("[Error]" + "[" + timeStamp + "] [Cannot set an empty name!]");
        return null;
    }

    @Override
    public void addSubscribers(ISubscriber sub) {

    }

    @Override
    public void removeSubscribers(ISubscriber sub) {

    }

    @Override
    public void notifySubscribers(Object nofitication) {

    }
}
