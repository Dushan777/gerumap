package main.java.dsw.gerumap.app.core;

import main.java.dsw.gerumap.app.mapRepository.composite.MapNode;
import main.java.dsw.gerumap.app.mapRepository.composite.MapNodeComposite;
import main.java.dsw.gerumap.app.mapRepository.implementation.ProjectExplorer;

public interface MapRepository {


    ProjectExplorer getProjectExplorer();
    void addChild(MapNodeComposite parent, MapNode child);
}
