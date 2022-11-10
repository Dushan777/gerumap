package dsw.gerumap.app.mapRepository.factory;

import dsw.gerumap.app.mapRepository.composite.MapNode;
import dsw.gerumap.app.mapRepository.implementation.MindMap;
import dsw.gerumap.app.mapRepository.implementation.Project;
import dsw.gerumap.app.mapRepository.implementation.ProjectExplorer;

public class FactoryUtils {

    private static final ProjectFactory p = new ProjectFactory();
    private static final MindMapFactory m = new MindMapFactory();
    private static final ElementFactory e = new ElementFactory();
    public static NodeFactory getFactory(MapNode mapNode)
    {
        if(mapNode instanceof ProjectExplorer)
            return p;
        else if(mapNode instanceof Project)
            return m;
        else if(mapNode instanceof MindMap)
            return e;

        return null;
    }

}
