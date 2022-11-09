package dsw.gerumap.app.mapRepository.factory;

import dsw.gerumap.app.mapRepository.composite.MapNode;
import dsw.gerumap.app.mapRepository.implementation.Project;
import dsw.gerumap.app.mapRepository.implementation.ProjectExplorer;

public class FactoryUtils {

    public static MapNode getFactory(MapNode mapNode)
    {
        if(mapNode instanceof ProjectExplorer)
            return null;
        else if(mapNode instanceof Project)
            return null;
        else if(mapNode instanceof MapNode)
            return null;

        return null;
    }

}
