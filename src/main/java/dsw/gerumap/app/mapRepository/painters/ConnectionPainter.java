package dsw.gerumap.app.mapRepository.painters;

import dsw.gerumap.app.mapRepository.implementation.Concept;
import dsw.gerumap.app.mapRepository.implementation.Connection;
import dsw.gerumap.app.mapRepository.implementation.Element;

import java.awt.*;
import java.awt.geom.Line2D;

public class ConnectionPainter extends Painter{
    public ConnectionPainter(Element element) {
        super(element);
    }



    @Override
    public void draw(Graphics2D g, Element e) {
        Connection connection = (Connection) e;
        connection.setColor(Color.BLACK.getRGB());
        g.setPaint(Color.BLACK);
        g.setStroke(new BasicStroke(2f));
        g.drawLine(connection.getFirstConcept().getPosition().x, connection.getFirstConcept().getPosition().y,
                connection.getSecondConcept().getPosition().x, connection.getSecondConcept().getPosition().y);

    }

    @Override
    public boolean elementAt(int x, int y) {

        Connection connection = (Connection) element;
        Concept c = new Concept("brisanje", new Point(x,y), 10 ,10);
        Shape shape = new Line2D.Float(connection.getFirstConcept().getPosition().x,connection.getFirstConcept().getPosition().y,connection.getSecondConcept().getPosition().x,connection.getSecondConcept().getPosition().y);
        return shape.intersects(c.getPosition().x, c.getPosition().y, c.getWidth(),c.getHeight());

    }
}
