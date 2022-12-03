package dsw.gerumap.app.state.concrete;

import dsw.gerumap.app.gui.swing.view.MindMapView;
import dsw.gerumap.app.mapRepository.composite.MapNode;
import dsw.gerumap.app.mapRepository.implementation.Concept;
import dsw.gerumap.app.mapRepository.implementation.Connection;
import dsw.gerumap.app.mapRepository.implementation.MindMap;
import dsw.gerumap.app.mapRepository.painters.ConnectionPainter;
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
        if(toBeDeleted != null) {
            if (toBeDeleted.getElement() instanceof Concept)
            {
                Concept concept = (Concept) toBeDeleted.getElement();
                Connection connection = null;
                boolean flag = false;
                mindMapView.getPainters().remove(toBeDeleted);
                mindMap.deleteChild(toBeDeleted.getElement());
                for (MapNode mapNode : mindMap.getChildren())
                {
                    if (mapNode instanceof Connection) {
                        connection = (Connection) mapNode;
                        if ((connection.getFirstConcept().getPosition().getX() == concept.getPosition().getX() &&
                                connection.getFirstConcept().getPosition().getY() == concept.getPosition().getY()) ||
                                (connection.getSecondConcept().getPosition().getX() == concept.getPosition().getX() &&
                                        connection.getSecondConcept().getPosition().getY() == concept.getPosition().getY())) {
                            flag = true;
                        }
                    }
                }
                System.out.println(flag);
                if(flag)
                {
                    mindMap.deleteChild(connection);
                    ConnectionPainter connectionPainter = null;
                    flag = false;
                    for(Painter p : mindMapView.getPainters())
                    {
                        if(p instanceof ConnectionPainter)
                        {
                            connectionPainter = (ConnectionPainter) p;
                            if(connectionPainter.getElement().equals(connection))
                                flag = true;
                        }
                    }
                    if(flag)
                        mindMapView.getPainters().remove(connectionPainter);
                }
                // ako je pojam obrisati i njegovu vezu, proci kroz sve veze iz mape uma
                // ako je jedan od njenih pojmova onda se brise
            }

        }
    }
}