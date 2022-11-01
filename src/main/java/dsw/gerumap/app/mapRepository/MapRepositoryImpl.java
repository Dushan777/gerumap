package main.java.dsw.gerumap.app.mapRepository;

import main.java.dsw.gerumap.app.core.MapRepository;
import main.java.dsw.gerumap.app.mapRepository.composite.MapNode;
import main.java.dsw.gerumap.app.mapRepository.composite.MapNodeComposite;
import main.java.dsw.gerumap.app.mapRepository.implementation.ProjectExplorer;

public class MapRepositoryImpl implements MapRepository {

    private ProjectExplorer projectExplorer;

    public MapRepositoryImpl() {
        projectExplorer = new ProjectExplorer("My Project Explorer");
    }

    @Override
    public ProjectExplorer getProjectExplorer() {
        return projectExplorer;
    }

    @Override
    public void addChild(MapNodeComposite parent, MapNode child) {
        //TODO: implement add Child method
    }
}
