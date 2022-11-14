package dsw.gerumap.app.core;


import dsw.gerumap.app.gui.swing.observer.IPublisher;
import dsw.gerumap.app.gui.swing.observer.ISubscriber;

import java.util.List;

public abstract class MessageGenerator extends IPublisher {

    List<ISubscriber> subscribers = null;
    public void generateMessage()
    {

    }

}
