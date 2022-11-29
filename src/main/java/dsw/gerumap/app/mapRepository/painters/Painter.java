package dsw.gerumap.app.mapRepository.painters;

import dsw.gerumap.app.mapRepository.implementation.Element;
import lombok.Getter;

@Getter

public abstract class Painter {

    protected Element element;
    public void draw()
    {

    }
    public boolean elementAt()
    {
        return false;
    }



}
