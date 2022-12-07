package dsw.gerumap.app.state.concrete;

import dsw.gerumap.app.gui.swing.view.MindMapView;
import dsw.gerumap.app.state.State;

import java.awt.*;
import java.awt.geom.AffineTransform;

public class ZoomState extends State {
    @Override
    public void misKliknut(MindMapView mindMapView, int x, int y) {

       if(mindMapView.getPercentageZoomed() < 2)
           mindMapView.setPercentageZoomed(mindMapView.getPercentageZoomed() + 0.2);
       mindMapView.repaint();
    }
}
