package dsw.gerumap.app.state.concrete;

import dsw.gerumap.app.gui.swing.view.MindMapView;
import dsw.gerumap.app.state.State;

public class ZoomState extends State {
    @Override
    public void mousePressed(MindMapView mindMapView, int x, int y) {
        System.out.println("zoom");
    }
}
