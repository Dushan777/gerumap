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

    // treba da notifikuje kad se dodaju elementi, metode za dodavanje i brisanje elemenata vrv


}
