package dsw.gerumap.app.mapRepository.implementation;

import dsw.gerumap.app.mapRepository.composite.MapNode;
import dsw.gerumap.app.mapRepository.painters.ConceptPainter;
import lombok.Getter;
import lombok.Setter;

import java.awt.*;

@Getter
@Setter
public class Concept extends Element{

    private boolean selected = false;
    private int height, width, originalX, originalY;
    private Point position;

    public Concept(String name, Point position, int height, int width)
    {
        this.setName(name);
        this.position = position;
        this.height = height;
        this.width = width;
        originalX = position.x;
        originalY = position.y;
    }

    @Override
    public boolean equals(Object obj) {
        Concept c = (Concept) obj;
        return  position.equals(c.getPosition());
    }

    public void setPosition(Point p)
    {
        position.setLocation(p);
        this.notifySubscribers(this);
    }

}
