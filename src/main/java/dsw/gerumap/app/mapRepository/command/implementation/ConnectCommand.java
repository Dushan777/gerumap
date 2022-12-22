package dsw.gerumap.app.mapRepository.command.implementation;

import dsw.gerumap.app.mapRepository.command.AbstractCommand;
import dsw.gerumap.app.mapRepository.implementation.Connection;
import dsw.gerumap.app.mapRepository.implementation.MindMap;



public class ConnectCommand extends AbstractCommand {

    private MindMap mindMap;
    private Connection connection;

    public ConnectCommand(MindMap mindMap, Connection connection) {
        this.mindMap = mindMap;
        this.connection = connection;
    }

    @Override
    public void doCommand() {
        if(connection == null ||  mindMap == null)
            return;

        mindMap.addChild(connection);

    }

    @Override
    public void undoCommand() {
        if(connection == null || mindMap == null)
            return;

        mindMap.deleteChild(connection);
    }
}
