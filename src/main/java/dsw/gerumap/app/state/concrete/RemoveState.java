package dsw.gerumap.app.state.concrete;

import dsw.gerumap.app.gui.swing.view.MindMapView;
import dsw.gerumap.app.mapRepository.command.AbstractCommand;
import dsw.gerumap.app.mapRepository.command.implementation.RemoveCommand;
import dsw.gerumap.app.mapRepository.composite.MapNode;
import dsw.gerumap.app.mapRepository.implementation.Concept;
import dsw.gerumap.app.mapRepository.implementation.Connection;
import dsw.gerumap.app.mapRepository.implementation.Element;
import dsw.gerumap.app.mapRepository.implementation.MindMap;
import dsw.gerumap.app.mapRepository.painters.ConnectionPainter;
import dsw.gerumap.app.mapRepository.painters.Painter;
import dsw.gerumap.app.state.State;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RemoveState extends State {

    private List<Element> elements = new ArrayList<>();
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
                                elements.add(e);
                            //mindMapView.getMapSelectionModel().getSelectedElements().remove(e);
                        }
                    }
                    for(int currCon=0; currCon<number;currCon++)
                    {
                        deleteConnections(mindMap,connection,toBeDeletedArray[currCon],mindMapView);
                    }
                    System.out.println("a");
                    AbstractCommand abstractCommand = new RemoveCommand(mindMap, elements);
                    mindMap.getCommandManager().addCommand(abstractCommand);


                }
                else {
                   Concept concept = (Concept) toBeDeleted.getElement();
                   elements.add(concept);
                   deleteConnections(mindMap,connection,concept,mindMapView);
                   System.out.println("b");
                   AbstractCommand abstractCommand = new RemoveCommand(mindMap, elements);
                   mindMap.getCommandManager().addCommand(abstractCommand);
               }
            }
            else
            {
                connection = (Connection) toBeDeleted.getElement();
                elements.add(connection);
                System.out.println("c");
                AbstractCommand abstractCommand = new RemoveCommand(mindMap, elements);
                mindMap.getCommandManager().addCommand(abstractCommand);
            }

        }
        elements.clear();

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
                            if(connectionPainter.getElement().getName().equals(connection.getName()))
                                elements.add((Connection) mapNode);
                        }
                    }
                }
            }
        }
    }
}