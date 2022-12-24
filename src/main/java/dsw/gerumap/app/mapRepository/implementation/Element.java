package dsw.gerumap.app.mapRepository.implementation;

import dsw.gerumap.app.mapRepository.composite.MapNode;
import dsw.gerumap.app.mapRepository.painters.Painter;
import lombok.Getter;
import lombok.Setter;

import java.awt.*;

@Getter
@Setter

public class Element extends MapNode {

    protected int lineStroke;
    protected int color;
    public Element(String name, MapNode parent) {
        super(name, parent);
    }
    public Element()
    {
        this.settName();
    }
    private void settName()
    {
        this.setName("Element");
    }

    public boolean equals2(Object obj)
    {
        return this == obj;
    }

    public void setColor(int color) {
        ((Project)this.getParent().getParent()).setChanged(true);
        this.color = color;
    }

    public void setLineStroke(int lineStroke) {
        ((Project)this.getParent().getParent()).setChanged(true);
        this.lineStroke = lineStroke;
    }

    @Override
    public void setName(String name) {
        super.setName(name);
        ((Project)this.getParent().getParent()).setChanged(true);
    }
}
