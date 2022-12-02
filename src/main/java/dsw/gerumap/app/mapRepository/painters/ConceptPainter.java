package dsw.gerumap.app.mapRepository.painters;

import dsw.gerumap.app.gui.swing.view.MainFrame;
import dsw.gerumap.app.mapRepository.implementation.Concept;
import dsw.gerumap.app.mapRepository.implementation.Element;

import java.awt.*;

public class ConceptPainter extends Painter{

    @Override
    public void draw(Graphics2D g, Element e) {
        Concept concept = (Concept)e;
        g.setPaint(MainFrame.getInstance().getActionManager().getConfirmAction().getColor());
        String name = MainFrame.getInstance().getActionManager().getConfirmAction().getText2();
        if(name != null)
        {
            concept.setName(name);
            g.drawString(concept.getName(), concept.getPosition().x + concept.getHeight()/2, concept.getPosition().y + concept.getWidth()/2);
        }
        g.setStroke(new BasicStroke(MainFrame.getInstance().getActionManager().getConfirmAction().getLineStroke()));
        g.drawOval(concept.getPosition().x, concept.getPosition().y, concept.getHeight(), concept.getWidth());
        //promeniti boju, debljinu linije i tekst da ne bude svima isti, pozicija teksta treba da se stavi da bude unutar elipse
    }
    public ConceptPainter(Element element)
    {
        super(element);
    }

    @Override
    public boolean elementAt(int x, int y) {
        Concept c = (Concept)element;
        int x1 = c.getPosition().x;
        int y1 = c.getPosition().y;
        int height = c.getHeight();
        int width = c.getWidth();
        int centerX = x1+width/2;
        int centerY = y1+height/2;
        int a = (x-centerX)*(x-centerX)/(height/2 * height/2);
        int b = (y-centerY)*(y-centerY)/(width/2 * width/2);
        // x,y koordinate kliknute tacke
        // x1,y1 od elementa
        if(a+b<=1)
            return true;
        return false;

    }


}
