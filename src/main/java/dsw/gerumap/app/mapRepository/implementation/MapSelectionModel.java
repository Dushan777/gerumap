package dsw.gerumap.app.mapRepository.implementation;

import dsw.gerumap.app.gui.swing.observer.IPublisher;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
public class MapSelectionModel extends IPublisher {

    private List<Element> selectedElements = new ArrayList<>();
    public void selectElement(Element element)
    {
        if(!selectedElements.contains(element) && element != null)
        {
            selectedElements.add(element);
            this.notifySubscribers(this);
        }
    }
    public void deselectElements()
    {
        selectedElements.clear();
        this.notifySubscribers(this);
    }


}
