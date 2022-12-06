package dsw.gerumap.app.state.concrete;

import dsw.gerumap.app.gui.swing.view.MindMapView;
import dsw.gerumap.app.mapRepository.implementation.Concept;
import dsw.gerumap.app.mapRepository.implementation.Element;
import dsw.gerumap.app.mapRepository.implementation.MindMap;
import dsw.gerumap.app.mapRepository.painters.ConceptPainter;
import dsw.gerumap.app.mapRepository.painters.Painter;
import dsw.gerumap.app.state.State;
import lombok.Getter;
import lombok.Setter;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

@Getter
@Setter
public class SelectState extends State {

    private int x1, y1;
    @Override
    public void misKliknut(MindMapView mindMapView, int x, int y) {
        x1 = x;
        y1 = y;
        Painter toBeSelected = null;
        for(Painter p : mindMapView.getPainters())
        {
            if(p.elementAt(x,y))
            {
                toBeSelected = p;
            }
        }
        if(toBeSelected != null && toBeSelected.getElement() instanceof Concept)
        {
            Element e = toBeSelected.getElement();
            Concept c = (Concept) e;
            c.setSelected(true);
            if(mindMapView.getMapSelectionModel().getSelectedElements() != null)
                mindMapView.getMapSelectionModel().deselectElements();
            mindMapView.getMapSelectionModel().selectElement(e);

        }
        if(toBeSelected == null)
            mindMapView.getMapSelectionModel().deselectElements();
    }

    @Override
    public void misPrevucen(MindMapView mindMapView, int x, int y) {
        int width = x1 - x;
        int height = y1 - y;
        if(width < 0)
            width = width * -1;
        if(height < 0)
            height = height * -1;
        Rectangle2D shape;
        if(x1 < x && y1 < y)                              // kada vuce od gornjeg levog ugla
             shape = new Rectangle2D.Float(x1,y1,width,height);
        else if(x1 > x && y1 < y)                         // kada vuce od gornjeg desnog ugla
             shape = new Rectangle2D.Float(x1-width,y1,width,height);
        else if(x1 < x && y1 > y)                         // kada vuce od donjeg levog ugla
             shape = new Rectangle2D.Float(x1,y1-height,width,height);
        else                                              // kada vuce od donjeg desnog ugla
             shape = new Rectangle2D.Float(x,y,width,height);
        Graphics2D g = (Graphics2D) mindMapView.getGraphics();
        g.draw(shape);
        mindMapView.repaint();
        Shape shape2 = null;
        for(Painter p : mindMapView.getPainters())
        {
            if(p instanceof ConceptPainter)
            {
                Concept c = (Concept)p.getElement();
                 shape2 = new Ellipse2D.Float(c.getPosition().x - c.getHeight()/2,c.getPosition().y - c.getWidth()/2,c.getHeight(),c.getWidth());
                 if(shape2.intersects(shape))
                 {
                     System.out.println(c.getName());
                 }
            }

        }
    }

    @Override
    public void misPusten(MindMapView mindMapView, int x, int y) {
    }
}
