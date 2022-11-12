package dsw.gerumap.app.core;


import dsw.gerumap.app.gui.swing.observer.IPublisher;

public interface MessageGenerator extends IPublisher {

    void generateMessage();
}
