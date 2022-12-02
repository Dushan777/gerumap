package dsw.gerumap.app.state.concrete;

import dsw.gerumap.app.gui.swing.view.MainFrame;
import dsw.gerumap.app.gui.swing.view.MindMapView;
import dsw.gerumap.app.mapRepository.composite.MapNode;
import dsw.gerumap.app.mapRepository.implementation.Concept;
import dsw.gerumap.app.mapRepository.implementation.Element;
import dsw.gerumap.app.mapRepository.implementation.MindMap;
import dsw.gerumap.app.mapRepository.painters.ConceptPainter;
import dsw.gerumap.app.mapRepository.painters.Painter;
import dsw.gerumap.app.state.State;

public class SelectState extends State {

    @Override
    public void mousePressed(MindMapView mindMapView, int x, int y) {
        MindMap mindMap = mindMapView.getMindMap();
        Painter toBeSelected = null;
        for(Painter p : mindMapView.getPainters())
        {
            if(p.elementAt(x,y))
            {
                toBeSelected = p;
            }
        }
        if(toBeSelected != null)
        {
            Element e = toBeSelected.getElement();
            int newStroke = e.getLineStroke() + 3;
            mindMapView.getPainters().remove(toBeSelected);
            mindMap.deleteChild(e);
            // svima menja debljinu, kad god se klikne poveca debljinu
            Concept c  = new Concept(((Concept)e).getName(), ((Concept)e).getPosition(), ((Concept)e).getHeight(), ((Concept)e).getWidth());
            c.setLineStroke(newStroke);
            MainFrame.getInstance().getActionManager().getConfirmAction().setLineStroke(newStroke);
            mindMapView.getPainters().add(new ConceptPainter(c));
            MainFrame.getInstance().getActionManager().getConfirmAction().setLineStroke(e.getLineStroke());
            mindMap.addChild(c);






        }

    }
}
