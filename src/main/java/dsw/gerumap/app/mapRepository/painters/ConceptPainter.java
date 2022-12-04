package dsw.gerumap.app.mapRepository.painters;

import dsw.gerumap.app.gui.swing.view.MainFrame;
import dsw.gerumap.app.mapRepository.implementation.Concept;
import dsw.gerumap.app.mapRepository.implementation.Element;

import java.awt.*;

public class ConceptPainter extends Painter{

    @Override
    public void draw(Graphics2D g, Element e) {
        Concept concept = (Concept)e;
        String name = concept.getName();

        if(name != null)
        {
            g.setPaint(Color.BLACK);
            g.drawString(concept.getName(), concept.getPosition().x + concept.getHeight()/5+9 - concept.getHeight()/2, concept.getPosition().y);
        }
        g.setPaint(concept.getColor());
        g.setStroke(new BasicStroke(concept.getLineStroke()));
        g.drawOval(concept.getPosition().x - concept.getHeight()/2, concept.getPosition().y - concept.getWidth()/2, concept.getHeight(), concept.getWidth());
        if(concept.isSelected())
        {
            g.fillOval(concept.getPosition().x - concept.getHeight() / 2, concept.getPosition().y - concept.getWidth() / 2, concept.getHeight(), concept.getWidth());
            if(concept.getColor().equals(Color.BLACK))
                g.setPaint(Color.LIGHT_GRAY);
            else
                g.setPaint(Color.BLACK);
            g.drawString(concept.getName(), concept.getPosition().x + concept.getHeight()/5+9 - concept.getHeight()/2, concept.getPosition().y);
            concept.setSelected(false);
        }
    }
    public ConceptPainter(Element element)
    {
        super(element);
    }

    @Override
    public boolean elementAt(int x, int y)
    {
            Concept c = (Concept) element;
            int x1 = c.getPosition().x - c.getHeight() / 2;
            int y1 = c.getPosition().y - c.getWidth() / 2;
            int height = c.getHeight();
            int width = c.getWidth();
            int centerX = x1 + height / 2;
            int k = MainFrame.getInstance().getActionManager().getColorChooserAction().getTextFieldText().getText().length();
            int centerY = y1 + width / 2;
            int a = (centerX - x) * (centerX - x) / ((height / 2 - k) * (height / 2 - k));
            int b = (centerY - y) * (centerY - y) / ((width / 2 - k / 3) * (width / 2 - k / 3));
            // x,y koordinate kliknute tacke
            // x1,y1 od elementa
            if (a + b <= 1)
                return true;
            return false;
    }


}
