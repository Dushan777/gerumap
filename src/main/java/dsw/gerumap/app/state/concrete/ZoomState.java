package dsw.gerumap.app.state.concrete;

import dsw.gerumap.app.gui.swing.view.MindMapView;
import dsw.gerumap.app.state.State;


public class ZoomState extends State {
    @Override
    public void misKliknut(MindMapView mindMapView, int x, int y) {
       mindMapView.getMapSelectionModel().getSelectedElements().clear();
       if(mindMapView.getTimesZoomed() < 2)
           mindMapView.setTimesZoomed(mindMapView.getTimesZoomed() + 0.2);
       mindMapView.repaint();
    }
}
