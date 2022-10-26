package dsw.gerumap.app.core;

import dsw.gerumap.app.mapRepository.implementation.ProjectExplorer;

public interface MapRepository {

    void initialise();
    ProjectExplorer getProjectExplorer();

}
