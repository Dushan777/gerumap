package dsw.gerumap.app.messageGenerator;

import dsw.gerumap.app.core.MessageGenerator;
import dsw.gerumap.app.gui.swing.errorLogger.EventType;
import lombok.Getter;
import lombok.Setter;


import java.text.SimpleDateFormat;
import java.util.Date;


@Getter
@Setter
public class MessageGeneratorImplementation extends MessageGenerator {
    private EventType type;

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
            this.notifySubscribers(new Message("[Error]" + "[" + timeStamp + "] [Must choose a valid value!]"));

    }


}
