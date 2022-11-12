package dsw.gerumap.app.messageGenerator;

import dsw.gerumap.app.gui.swing.errorLogger.EventType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Message {
    private String messageText;
    private EventType type;
    public Message(String messageText, EventType type)
    {
        this.messageText = messageText;
        this.type = type;
    }
    public Message(String messageText)
    {
        this.messageText = messageText;
    }



}
