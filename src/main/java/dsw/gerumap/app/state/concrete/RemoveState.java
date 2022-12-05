package dsw.gerumap.app.state.concrete;

import dsw.gerumap.app.gui.swing.view.MindMapView;
import dsw.gerumap.app.mapRepository.composite.MapNode;
import dsw.gerumap.app.mapRepository.implementation.Concept;
import dsw.gerumap.app.mapRepository.implementation.Connection;
import dsw.gerumap.app.mapRepository.implementation.MindMap;
import dsw.gerumap.app.mapRepository.painters.ConnectionPainter;
import dsw.gerumap.app.mapRepository.painters.Painter;
import dsw.gerumap.app.state.State;

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
        // ubaciti iterator zbog brisanja elementa kad ima dve veze mozda
        if(toBeDeleted != null) {
            Connection connection = null;
            boolean flag = false;
            if (toBeDeleted.getElement() instanceof Concept)
            {
                Concept concept = (Concept) toBeDeleted.getElement();
                mindMapView.getPainters().remove(toBeDeleted);
                mindMap.deleteChild(concept);
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
                // ako je pojam obrisati i njegovu vezu, proci kroz sve veze iz mape uma
                // ako je jedan od njenih pojmova onda se brise
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
}