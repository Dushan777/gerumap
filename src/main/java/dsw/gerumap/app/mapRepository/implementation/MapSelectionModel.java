package dsw.gerumap.app.mapRepository.implementation;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
public class MapSelectionModel {

    private List<Element> selectedElements = new ArrayList<>();

}
