package dsw.gerumap.app.gui.swing.observer;

public interface IPublisher {

  void addSubscribers(ISubscriber sub);
  void removeSubscribers(ISubscriber sub);
  void notifySubscribers(Object nofitication);
}
