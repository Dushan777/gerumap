package dsw.gerumap.app.state.concrete;


import dsw.gerumap.app.gui.swing.view.MindMapView;
import dsw.gerumap.app.mapRepository.implementation.Concept;
import dsw.gerumap.app.mapRepository.implementation.MindMap;
import dsw.gerumap.app.mapRepository.painters.ConceptPainter;
import dsw.gerumap.app.state.State;

import java.awt.*;

public class AddState extends State {
    @Override
    public void mousePressed(MindMapView mindMapView, int x, int y)
    {
        MindMap mindMap = mindMapView.getMindMap();
        Concept concept = new Concept("Concept", new Point(x, y), 70, 40);
        mindMapView.getPainters().add(new ConceptPainter(concept));
        mindMap.addChild(concept);
    }
}
