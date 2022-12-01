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
        g.setStroke(new BasicStroke(MainFrame.getInstance().getActionManager().getConfirmAction().getLineStroke()));
        g.drawOval(concept.getPosition().x, concept.getPosition().y, concept.getHeight(), concept.getWidth());

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
