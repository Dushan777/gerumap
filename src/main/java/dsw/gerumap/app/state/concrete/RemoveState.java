package dsw.gerumap.app.state.concrete;

import dsw.gerumap.app.gui.swing.view.MindMapView;
import dsw.gerumap.app.mapRepository.composite.MapNode;
import dsw.gerumap.app.mapRepository.implementation.Concept;
import dsw.gerumap.app.mapRepository.implementation.Connection;
import dsw.gerumap.app.mapRepository.implementation.Element;
import dsw.gerumap.app.mapRepository.implementation.MindMap;
import dsw.gerumap.app.mapRepository.painters.ConnectionPainter;
import dsw.gerumap.app.mapRepository.painters.Painter;
import dsw.gerumap.app.state.State;

import java.awt.*;
import java.util.Iterator;

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
        if(toBeDeleted != null) {
            Connection connection = null;
            boolean flag = false;
            if (toBeDeleted.getElement() instanceof Concept)
            {
               if(!mindMapView.getMapSelectionModel().getSelectedElements().isEmpty())
                {
                    Iterator<Painter> iterator = mindMapView.getPainters().iterator();
                    Concept[] toBeDeletedArray = new Concept[mindMapView.getMapSelectionModel().getSelectedElements().size()];
                    int number = 0;
                    while(iterator.hasNext())
                    {
                        Element e = iterator.next().getElement();
                        if(e instanceof Concept)
                            if(mindMapView.getMapSelectionModel().getSelectedElements().contains(e)) {
                                toBeDeletedArray[number++] = (Concept) e;
                            mindMap.deleteChild(e);
                            mindMapView.getMapSelectionModel().getSelectedElements().remove(e);
                            iterator.remove();
                        }
                    }
                    for(int currCon=0; currCon<number;currCon++)
                    {
                        deleteConnections(mindMap,connection,toBeDeletedArray[currCon],mindMapView);
                    }

                }
                else {
                   Concept concept = (Concept) toBeDeleted.getElement();
                   mindMapView.getPainters().remove(toBeDeleted);
                   mindMap.deleteChild(concept);
                   deleteConnections(mindMap,connection,concept,mindMapView);
               }
            }
            else
            {
                connection = (Connection) toBeDeleted.getElement();
                ConnectionPainter connectionPainter = null;
                flag = false;
                for(Painter p : mindMapView.getPainters())
                {
                    if(p instanceof ConnectionPainter)
                    {
                        connectionPainter = (ConnectionPainter) p;
                        if(connectionPainter.getElement().getName().equals(connection.getName()))
                        {
                            flag = true;
                            break;
                        }
                    }
                }
                if(flag)
                    mindMapView.getPainters().remove(connectionPainter);
                mindMap.deleteChild(connection);
            }

        }
    }
    private void deleteConnections(MindMap mindMap, Connection connection, Concept concept, MindMapView mindMapView)
    {
        Iterator<MapNode> iterator = mindMap.getChildren().iterator();
        while(iterator.hasNext())
        {
            MapNode mapNode = iterator.next();
            if (mapNode instanceof Connection) {
                connection = (Connection) mapNode;
                if ((connection.getFirstConcept().getPosition().getX() == concept.getPosition().getX() &&
                        connection.getFirstConcept().getPosition().getY() == concept.getPosition().getY()) ||
                        (connection.getSecondConcept().getPosition().getX() == concept.getPosition().getX() &&
                                connection.getSecondConcept().getPosition().getY() == concept.getPosition().getY()))
                {
                    ConnectionPainter connectionPainter = null;
                    Iterator<Painter> painterIterator = mindMapView.getPainters().iterator();
                    while(painterIterator.hasNext())
                    {
                        Painter p = painterIterator.next();
                        if(p instanceof ConnectionPainter)
                        {
                            connectionPainter = (ConnectionPainter) p;
                            if(connectionPainter.getElement().getName().equals(connection.getName())) {
                                painterIterator.remove();
                                iterator.remove();
                            }
                        }
                    }


                }
            }
        }
    }
}