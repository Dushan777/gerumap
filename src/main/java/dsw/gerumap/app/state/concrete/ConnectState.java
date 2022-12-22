package dsw.gerumap.app.state.concrete;

import dsw.gerumap.app.core.ApplicationFramework;
import dsw.gerumap.app.gui.swing.view.MindMapView;
import dsw.gerumap.app.mapRepository.command.AbstractCommand;
import dsw.gerumap.app.mapRepository.command.implementation.ConnectCommand;
import dsw.gerumap.app.mapRepository.implementation.Concept;
import dsw.gerumap.app.mapRepository.implementation.Connection;
import dsw.gerumap.app.mapRepository.implementation.Element;
import dsw.gerumap.app.mapRepository.implementation.MindMap;
import dsw.gerumap.app.mapRepository.painters.ConnectionPainter;
import dsw.gerumap.app.mapRepository.painters.Painter;
import dsw.gerumap.app.state.State;
import lombok.Getter;
import lombok.Setter;

import java.awt.*;
import java.awt.geom.Line2D;

@Getter
@Setter
public class ConnectState extends State {
    private Concept firstConcept = null;
    private Concept secondConcept = null;
    @Override
    public void misKliknut(MindMapView mindMapView, int x, int y) {
        mindMapView.getMapSelectionModel().getSelectedElements().clear();
        Painter selected = null;
        for(Painter p : mindMapView.getPainters())
        {
            if(p.elementAt(x,y))
            {
                selected = p;
            }
        }
        if(selected == null)
            return;
        Element e = selected.getElement();
        Concept c = null;
        if(e instanceof Concept)
           c = (Concept) e;
        if(c == null)
            return;

        firstConcept = c;

    }

    @Override
    public void misPusten(MindMapView mindMapView, int x, int y) {
        if(firstConcept == null)
            return;
        MindMap mindMap = mindMapView.getMindMap();
        Painter selected = null;
        for(Painter p : mindMapView.getPainters())
        {
            if(p.elementAt(x,y))
            {
                selected = p;
            }
        }
        if(selected == null)
            return;
        Element e = selected.getElement();
        Concept c = null;
        if(e instanceof Concept)
            c = (Concept) e;
        if(c == null)
            return;

        secondConcept = c;
        if(firstConcept.getPosition().getX() == secondConcept.getPosition().getX() && firstConcept.getPosition().getY() == secondConcept.getPosition().getY())
            return;
        Connection connection = new Connection("Connection" + mindMap.getNumberOfChildren(), mindMap, firstConcept, secondConcept);
        connection.setParent(mindMap);
        AbstractCommand abstractCommand = new ConnectCommand(mindMap, connection);
        mindMap.getCommandManager().addCommand(abstractCommand);
        firstConcept = null;
        secondConcept = null;

    }

    @Override
    public void misPrevucen(MindMapView mindMapView, int x, int y) {
        if(firstConcept == null)
            return;
        Graphics2D g = (Graphics2D) mindMapView.getGraphics();
        Shape shape  = new Line2D.Float(firstConcept.getPosition().x,firstConcept.getPosition().y, x, y);
        g.draw(shape);
        mindMapView.repaint();


    }
}
