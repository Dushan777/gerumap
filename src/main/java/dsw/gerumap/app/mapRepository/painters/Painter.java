package dsw.gerumap.app.mapRepository.painters;

import dsw.gerumap.app.mapRepository.implementation.Element;
import lombok.Getter;

@Getter

public abstract class Painter {

    protected Element element;
    protected void draw()
    {

    }
    protected Element elementAt()
    {

        return null;
    }



}
