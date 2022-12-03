package dsw.gerumap.app.mapRepository.painters;

import dsw.gerumap.app.gui.swing.view.MainFrame;
import dsw.gerumap.app.mapRepository.implementation.Connection;
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
        Connection connection = (Connection) e;
        connection.setColor(Color.BLACK);
        g.setPaint(Color.BLACK);
        g.drawLine(connection.getFirstConcept().getPosition().x, connection.getFirstConcept().getPosition().y,
                connection.getSecondConcept().getPosition().x, connection.getSecondConcept().getPosition().y);

    }


}
