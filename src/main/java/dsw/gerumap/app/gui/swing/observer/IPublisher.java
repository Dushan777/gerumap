package dsw.gerumap.app.gui.swing.observer;

import java.util.ArrayList;
import java.util.List;

public abstract class IPublisher {

    transient List<ISubscriber> subscribers = null;
    public void addSubscribers(ISubscriber sub) {
    if(sub == null)
      return;
    if(this.subscribers == null)
      this.subscribers = new ArrayList<>();
    if(this.subscribers.contains(sub))
      return;
    this.subscribers.add(sub);
  }


    public void removeSubscribers(ISubscriber sub) {
    if(sub == null || this.subscribers == null || !this.subscribers.contains(sub))
      return;
    this.subscribers.remove(sub);
  }


    public void notifySubscribers(Object notification) {
    if(notification == null || this.subscribers == null || this.subscribers.isEmpty())
      return;

    for(ISubscriber listener : subscribers){
      listener.update(notification);
    }
  }
}
