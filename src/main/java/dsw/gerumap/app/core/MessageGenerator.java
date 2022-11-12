package dsw.gerumap.app.core;


import dsw.gerumap.app.gui.swing.observer.IPublisher;
import dsw.gerumap.app.messageGenerator.Message;

public interface MessageGenerator extends IPublisher {

    Message generateMessage();
}
