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

    /*    double firstx = connection.getFirstConcept().getPosition().getX();
        double firsty = connection.getFirstConcept().getPosition().getY();
        double secondx = connection.getSecondConcept().getPosition().getX();
        double secondy = connection.getSecondConcept().getPosition().getY();
        if((firstx < secondx && firstx <= x && secondx >=x) || (firstx > secondx && firstx >= x && secondx <=x) ) {
            double k = (firsty - secondy) / (firstx - secondx);
            double rez = y - firsty - k * x + k * firstx;
            return rez > -3 && rez < 3;
        }
        // ako su firstx i secondx jednaki - ne brise
        if(firstx == secondx && firstx == x)
        {
            return (firsty > secondy && firsty >= y && secondy <= y) || ((firsty < secondy && firsty <= y && secondy >= y));

        }

         return false;*/
    }
}
