package dsw.gerumap.app.state.concrete;

import dsw.gerumap.app.gui.swing.view.MainFrame;
import dsw.gerumap.app.gui.swing.view.MindMapView;
import dsw.gerumap.app.mapRepository.composite.MapNode;
import dsw.gerumap.app.mapRepository.composite.MapNodeComposite;
import dsw.gerumap.app.mapRepository.implementation.Concept;
import dsw.gerumap.app.mapRepository.implementation.Element;
import dsw.gerumap.app.mapRepository.implementation.MindMap;
import dsw.gerumap.app.mapRepository.painters.ConceptPainter;
import dsw.gerumap.app.mapRepository.painters.Painter;
import dsw.gerumap.app.state.State;

import java.awt.*;

public class SelectState extends State {

    @Override
    public void misKliknut(MindMapView mindMapView, int x, int y) {
        MindMap mindMap = mindMapView.getMindMap();
        Painter toBeSelected = null;
        for(Painter p : mindMapView.getPainters())
        {
            if(p.elementAt(x,y))
            {
                toBeSelected = p;
                for(MapNode mapNode : mindMap.getChildren())
                    System.out.println(mapNode.getName());
            }
        }
        if(toBeSelected != null && toBeSelected.getElement() instanceof Concept)
        {
            Element e = toBeSelected.getElement();
            mindMapView.getPainters().remove(toBeSelected);
            mindMap.deleteChild(e);
            Concept c  = new Concept(((Concept)e).getName(), ((Concept)e).getPosition(), ((Concept)e).getHeight(), ((Concept)e).getWidth());
            c.setSelected(true);
            c.setColor(((Concept)e).getColor());
            c.setLineStroke(((Concept)e).getLineStroke());
            mindMapView.getPainters().add(new ConceptPainter(c));
            mindMap.addChild(c);

        }


    }
}
