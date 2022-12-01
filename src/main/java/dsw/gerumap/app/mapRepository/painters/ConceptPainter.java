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
            g.drawString(concept.getName(), concept.getPosition().x + 25, concept.getPosition().y + 25);
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
    public boolean elementAt() {
        return false;
    }
}
