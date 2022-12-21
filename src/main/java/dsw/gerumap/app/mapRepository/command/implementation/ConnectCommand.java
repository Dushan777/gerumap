package dsw.gerumap.app.mapRepository.command.implementation;

import dsw.gerumap.app.gui.swing.view.MainFrame;
import dsw.gerumap.app.gui.swing.view.MindMapView;
import dsw.gerumap.app.mapRepository.command.AbstractCommand;
import dsw.gerumap.app.mapRepository.implementation.Concept;
import dsw.gerumap.app.mapRepository.implementation.Connection;
import dsw.gerumap.app.mapRepository.implementation.MindMap;
import dsw.gerumap.app.mapRepository.painters.ConnectionPainter;
import dsw.gerumap.app.mapRepository.painters.Painter;

import java.util.Iterator;

public class ConnectCommand extends AbstractCommand {

    private Connection connection;
    private MindMapView mindMapView = (MindMapView) MainFrame.getInstance().getProjectView().getTabbedPane().getSelectedComponent();
    private ConnectionPainter connectionPainter;
    private MindMap mindMap;
    public ConnectCommand(Connection connection, MindMap mindMap) {
        this.connection = connection;
        this.mindMap = mindMap;

    }

    @Override
    public void doCommand() {
        for(Painter connectionPainter1 : mindMapView.getPainters()) {
            if (connectionPainter1 instanceof ConnectionPainter) {
                if (connectionPainter1.getElement().getName().equals(connection.getName()))
                    connectionPainter = (ConnectionPainter) connectionPainter1;
            }
        }
        
        mindMapView.getPainters().add(connectionPainter);
        mindMap.addChild(connection);

    }

    @Override
    public void undoCommand() {
        Iterator<Painter> iterator = mindMapView.getPainters().iterator();
        while(iterator.hasNext())
        {
            Painter p = iterator.next();
            if(p instanceof ConnectionPainter)
                if (p.getElement().getName().equals(connection.getName()))
                    iterator.remove();
        }
        mindMap.deleteChild(connection);

    }
}
