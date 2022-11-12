package dsw.gerumap.app.core;

import dsw.gerumap.app.gui.swing.observer.ISubscriber;
import dsw.gerumap.app.messageGenerator.Message;

public interface ErrorLogger extends ISubscriber {
    void log(Message message);
}
