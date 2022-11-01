package main.java.dsw.gerumap.app.mapRepository.implementation;
import main.java.dsw.gerumap.app.mapRepository.composite.MapNode;
import main.java.dsw.gerumap.app.mapRepository.composite.MapNodeComposite;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter

public class MindMap extends MapNodeComposite {

    private boolean template;

    public MindMap(String name, MapNode parent) {
        super(name, parent);
    }


    @Override
    public void addChild(MapNode child) {
        if(child instanceof Element)
            getChildren().add((Element) child);
    }



}
