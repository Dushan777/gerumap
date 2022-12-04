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
    public void draw(Graphics2D g, Element e) {
        Connection connection = (Connection) e;
        connection.setColor(Color.BLACK);
        g.setPaint(Color.BLACK);
        g.setStroke(new BasicStroke(3f));
        g.drawLine(connection.getFirstConcept().getPosition().x, connection.getFirstConcept().getPosition().y,
                connection.getSecondConcept().getPosition().x, connection.getSecondConcept().getPosition().y);

    }

    @Override
    public boolean elementAt(int x, int y) {
        Connection connection = (Connection) element;
        double firstx = connection.getFirstConcept().getPosition().getX();
        double firsty = connection.getFirstConcept().getPosition().getY();
        double secondx = connection.getSecondConcept().getPosition().getX();
        double secondy = connection.getSecondConcept().getPosition().getY();
        double k = (firsty - secondy)/(firstx - secondx);
        double rez = y - firsty - k * x + k * firstx;
        return rez > -2 && rez < 2;
    }
}
