package dsw.gerumap.app.mapRepository.painters;

import dsw.gerumap.app.mapRepository.implementation.Element;

import java.awt.*;

public class ConnectionPainter extends Painter{
    public ConnectionPainter(Element element) {
        super(element);
    }

    @Override
    public boolean elementAt(int x, int y) {
        return false;
    }

    @Override
    public void draw(Graphics2D g, Element e) {

    }


}
