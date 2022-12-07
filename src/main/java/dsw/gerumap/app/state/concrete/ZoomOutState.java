package dsw.gerumap.app.state.concrete;

import dsw.gerumap.app.gui.swing.view.MindMapView;
import dsw.gerumap.app.state.State;

import java.awt.*;

public class ZoomOutState extends State {
    @Override
    public void misKliknut(MindMapView mindMapView, int x, int y) {
        Graphics2D g = (Graphics2D) mindMapView.getGraphics();
        if(mindMapView.getPercentageZoomed() > 0.4)
            mindMapView.setPercentageZoomed(mindMapView.getPercentageZoomed() - 0.2);
        mindMapView.repaint();
    }
}
