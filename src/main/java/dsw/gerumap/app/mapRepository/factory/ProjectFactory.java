package dsw.gerumap.app.mapRepository.factory;

import dsw.gerumap.app.mapRepository.composite.MapNode;
import dsw.gerumap.app.mapRepository.implementation.Project;

public class ProjectFactory extends NodeFactory{
    @Override
    public MapNode createNode() {
       return new Project();
    }
}
