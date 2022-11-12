package dsw.gerumap.app.gui.swing.errorLogger;

import dsw.gerumap.app.core.ErrorLogger;
import dsw.gerumap.app.messageGenerator.Message;

public class ConsoleLogger implements ErrorLogger {
    @Override
    public void log(Message msg) {
        System.out.println(msg.toString());
    }

    @Override
    public void update(Object notification) {
            log((Message) notification);
    }
}
