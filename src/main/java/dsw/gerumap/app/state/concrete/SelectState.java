package dsw.gerumap.app.state.concrete;

import dsw.gerumap.app.gui.swing.view.MindMapView;
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

    }

    @Override
    public void misPusten(MindMapView mindMapView, int x, int y) {

    }
}
