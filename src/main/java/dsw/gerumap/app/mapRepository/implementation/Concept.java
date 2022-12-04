package dsw.gerumap.app.mapRepository.implementation;

import dsw.gerumap.app.mapRepository.composite.MapNode;
import dsw.gerumap.app.mapRepository.painters.ConceptPainter;
import lombok.Getter;
import lombok.Setter;

import java.awt.*;

@Getter
@Setter
public class Concept extends Element{

    private String name;
    private boolean selected = false;
    private int height, width;
    private Point position;

    public Concept(String name, Point position, int height, int width)
    {
        this.name = name;
        this.position = position;
        this.height = height;
        this.width = width;
    }

}
