package dsw.gerumap.app.core;

import dsw.gerumap.app.mapRepository.implementation.MindMap;
import dsw.gerumap.app.mapRepository.implementation.Project;

import java.io.File;

public interface Serializer {

    Project loadProject(File file);
    MindMap loadMindMap(File file);
    void saveProject(Project project);
    void saveMindMap(MindMap mindMap);

}
