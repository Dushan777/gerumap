package dsw.gerumap.app.state.concrete;

import dsw.gerumap.app.gui.swing.view.MindMapView;
import dsw.gerumap.app.mapRepository.composite.MapNode;
import dsw.gerumap.app.mapRepository.implementation.MindMap;
import dsw.gerumap.app.mapRepository.painters.Painter;
import dsw.gerumap.app.state.State;

public class RemoveState extends State {
    @Override
    public void misKliknut(MindMapView mindMapView, int x, int y) {
        MindMap mindMap = mindMapView.getMindMap();
        Painter toBeDeleted = null;
        for(Painter p : mindMapView.getPainters())
        {
            if(p.elementAt(x,y))
            {
                toBeDeleted = p;
            }
        }
        if(toBeDeleted != null)
        {
            mindMapView.getPainters().remove(toBeDeleted);
            mindMap.deleteChild(toBeDeleted.getElement());
        }


    }
}
