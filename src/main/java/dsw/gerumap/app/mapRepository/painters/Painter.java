package dsw.gerumap.app.mapRepository.painters;

import dsw.gerumap.app.mapRepository.implementation.Element;
import lombok.Getter;

import java.awt.*;

@Getter

public abstract class Painter {

    protected Element element;
    public void draw(Graphics2D g, Element e)
    {

    }

    public Painter(Element element) {
        this.element = element;
    }

    public abstract boolean elementAt();




}
